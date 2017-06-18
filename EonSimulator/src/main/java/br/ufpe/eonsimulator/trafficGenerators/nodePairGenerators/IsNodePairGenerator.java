package br.ufpe.eonsimulator.trafficGenerators.nodePairGenerators;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulatorkernel.domain.PhysicalElementPair;

public interface IsNodePairGenerator {

	PhysicalElementPair createPhysicalPair(Simulation simulation);
}
