package dmodel.pipeline.vsum.domains.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Maps;

public class JavaCorrespondenceModelImpl implements IJavaPCMCorrespondenceModel {
	private Map<String, String> seffMapping;
	private Map<String, String> loopMapping;
	private Map<String, String> branchMapping;
	private Map<Pair<String, String>, String> actionMapping;

	public JavaCorrespondenceModelImpl() {
		seffMapping = Maps.newHashMap();
		loopMapping = Maps.newHashMap();
		branchMapping = Maps.newHashMap();
		actionMapping = Maps.newHashMap();
	}

	@Override
	public void addSeffCorrespondence(String javaMethodId, String seffId) {
		seffMapping.put(javaMethodId, seffId);
	}

	@Override
	public void addLoopCorrespondence(String javaLoopId, String loopId) {
		loopMapping.put(javaLoopId, loopId);
	}

	@Override
	public void addBranchCorrespondence(String javaBranchId, String transitionId) {
		branchMapping.put(javaBranchId, transitionId);
	}

	@Override
	public void addInternalActionCorrespondence(String startExprId, String endExprId, String actionId) {
		actionMapping.put(Pair.of(startExprId, endExprId), actionId);
	}

	@Override
	public List<Pair<String, String>> getSeffCorrespondences() {
		return seffMapping.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue())).collect(Collectors.toList());
	}

	@Override
	public List<Pair<String, String>> getLoopCorrespondences() {
		return loopMapping.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue())).collect(Collectors.toList());
	}

	@Override
	public List<Pair<String, String>> getBranchCorrespondences() {
		return branchMapping.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Pair<Pair<String, String>, String>> getInternalActionCorrespondences() {
		return actionMapping.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	@Override
	public String getCorrespondingSeffId(String javaMethodId) {
		return seffMapping.get(javaMethodId);
	}

	@Override
	public String getCorrespondingLoopId(String javaLoopId) {
		return loopMapping.get(javaLoopId);
	}

	@Override
	public String getCorrespondingBranchId(String javaBranchId) {
		return branchMapping.get(javaBranchId);
	}

	@Override
	public String getCorrespondingActionId(String startExprId, String endExprId) {
		return actionMapping.get(Pair.of(startExprId, endExprId));
	}

	@Override
	public void clear() {
		seffMapping.clear();
		loopMapping.clear();
		branchMapping.clear();
		actionMapping.clear();
	}

}
