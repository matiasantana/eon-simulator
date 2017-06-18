package br.ufpe.eonsimulator.routing;

import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;

public class RoutingAlgorithmFactory {

	private static final String ROUTING_ALGORITHM_KEY = "simulation.routingAlgorithm";
	private static final String ROUTING_YENALGORITHM_TOPK_KEY = "simulation.yenAlgorithm.topK";

	public static IsRoutingAlgorithm createRoutingAlgorithm(
			Properties properties) {
		IsRoutingAlgorithm routingAlgorithm = null;
		int key = ConvertUtils.convertToInteger(properties
				.getProperty(ROUTING_ALGORITHM_KEY));
		switch (key) {
		case 0:
			routingAlgorithm = new Dijkstra();
			break;
		case 1:
			routingAlgorithm = new YenAlgorithm(
					ConvertUtils.convertToInteger(properties
							.getProperty(ROUTING_YENALGORITHM_TOPK_KEY)));
			break;
		default:
			break;
		}
		return routingAlgorithm;
	}
}
