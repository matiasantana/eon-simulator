package br.ufpe.eonsimulator.trafficGenerators.arrivalTimeGenerators;

import br.ufpe.eonsimulator.domain.Simulation;

public class ConstantArrivalTime implements IsArrivalTimeGenerator {

	private double arrivalTime;

	public ConstantArrivalTime(double arrivalTime) {
		super();
		this.arrivalTime = arrivalTime;
	}

	@Override
	public double getArrivalTime(Simulation simulation) {
		return arrivalTime;
	}

}
