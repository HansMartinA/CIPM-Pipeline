package dmodel.pipeline.rt.pcm.usagemodel.data;

import java.util.List;

import org.palladiosimulator.pcm.usagemodel.OpenWorkload;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;

import com.google.common.collect.Lists;

import dmodel.pipeline.rt.pcm.usagemodel.util.UsageServiceUtil;
import dmodel.pipeline.shared.pcm.util.PCMUtils;
import lombok.Data;

@Data
public class UsageGroup implements IPCMAnalogue<UsageScenario> {
	private long interarrivalTime;
	private List<IAbstractUsageDescriptor> descriptors;

	public UsageGroup() {
		this.descriptors = Lists.newArrayList();
	}

	@Override
	public UsageScenario toPCM() {
		UsageScenario ret = UsagemodelFactory.eINSTANCE.createUsageScenario();
		ret.setScenarioBehaviour_UsageScenario(UsageServiceUtil.createBehaviour(descriptors));

		OpenWorkload workload = UsagemodelFactory.eINSTANCE.createOpenWorkload();
		workload.setInterArrivalTime_OpenWorkload(
				PCMUtils.createRandomVariableFromString(String.valueOf(interarrivalTime)));
		ret.setWorkload_UsageScenario(workload);

		return ret;
	}
}
