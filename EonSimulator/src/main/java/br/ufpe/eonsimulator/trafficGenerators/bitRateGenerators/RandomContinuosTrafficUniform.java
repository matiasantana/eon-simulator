package br.ufpe.eonsimulator.trafficGenerators.bitRateGenerators;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulator.utils.NumberGeneratorUtils;

public class RandomContinuosTrafficUniform implements IsBitRateGenerator {

	@Override
	public double createBitRate(Simulation simulation) {
		return NumberGeneratorUtils.generateDouble(simulation
				.getSimulationParameters().getConnectionMinBitRate(),
				simulation.getSimulationParameters().getConnectionMaxBitRate());
	}

}
