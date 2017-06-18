package br.ufpe.eonsimulator.domain;

import java.util.List;
import java.util.Properties;

import br.ufpe.simulatorkernel.domain.Link;
import br.ufpe.simulatorkernel.domain.LinksFactory;

public class TopologyFactory {

	public static Topology createTopology(Properties properties) {
		Topology topology = new Topology();
		List<Link> links = LinksFactory.createLinks(properties);
		for (Link link : links) {
			topology.add(link);
		}
		return topology;
	}
}
