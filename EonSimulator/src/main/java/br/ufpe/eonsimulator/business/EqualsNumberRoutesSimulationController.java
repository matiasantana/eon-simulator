package br.ufpe.eonsimulator.business;

import java.util.List;

import org.apache.log4j.Logger;

import br.ufpe.eonsimulator.domain.Connection;
import br.ufpe.eonsimulator.domain.Route;
import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulator.utils.ConvertUtils;
import br.ufpe.simulatorkernel.domain.IsPhysicalElement;
import br.ufpe.simulatorkernel.domain.PhysicalElementPair;

public class EqualsNumberRoutesSimulationController extends
		AbstractSimulationController implements IsSimulationController {

	// Private class for Simulation Route information
	private static Logger logger = Logger
			.getLogger(EqualsNumberRoutesSimulationController.class);

	@Override
	public void run(Simulation simulation) {
		clearSimulation(simulation, logger);
		List<IsPhysicalElement> physicalElements = simulation.getTopology()
				.getPhysicalNodes();
		int totalCount = 0;
		int totalRoutes = 0;
		if (physicalElements != null) {
			for (IsPhysicalElement isPhysicalElement : physicalElements) {
				for (IsPhysicalElement isPhysicalElement2 : physicalElements) {
					if (isPhysicalElement.isTopologyNode()
							&& isPhysicalElement2.isTopologyNode()
							&& !isPhysicalElement.equals(isPhysicalElement2)) {
						PhysicalElementPair elementPair = new PhysicalElementPair();
						elementPair.setSource(isPhysicalElement);
						elementPair.setTarget(isPhysicalElement2);
						simulation.getSimulationResults()
								.incrementNumberOfRequests();
						// Defines the node pair, the bit rate and the death
						// time of the
						// connection
						Connection connection = simulation
								.getTrafficGenerator().createConnection(
										simulation, elementPair);
						// Calculate the routes using the routing algorithm
						List<Route> routes = simulation.getIsRoutingAlgorithm()
								.createRoutes(connection,
										simulation.getTopology(),
										simulation.getCostFunction());

						int minNHops = 0;
						int count = 0;
						for (Route route : routes) {
							totalRoutes++;
							if (minNHops == 0 || route.getNHops() < minNHops) {
								System.out.println("Analisando: "
										+ route.getSeparatedElementsIndex());
								minNHops = route.getNHops();
								count = 0;
							} else if (route.getNHops() == minNHops) {
								System.out.println("Rota Igual Encontrada: "
										+ route.getSeparatedElementsIndex());
								count++;
							}
						}

						totalCount += count;
					}
				}
			}

		}

		System.out
				.println("Equals Hops Routes: "
						+ ConvertUtils
								.convertToLocaleString(((double) totalCount / totalRoutes) * 100)
						+ "%");
		System.out.println("Number Equals Hops Routes: "
				+ ConvertUtils.convertToString(totalCount));
	}
}
