package br.ufpe.eonsimulator.trafficGenerators.bitRateGenerators;

import java.util.List;

import br.ufpe.eonsimulator.domain.Simulation;

public class ConstantTraffic implements IsBitRateGenerator {

	private List<Double> bitRates;
	private int count;

	public ConstantTraffic(List<Double> bitRates) {
		super();
		this.bitRates = bitRates;
	}

	@Override
	public double createBitRate(Simulation simulation) {
		double bitRate = bitRates.get(count % bitRates.size());
		count++;
		return bitRate;
	}

	@Override
	public List<Double> getBitRates() {
		return bitRates;
	}

}
