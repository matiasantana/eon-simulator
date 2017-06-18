package br.ufpe.eonsimulator.costFunctions;

import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;

public class LinkCostFunctionFactory {

	private static final String LINK_COST_FUNCTION_KEY = "simulation.linkCostFunction";

	public static IsLinkCostFunction createLinkCostFunction(
			Properties properties) {
		IsLinkCostFunction linkCostFunction = null;
		int key = ConvertUtils.convertToInteger(properties
				.getProperty(LINK_COST_FUNCTION_KEY));
		switch (key) {
		case 0:
			linkCostFunction = new SumLinkCostFunction();
			break;
		case 1:
			linkCostFunction = new StdDeviationLinkCostFunction();
			break;
		case 2:
			linkCostFunction = new MaxCostFunction();
			break;
		case 3:
			linkCostFunction = new FileLinkCostFunction();
			break;
		default:
			break;
		}
		return linkCostFunction;
	}
}
