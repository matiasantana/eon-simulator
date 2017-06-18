package br.ufpe.eonsimulator.costFunctions;

import java.util.List;

import br.ufpe.simulatorkernel.domain.Link;

public interface IsLinkCostFunction {

	public static final String FILE_OUTPUT_NAME = "src/main/resources/linksCosts.txt";
	
	double getOccupation(List<Link> links);

	void updateLinkCost(double alfa, double occupationFactor, List<Link> links);
}
