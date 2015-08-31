package br.ufpe.plsimulator.business;

import java.util.List;
import java.util.Properties;

import br.ufpe.simulator.math.functions.GNLIFactory;
import br.ufpe.simulator.utils.PropertiesUtils;
import br.ufpe.simulatorkernel.domain.Link;
import br.ufpe.simulatorkernel.domain.LinksFactory;
import br.ufpe.simulatorkernel.domain.PhysicalLayerProperties;
import br.ufpe.simulatorkernel.domain.Power;

public class DefaultPLSimulator implements IsPLSimulator {

	private static final String TOPOLOGY_PROPERTIES = "src/main/resources/topology.properties";
	private static final String SIMULATION_PROPERTIES = "src/main/resources/simulation.properties";

	@Override
	public void run() {

		Properties simulationProperties = PropertiesUtils
				.createPropertiesFromResource(SIMULATION_PROPERTIES);
		PhysicalLayerProperties.setProperties(simulationProperties);
		GNLIFactory.setGnliProperties(simulationProperties);
		Properties topologyProperties = PropertiesUtils
				.createPropertiesFromResource(TOPOLOGY_PROPERTIES);
		List<Link> links = LinksFactory.createLinks(topologyProperties);
		Power power = null;
		for (Link link : links) {
			link.getPhysicalElementsPower(power);
		}

	}
}
