package dmodel.pipeline.dt.system.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.springframework.stereotype.Component;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.resolution.SymbolResolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import dmodel.pipeline.core.facade.pcm.IRepositoryQueryFacade;
import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraph;
import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraphFactory;
import dmodel.pipeline.dt.system.ISystemCompositionAnalyzer;
import dmodel.pipeline.instrumentation.project.ParsedApplicationProject;
import dmodel.pipeline.instrumentation.tuid.JavaTuidGeneratorAndResolver;
import dmodel.pipeline.vsum.domains.java.IJavaPCMCorrespondenceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

@Component
@Log
public class StaticCodeReferenceAnalyzer implements ISystemCompositionAnalyzer {
	private JavaTuidGeneratorAndResolver tuidResolver;

	public StaticCodeReferenceAnalyzer() {
		this.tuidResolver = new JavaTuidGeneratorAndResolver();
	}

	@Override
	public ServiceCallGraph deriveSystemComposition(ParsedApplicationProject parsedApplication,
			List<File> binaryJarFiles, IRepositoryQueryFacade repository, IJavaPCMCorrespondenceModel correspondence) {
		ServiceCallGraph output = ServiceCallGraphFactory.eINSTANCE.createServiceCallGraph();

		CombinedTypeSolver typeSolver = new CombinedTypeSolver(new ReflectionTypeSolver());
		for (File jarFile : binaryJarFiles) {
			try {
				typeSolver.add(new JarTypeSolver(jarFile));
			} catch (IOException e) {
				log.warning("Failed to resolve JAR '" + jarFile.getAbsolutePath() + "'.");
			}
		}
		JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);

		AnalyzerData analyzerData = new AnalyzerData(parsedApplication, typeSolver, symbolSolver, output, repository,
				correspondence);

		correspondence.getSeffCorrespondences().forEach(seffCorrespondence -> {
			MethodDeclaration method = tuidResolver.resolveMethod(parsedApplication, seffCorrespondence.getLeft());
			inspectMethodDeclaration(analyzerData, method, seffCorrespondence.getRight());
		});

		return output;
	}

	private void inspectMethodDeclaration(AnalyzerData data, MethodDeclaration method, String seffId) {
		ResourceDemandingSEFF seff = data.repository.getServiceById(seffId);
		if (seff != null) {
			// get method declarations
			List<MethodCallExpr> innerMethodCalls = method.findAll(MethodCallExpr.class);
			for (MethodCallExpr methodCall : innerMethodCalls) {
				inspectMethodCall(data, methodCall, seff);
			}
		}
	}

	private void inspectMethodCall(AnalyzerData data, MethodCallExpr methodCall, ResourceDemandingSEFF source) {
		for (Pair<String, String> seffCorrespondence : data.cpm.getSeffCorrespondences()) {
			MethodDeclaration correspondingMethod = this.tuidResolver.resolveMethod(data.pap,
					seffCorrespondence.getLeft());
			if (methodConformsTo(data, correspondingMethod, methodCall)) {
				String externalCallId = getExternalCallId(data, methodCall);
				ExternalCallAction externalCallAction = data.repository.getElementById(externalCallId,
						ExternalCallAction.class);

				ResourceDemandingSEFF target = data.repository.getServiceById(seffCorrespondence.getRight());
				data.graph.incrementEdge(source, target, null, null, externalCallAction);
			}
		}
	}

	private String getExternalCallId(AnalyzerData data, Node node) {
		String foundId = null;
		while (node.getParentNode().isPresent()) {
			node = node.getParentNode().get();
			if (node instanceof Statement) {
				foundId = data.cpm.getCorrespondingExternalCallId(this.tuidResolver.generateId((Statement) node));
				if (foundId != null) {
					return foundId;
				}
			}
		}

		return foundId;
	}

	private boolean methodConformsTo(AnalyzerData data, MethodDeclaration correspondingMethod,
			MethodCallExpr methodCall) {
		if (methodCall.getScope().isPresent()) {
			if (correspondingMethod.getNameAsString().equals(methodCall.getNameAsString())) {
				Expression scope = methodCall.getScope().get();

				ResolvedType scopeType = JavaParserFacade.get(data.solver).getType(scope);
				SymbolReference<ResolvedMethodDeclaration> methodDefReference = JavaParserFacade.get(data.solver)
						.solve(methodCall);

				ResolvedType declarationType = JavaParserFacade.get(data.solver).getTypeOfThisIn(correspondingMethod);

				boolean subType = isSubtypeOf(declarationType, scopeType);
				boolean methodsEqual = methodSignatureEqual(
						data.symbolSolver.resolveDeclaration(correspondingMethod, ResolvedMethodDeclaration.class),
						methodDefReference.getCorrespondingDeclaration());

				return subType && methodsEqual;
			}
		}

		return false;
	}

	private boolean methodSignatureEqual(ResolvedMethodDeclaration meth1, ResolvedMethodDeclaration meth2) {
		return meth1.getQualifiedSignature().equals(meth1.getQualifiedSignature());
	}

	private boolean isSubtypeOf(ResolvedType target, ResolvedType parent) {
		return parent.isAssignableBy(target);
	}

	@Data
	@AllArgsConstructor
	private class AnalyzerData {
		ParsedApplicationProject pap;
		TypeSolver solver;
		SymbolResolver symbolSolver;
		ServiceCallGraph graph;
		IRepositoryQueryFacade repository;
		IJavaPCMCorrespondenceModel cpm;
	}

}
