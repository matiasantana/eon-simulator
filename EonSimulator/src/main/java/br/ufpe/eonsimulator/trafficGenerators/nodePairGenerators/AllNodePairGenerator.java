package br.ufpe.eonsimulator.trafficGenerators.nodePairGenerators;

import java.util.List;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulatorkernel.domain.IsPhysicalElement;
import br.ufpe.simulatorkernel.domain.PhysicalElementPair;

public class AllNodePairGenerator implements IsNodePairGenerator {

	private int count;

	@Override
	public PhysicalElementPair createPhysicalPair(Simulation simulation) {
		List<IsPhysicalElement> physicalElements = simulation.getTopology()
				.getPhysicalNodes();
		int myCount = 0;
		PhysicalElementPair physicalElementPair = null;
		for (int i = 0; i < physicalElements.size(); i++) {
			for (int j = i + 1; j < physicalElements.size(); j++) {
				if (myCount == count) {
					physicalElementPair = new PhysicalElementPair();
					physicalElementPair.setSource(physicalElements.get(i));
					physicalElementPair.setTarget(physicalElements.get(j));
					if (i == physicalElements.size() - 2
							&& j == physicalElements.size() - 1) {
						count = 0;
					} else {
						count = myCount + 1;
					}
					return physicalElementPair;
				}
				myCount++;
			}
		}
		return physicalElementPair;
	}

}
