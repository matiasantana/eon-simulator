package br.ufpe.eonsimulator.trafficGenerators.bitRateGenerators;

import java.util.List;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulator.utils.NumberGeneratorUtils;

public class RandomDiscreteTrafficUniform implements IsBitRateGenerator {

	private List<Double> bitRates;

	public RandomDiscreteTrafficUniform(List<Double> bitRates) {
		super();
		this.bitRates = bitRates;
	}

	@Override
	public double createBitRate(Simulation simulation) {
		return bitRates.get(NumberGeneratorUtils.generateInteger(bitRates
				.size()));
	}

	@Override
	public List<Double> getBitRates() {
		return bitRates;
	}

}
