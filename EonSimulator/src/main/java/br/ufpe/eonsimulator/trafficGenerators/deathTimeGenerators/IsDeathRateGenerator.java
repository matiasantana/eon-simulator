package br.ufpe.eonsimulator.trafficGenerators.deathTimeGenerators;

import br.ufpe.eonsimulator.domain.Simulation;

public interface IsDeathRateGenerator {

	double createDeathRate(Simulation simulation);
}
