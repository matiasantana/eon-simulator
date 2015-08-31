package br.ufpe.eonsimulator.business;

import org.junit.Test;

import br.ufpe.eonsimulator.costFunctions.HopCostFunction;
import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.eonsimulator.domain.SimulationParameters;
import br.ufpe.eonsimulator.domain.Topology;
import br.ufpe.eonsimulator.routing.Dijkstra;
import br.ufpe.eonsimulator.spectrumAssignment.FirstFit;
import br.ufpe.eonsimulator.trafficGenerators.TrafficGenerator;
import br.ufpe.eonsimulator.trafficGenerators.arrivalTimeGenerators.ExponentialArrivalTime;
import br.ufpe.eonsimulator.trafficGenerators.bitRateGenerators.RandomContinuosTrafficUniform;
import br.ufpe.eonsimulator.trafficGenerators.deathTimeGenerators.ExponentialDeathRate;
import br.ufpe.eonsimulator.trafficGenerators.nodePairGenerators.RandomNodePairGenerator;
import br.ufpe.simulatorkernel.domain.CompensatedNode;
import br.ufpe.simulatorkernel.domain.Fiber;
import br.ufpe.simulatorkernel.domain.Link;
import br.ufpe.simulatorkernel.domain.Span;

public class SimpleSimulationControllerTest {

	@Test
	public void testRun() {
		IsSimulationController controller = new SimpleSimulationController();
		Simulation simulation = new Simulation();
		simulation.setIsAssignmentAlgorithm(new FirstFit());
		simulation.setIsRoutingAlgorithm(new Dijkstra());
		simulation.setMaxNumberConnection(1);
		simulation.setMaxSimulationTime(Double.MAX_VALUE);
		simulation.setTopology(createTopology());
		simulation.setSimulationParams(createParameters());
		simulation.setCostFunction(new HopCostFunction());
		simulation.setTrafficGenerator(new TrafficGenerator(
				new RandomNodePairGenerator(), new RandomContinuosTrafficUniform(),
				new ExponentialArrivalTime(), new ExponentialDeathRate()));
		controller.run(simulation);
	}

	private SimulationParameters createParameters() {
		SimulationParameters parameters = new SimulationParameters();
		parameters.setConnectionDeathRate(1.0);
		parameters.setConnectionExpandible(false);
		parameters.setConnectionSlotWidth(12.5 * Math.pow(10, 12));
		parameters.setConnectionMinArrival(10);
		parameters.setConnectionMaxArrival(50);
		parameters.setNumberGraphPoints(5);
		return parameters;
	}

	private Topology createTopology() {

		Topology topology = new Topology();
		Link link12 = new Link(16);
		CompensatedNode node1 = new CompensatedNode();
		node1.setGdB(-4);
		link12.addPhysicalElement(node1);
		Span span12 = new Span(new Fiber(0.2, 100));
		link12.addPhysicalElement(span12);
		CompensatedNode node2 = new CompensatedNode();
		node2.setGdB(-4);
		link12.addPhysicalElement(node2);
		topology.add(link12);

		Link link13 = new Link(16);
		link13.addPhysicalElement(node1);
		Span span13 = new Span(new Fiber(0.2, 50));
		link13.addPhysicalElement(span13);
		CompensatedNode node3 = new CompensatedNode();
		node3.setGdB(-4);
		link13.addPhysicalElement(node3);
		topology.add(link13);

		Link link23 = new Link(16);
		link23.addPhysicalElement(node2);
		Span span23 = new Span(new Fiber(0.2, 100));
		link23.addPhysicalElement(span23);
		link23.addPhysicalElement(node3);
		topology.add(link23);

		Link link31 = new Link(16);
		link31.addPhysicalElement(node3);
		Span span31 = new Span(new Fiber(0.2, 50));
		link31.addPhysicalElement(span31);
		link31.addPhysicalElement(node1);
		topology.add(link31);

		Link link32 = new Link(16);
		link32.addPhysicalElement(node3);
		Span span32 = new Span(new Fiber(0.2, 100));
		link32.addPhysicalElement(span32);
		link32.addPhysicalElement(node2);
		topology.add(link32);

		Link link21 = new Link(16);
		link21.addPhysicalElement(node2);
		Span span21 = new Span(new Fiber(0.2, 100));
		link21.addPhysicalElement(span21);
		link21.addPhysicalElement(node1);
		topology.add(link21);

		return topology;

	}
}
