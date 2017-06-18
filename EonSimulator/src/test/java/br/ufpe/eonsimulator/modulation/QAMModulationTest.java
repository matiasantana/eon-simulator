package br.ufpe.eonsimulator.modulation;

import org.junit.Test;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.eonsimulator.domain.SimulationParameters;

public class QAMModulationTest {

	@Test
	public void test() {
		IsModulationFormat modulationFormat = new QAM16ModulationFormat();
		Simulation simulation = new Simulation();
		SimulationParameters parameters = new SimulationParameters();
		simulation.setSimulationParams(parameters);
		simulation.getSimulationParameters().setConnectionSlotWidth(
				12.5 * Math.pow(10, 9));
		System.out.println(modulationFormat.createRequiredOSNR(simulation,
				100 * Math.pow(10, 9)));
	}

	@Test
	public void testNSlots() {
		QAMModulationFormat qamModulationFormat = new QAM32ModulationFormat();
		System.out.println(qamModulationFormat.createNumberOfRequiredSlots(
				12.5e9, 295e9));
	}
}
