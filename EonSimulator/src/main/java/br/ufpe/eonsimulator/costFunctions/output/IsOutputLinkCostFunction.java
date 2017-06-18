package br.ufpe.eonsimulator.costFunctions.output;

import java.util.List;

import br.ufpe.eonsimulator.domain.LinksCostWrapper;

public interface IsOutputLinkCostFunction {

	void write(List<LinksCostWrapper> linksCostWrappers);
}
