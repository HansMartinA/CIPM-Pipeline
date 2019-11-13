/**
 */
package dmodel.pipeline.dt.callgraph.ServiceCallGraph.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraph;
import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraphEdge;
import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraphFactory;
import dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraphPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServiceCallGraphPackageImpl extends EPackageImpl implements ServiceCallGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceCallGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceCallGraphEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeListEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dmodel.pipeline.dt.callgraph.ServiceCallGraph.ServiceCallGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServiceCallGraphPackageImpl() {
		super(eNS_URI, ServiceCallGraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ServiceCallGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServiceCallGraphPackage init() {
		if (isInited) return (ServiceCallGraphPackage)EPackage.Registry.INSTANCE.getEPackage(ServiceCallGraphPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredServiceCallGraphPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ServiceCallGraphPackageImpl theServiceCallGraphPackage = registeredServiceCallGraphPackage instanceof ServiceCallGraphPackageImpl ? (ServiceCallGraphPackageImpl)registeredServiceCallGraphPackage : new ServiceCallGraphPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theServiceCallGraphPackage.createPackageContents();

		// Initialize created meta-data
		theServiceCallGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServiceCallGraphPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServiceCallGraphPackage.eNS_URI, theServiceCallGraphPackage);
		return theServiceCallGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getServiceCallGraph() {
		return serviceCallGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraph_Nodes() {
		return (EReference)serviceCallGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraph_Edges() {
		return (EReference)serviceCallGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraph_OutgoingEdges() {
		return (EReference)serviceCallGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraph_IncomingEdges() {
		return (EReference)serviceCallGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getServiceCallGraph__AddNode__ResourceDemandingSEFF() {
		return serviceCallGraphEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getServiceCallGraph__AddEdge__ResourceDemandingSEFF_ResourceDemandingSEFF_int() {
		return serviceCallGraphEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getServiceCallGraphEdge() {
		return serviceCallGraphEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraphEdge_From() {
		return (EReference)serviceCallGraphEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceCallGraphEdge_To() {
		return (EReference)serviceCallGraphEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getServiceCallGraphEdge_Value() {
		return (EAttribute)serviceCallGraphEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeList() {
		return edgeListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEdgeList_Key() {
		return (EAttribute)edgeListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeList_Value() {
		return (EReference)edgeListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceCallGraphFactory getServiceCallGraphFactory() {
		return (ServiceCallGraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		serviceCallGraphEClass = createEClass(SERVICE_CALL_GRAPH);
		createEReference(serviceCallGraphEClass, SERVICE_CALL_GRAPH__NODES);
		createEReference(serviceCallGraphEClass, SERVICE_CALL_GRAPH__EDGES);
		createEReference(serviceCallGraphEClass, SERVICE_CALL_GRAPH__OUTGOING_EDGES);
		createEReference(serviceCallGraphEClass, SERVICE_CALL_GRAPH__INCOMING_EDGES);
		createEOperation(serviceCallGraphEClass, SERVICE_CALL_GRAPH___ADD_NODE__RESOURCEDEMANDINGSEFF);
		createEOperation(serviceCallGraphEClass, SERVICE_CALL_GRAPH___ADD_EDGE__RESOURCEDEMANDINGSEFF_RESOURCEDEMANDINGSEFF_INT);

		serviceCallGraphEdgeEClass = createEClass(SERVICE_CALL_GRAPH_EDGE);
		createEReference(serviceCallGraphEdgeEClass, SERVICE_CALL_GRAPH_EDGE__FROM);
		createEReference(serviceCallGraphEdgeEClass, SERVICE_CALL_GRAPH_EDGE__TO);
		createEAttribute(serviceCallGraphEdgeEClass, SERVICE_CALL_GRAPH_EDGE__VALUE);

		edgeListEClass = createEClass(EDGE_LIST);
		createEAttribute(edgeListEClass, EDGE_LIST__KEY);
		createEReference(edgeListEClass, EDGE_LIST__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(serviceCallGraphEClass, ServiceCallGraph.class, "ServiceCallGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceCallGraph_Nodes(), theSeffPackage.getResourceDemandingSEFF(), null, "nodes", null, 0, -1, ServiceCallGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCallGraph_Edges(), this.getServiceCallGraphEdge(), null, "edges", null, 0, -1, ServiceCallGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCallGraph_OutgoingEdges(), this.getEdgeList(), null, "outgoingEdges", null, 0, -1, ServiceCallGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCallGraph_IncomingEdges(), this.getEdgeList(), null, "incomingEdges", null, 0, -1, ServiceCallGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getServiceCallGraph__AddNode__ResourceDemandingSEFF(), null, "addNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSeffPackage.getResourceDemandingSEFF(), "seff", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getServiceCallGraph__AddEdge__ResourceDemandingSEFF_ResourceDemandingSEFF_int(), null, "addEdge", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSeffPackage.getResourceDemandingSEFF(), "from", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSeffPackage.getResourceDemandingSEFF(), "to", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(serviceCallGraphEdgeEClass, ServiceCallGraphEdge.class, "ServiceCallGraphEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceCallGraphEdge_From(), theSeffPackage.getResourceDemandingSEFF(), null, "from", null, 0, 1, ServiceCallGraphEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceCallGraphEdge_To(), theSeffPackage.getResourceDemandingSEFF(), null, "to", null, 0, 1, ServiceCallGraphEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceCallGraphEdge_Value(), ecorePackage.getEInt(), "value", null, 0, 1, ServiceCallGraphEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeListEClass, Map.Entry.class, "EdgeList", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEdgeList_Key(), ecorePackage.getEJavaObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeList_Value(), this.getServiceCallGraphEdge(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ServiceCallGraphPackageImpl
