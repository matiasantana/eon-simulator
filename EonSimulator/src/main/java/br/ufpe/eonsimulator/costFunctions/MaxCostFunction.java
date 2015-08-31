package br.ufpe.eonsimulator.costFunctions;

import java.util.List;

import br.ufpe.simulatorkernel.domain.Link;

public class MaxCostFunction implements IsLinkCostFunction {

	private double getSum(List<Link> links) {
		double max = 0;
		for (Link link : links) {
			if (link.getnAllocatedSlots() > max) {
				max = link.getnAllocatedSlots();
			}
		}
		return max;
	}

	@Override
	public void updateLinkCost(double alfa, double occupationFactor,
			List<Link> links) {
		for (Link link : links) {
			link.setCost((double) (alfa * link.getCost() + (1 - alfa)
					* (link.getnAllocatedSlots() / occupationFactor)));
		}

	}

	@Override
	public double getOccupation(List<Link> links) {
		return getSum(links);
	}
}
