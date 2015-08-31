package br.ufpe.eonsimulator.trafficGenerators.nodePairGenerators;

import java.util.List;

import br.ufpe.eonsimulator.domain.Simulation;
import br.ufpe.simulator.utils.NumberGeneratorUtils;
import br.ufpe.simulatorkernel.domain.IsPhysicalElement;
import br.ufpe.simulatorkernel.domain.Link;
import br.ufpe.simulatorkernel.domain.PhysicalElementPair;

public class RandomNodePairGenerator implements IsNodePairGenerator {

	@Override
	public PhysicalElementPair createPhysicalPair(Simulation simulation) {
		PhysicalElementPair physicalElementPair = new PhysicalElementPair();
		List<Link> links = simulation.getTopology().getLinks();
		if (!links.isEmpty()) {
			Link temp = links.get(NumberGeneratorUtils.generateInteger(links
					.size()));
			IsPhysicalElement source = temp.getSourceNode();
			IsPhysicalElement target = null;
			do {
				temp = links.get(NumberGeneratorUtils.generateInteger(links
						.size()));
				target = temp.getTargetNode();
			} while (source.equals(target));

			physicalElementPair.setSource(source);
			physicalElementPair.setTarget(target);
		}
		return physicalElementPair;
	}
}
