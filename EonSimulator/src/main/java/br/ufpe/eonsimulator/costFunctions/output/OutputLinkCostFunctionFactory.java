package br.ufpe.eonsimulator.costFunctions.output;

import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;

public class OutputLinkCostFunctionFactory {

	private static final String OUTPUT_LINK_COST_FUNCTION_INDEX = "simulation.outputLinkCostFunction";

	public static IsOutputLinkCostFunction createIsOutputLinkCostFunction(
			Properties properties) {
		IsOutputLinkCostFunction outputLinkCostFunction = null;
		int index = ConvertUtils.convertToInteger(properties
				.getProperty(OUTPUT_LINK_COST_FUNCTION_INDEX));
		switch (index) {
		case 0:
			outputLinkCostFunction = new ConsoleOutputLinkCostFunction();
			break;
		case 1:
			outputLinkCostFunction = new FileOutputLinkCostFunction();
			break;
		default:
			break;
		}
		return outputLinkCostFunction;
	}
}
