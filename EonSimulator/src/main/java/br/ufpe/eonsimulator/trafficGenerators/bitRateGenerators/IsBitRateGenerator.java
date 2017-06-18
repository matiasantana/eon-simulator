package br.ufpe.eonsimulator.trafficGenerators.bitRateGenerators;

import java.util.List;

import br.ufpe.eonsimulator.domain.Simulation;

public interface IsBitRateGenerator {

	double createBitRate(Simulation simulation);

	List<Double> getBitRates();
}
