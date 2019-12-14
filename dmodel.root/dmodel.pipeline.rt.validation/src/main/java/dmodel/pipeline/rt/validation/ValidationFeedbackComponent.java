package dmodel.pipeline.rt.validation;

import java.util.List;

import org.pcm.headless.shared.data.results.InMemoryResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dmodel.pipeline.models.mapping.PalladioRuntimeMapping;
import dmodel.pipeline.monitoring.records.RecordWithSession;
import dmodel.pipeline.rt.validation.data.ValidationData;
import dmodel.pipeline.rt.validation.data.ValidationMetricValue;
import dmodel.pipeline.rt.validation.data.metric.IValidationMetric;
import dmodel.pipeline.rt.validation.eval.ValidationDataExtractor;
import dmodel.pipeline.rt.validation.simulation.HeadlessPCMSimulator;
import dmodel.pipeline.shared.pcm.InMemoryPCM;

@Component
public class ValidationFeedbackComponent implements IValidationProcessor {
	@Autowired
	private HeadlessPCMSimulator simulator;

	@Autowired
	private ValidationDataExtractor extractor;

	@Autowired
	private List<IValidationMetric<?>> metrics;

	public ValidationFeedbackComponent() {
	}

	@Override
	public ValidationData process(InMemoryPCM instance, PalladioRuntimeMapping mapping,
			List<RecordWithSession> monitoringData, String taskName) {
		// 1. simulate it
		InMemoryResultRepository analysisResults = simulator.simulateBlocking(instance, taskName);
		if (analysisResults == null) {
			return null;
		}

		// 2. enrich with data
		ValidationData preparedData = extractor.extractValidationData(analysisResults, instance, mapping,
				monitoringData);

		// 3. derive metrics
		preparedData.getValidationPoints().stream().forEach(valPoint -> {
			metrics.forEach(metric -> {
				if (metric.isTarget(valPoint)) {
					ValidationMetricValue result = metric.calculate(valPoint);
					if (result != null)
						valPoint.getMetricValues().add(result);
				}
			});
		});

		return preparedData;
	}

	public void clearSimulationData() {
		simulator.clearAllSimulationData();
	}
}