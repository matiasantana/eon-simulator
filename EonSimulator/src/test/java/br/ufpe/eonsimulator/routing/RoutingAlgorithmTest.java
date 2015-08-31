package br.ufpe.eonsimulator.routing;

import org.junit.Test;

import br.ufpe.eonsimulator.costFunctions.LengthCostFunction;
import br.ufpe.eonsimulator.domain.Connection;
import br.ufpe.eonsimulator.domain.Topology;
import br.ufpe.simulatorkernel.domain.Fiber;
import br.ufpe.simulatorkernel.domain.IsPhysicalElement;
import br.ufpe.simulatorkernel.domain.Link;
import br.ufpe.simulatorkernel.domain.Node;
import br.ufpe.simulatorkernel.domain.PhysicalElementPair;

public class RoutingAlgorithmTest {

	@Test
	public void test() {

		Topology topology = new Topology();

		IsPhysicalElement physicalElement1 = new Node();
		Fiber physicalElement12 = new Fiber();
		physicalElement12.setLs(10);
		IsPhysicalElement physicalElement2 = new Node();

		Link link1 = new Link(16);
		link1.addPhysicalElement(physicalElement1);
		link1.addPhysicalElement(physicalElement12);
		link1.addPhysicalElement(physicalElement2);
		topology.add(link1);

		Fiber physicalElement13 = new Fiber();
		physicalElement13.setLs(3);
		IsPhysicalElement physicalElement3 = new Node();

		Link link2 = new Link(16);
		link2.addPhysicalElement(physicalElement1);
		link2.addPhysicalElement(physicalElement13);
		link2.addPhysicalElement(physicalElement3);
		topology.add(link2);

		Fiber physicalElement24 = new Fiber();
		physicalElement24.setLs(20);
		IsPhysicalElement physicalElement4 = new Node();
		Link link3 = new Link(16);
		link3.addPhysicalElement(physicalElement2);
		link3.addPhysicalElement(physicalElement24);
		link3.addPhysicalElement(physicalElement4);
		topology.add(link3);

		Fiber physicalElement35 = new Fiber();
		physicalElement35.setLs(5);
		IsPhysicalElement physicalElement5 = new Node();

		Link link4 = new Link(16);
		link4.addPhysicalElement(physicalElement3);
		link4.addPhysicalElement(physicalElement35);
		link4.addPhysicalElement(physicalElement5);
		topology.add(link4);

		Fiber physicalElement46 = new Fiber();
		physicalElement46.setLs(30);
		IsPhysicalElement physicalElement6 = new Node();

		Link link5 = new Link(16);
		link5.addPhysicalElement(physicalElement4);
		link5.addPhysicalElement(physicalElement46);
		link5.addPhysicalElement(physicalElement6);
		topology.add(link5);

		Fiber physicalElement56 = new Fiber();
		physicalElement56.setLs(56);

		Link link6 = new Link(16);
		link6.addPhysicalElement(physicalElement5);
		link6.addPhysicalElement(physicalElement56);
		link6.addPhysicalElement(physicalElement6);
		topology.add(link6);

		Connection connection = new Connection();
		PhysicalElementPair physicalElementPair = new PhysicalElementPair();
		physicalElementPair.setSource(physicalElement1);
		physicalElementPair.setTarget(physicalElement6);
		connection.setPhysicalElementPair(physicalElementPair);

		IsRoutingAlgorithm dijkstra = new YenAlgorithm(100);
		dijkstra.createRoutes(connection, topology, new LengthCostFunction());
	}
}
