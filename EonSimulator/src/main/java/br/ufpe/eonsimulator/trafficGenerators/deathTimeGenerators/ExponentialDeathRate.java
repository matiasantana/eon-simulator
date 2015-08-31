package br.ufpe.eonsimulator.trafficGenerators.deathTimeGenerators;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulator.math.IsRandomVariable;
import br.ufpe.simulator.math.IsRandomVariable.RandomVariableType;
import br.ufpe.simulator.math.RandomVariableFactory;

public class ExponentialDeathRate implements IsDeathRateGenerator {

	@Override
	public double createDeathRate(Simulation simulation) {
		IsRandomVariable randomVariable = RandomVariableFactory
				.createRandomVariable(
						RandomVariableType.EXPONENTIALDISTRIBUTION,
						1 / simulation.getSimulationParameters().getConnectionDeathRate());
		return simulation.getSimulationTime() + randomVariable.sample();
	}

}
