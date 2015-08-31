package br.ufpe.eonsimulator.modulation;

import java.util.Comparator;

public class DefaultModulationFormatComparator implements
		Comparator<ModulationFormatBitRateWrapper> {

	@Override
	public int compare(ModulationFormatBitRateWrapper o1,
			ModulationFormatBitRateWrapper o2) {
		if (o1.getModulationFormat().getNSymbol() > o2.getModulationFormat()
				.getNSymbol()) {
			return -1;
		} else if (o1.getModulationFormat().getNSymbol() < o2
				.getModulationFormat().getNSymbol()) {
			return 1;
		} else {
			return 0;
		}
	}

}
