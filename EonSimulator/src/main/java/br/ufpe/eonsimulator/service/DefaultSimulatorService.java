package br.ufpe.eonsimulator.service;

import java.util.Properties;

import br.ufpe.eonsimulator.business.IsSimulationController;
import br.ufpe.eonsimulator.business.SimulationControllerFactory;
import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.eonsimulator.domain.SimulationFactory;
import br.ufpe.simulator.math.MathUtils;
import br.ufpe.simulator.math.functions.GNLIFactory;
import br.ufpe.simulator.messages.MessageUtils;
import br.ufpe.simulator.utils.PropertiesUtils;
import br.ufpe.simulatorkernel.domain.PhysicalLayerProperties;

public class DefaultSimulatorService implements IsSimulatorService {

	private static final String SIMULATION_PROPERTIES = "src/main/resources/simulation.properties";
	private static final String SIMULATION_FINISH_INFO = "simulation.finish.info";

	@Override
	public void run() {
		Long iniTime = System.nanoTime();
		Properties properties = PropertiesUtils
				.createPropertiesFromResource(SIMULATION_PROPERTIES);
		IsSimulationController controller = SimulationControllerFactory
				.createSimulationController(properties);
		GNLIFactory.setGnliProperties(properties);
		PhysicalLayerProperties.setProperties(properties);
		Simulation simulation = SimulationFactory.createSimulation(properties);
		controller.run(simulation);
		Long totalTime = System.nanoTime() - iniTime;
		System.out.println(MessageUtils.createMessage(SIMULATION_FINISH_INFO,
				MathUtils.convertNanoToSeconds(totalTime)));
		java.awt.Toolkit.getDefaultToolkit().beep();
	}

}
