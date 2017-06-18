package br.ufpe.eonsimulator.costFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import br.ufpe.simulator.utils.ConvertUtils;
import br.ufpe.simulatorkernel.domain.Link;

public class FileLinkCostFunction implements IsLinkCostFunction {

	private BufferedReader bufferedReader;

	public FileLinkCostFunction() {
		super();
		try {
			bufferedReader = new BufferedReader(new FileReader(
					IsLinkCostFunction.FILE_OUTPUT_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getOccupation(List<Link> links) {
		return 0;
	}

	@Override
	public void updateLinkCost(double alfa, double occupationFactor,
			List<Link> links) {
		for (Link link : links) {
			try {
				link.setCost(ConvertUtils.convertToDouble(bufferedReader
						.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
