package br.ufpe.eonsimulator.trafficGenerators.deathTimeGenerators;

import br.ufpe.eonsimulator.domain.Simulation;

public class ConstantDeathRate implements IsDeathRateGenerator {

	private double rate;

	public ConstantDeathRate(double rate) {
		super();
		this.rate = rate;
	}

	@Override
	public double createDeathRate(Simulation simulation) {
		return rate;
	}

}
