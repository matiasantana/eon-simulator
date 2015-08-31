package br.ufpe.eonsimulator.costFunctions;

import br.ufpe.simulatorkernel.domain.Link;

public class LengthCostFunction implements IsCostFunction {

	@Override
	public double calculateCost(Link link) {
		if (link.isDisabled())
			return Double.MAX_VALUE;
		else
			return link.getDistance();
	}

}
