package br.ufpe.eonsimulator.costFunctions.output;

import java.util.List;

import br.ufpe.eonsimulator.domain.LinksCostWrapper;
import br.ufpe.simulator.messages.MessageUtils;
import br.ufpe.simulator.utils.ConvertUtils;

public class ConsoleOutputLinkCostFunction implements IsOutputLinkCostFunction {

	private static final String SIMULATION_LINKSCOST_INFO = "simulation.linksCost.info";

	@Override
	public void write(List<LinksCostWrapper> linksCostWrappers) {
		for (LinksCostWrapper linksCostWrapper : linksCostWrappers) {
			System.out.println(MessageUtils.createMessage(
					SIMULATION_LINKSCOST_INFO, ConvertUtils
							.convertToLocaleString(linksCostWrapper
									.getMaxCost())));
			for (String cost : linksCostWrapper.getLinksCosts()) {
				System.out.println(cost);
			}
		}
	}

}
