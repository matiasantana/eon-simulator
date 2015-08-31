package br.ufpe.eonsimulator.costFunctions;

import java.util.List;

import br.ufpe.simulatorkernel.domain.Link;

public class StdDeviationLinkCostFunction implements IsLinkCostFunction {

	private double getMean(List<Link> links) {
		double mean = 0;
		for (Link link : links) {
			mean += (double) link.getnAllocatedSlots() / links.size();
		}
		return mean;
	}

	@Override
	public void updateLinkCost(double alfa, double occupationFactor,
			List<Link> links) {
		double mean = getMean(links);
		for (Link link : links) {
			double linkFactor = Math.pow(link.getnAllocatedSlots() - mean, 2)
					/ occupationFactor;
			double factor = Math.abs((1 - alfa) * linkFactor);
			if (link.getnAllocatedSlots() > mean) {
				link.setCost(alfa * link.getCost() + factor);
			} else {
				link.setCost(alfa * link.getCost() - factor);
			}
		}

	}

	@Override
	public double getOccupation(List<Link> links) {
		double stdDeviation = 0;
		double mean = getMean(links);
		for (Link link : links) {
			stdDeviation += Math.abs(Math.pow(link.getnAllocatedSlots() - mean,
					2));
		}

		return stdDeviation;
	}
}
