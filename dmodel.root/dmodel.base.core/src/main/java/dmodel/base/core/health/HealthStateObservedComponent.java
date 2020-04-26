package dmodel.base.core.health;

import lombok.Getter;

public enum HealthStateObservedComponent {
	VSUM_MANAGER("VSUM Manager"), CONFIGURATION("Configuration"), MODEL_MANAGER("Model Manager"),
	PROJECT_MANAGER("Project Manager"), SCG_BUILDER("Service-Call-Graph Builder"),
	INSTRUMENTATION_MANAGER("Instrumentation Manager"), DT_SYSTEM_BUILDER("Design-Time System Model Extractor"),
	PIPELINE("Pipeline"), VALIDATION_CONTROLLER("Validation Controller");

	@Getter
	private String name;

	private HealthStateObservedComponent(String name) {
		this.name = name;
	}
}