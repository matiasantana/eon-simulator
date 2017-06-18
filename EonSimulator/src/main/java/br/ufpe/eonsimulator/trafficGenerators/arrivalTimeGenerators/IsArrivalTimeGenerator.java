package br.ufpe.eonsimulator.trafficGenerators.arrivalTimeGenerators;

import br.ufpe.eonsimulator.domain.Simulation;

public interface IsArrivalTimeGenerator {

	double getArrivalTime(Simulation simulation);

}
