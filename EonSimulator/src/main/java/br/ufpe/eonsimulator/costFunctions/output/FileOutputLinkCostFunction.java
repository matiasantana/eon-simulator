package br.ufpe.eonsimulator.costFunctions.output;

import java.io.PrintWriter;
import java.util.List;

import br.ufpe.eonsimulator.costFunctions.IsLinkCostFunction;
import br.ufpe.eonsimulator.domain.LinksCostWrapper;

public class FileOutputLinkCostFunction implements IsOutputLinkCostFunction {

	@Override
	public void write(List<LinksCostWrapper> linksCostWrappers) {

		PrintWriter writer;
		try {
			writer = new PrintWriter(IsLinkCostFunction.FILE_OUTPUT_NAME,
					"UTF-8");
			for (LinksCostWrapper linksCostWrapper : linksCostWrappers) {
				for (String cost : linksCostWrapper.getLinksCosts()) {
					writer.println(cost);
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
