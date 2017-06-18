package br.ufpe.eonsimulator.modulation;

import java.util.Comparator;

public class NumberOfSlotsModulationFormatComparator implements
		Comparator<ModulationFormatBitRateWrapper> {

	@Override
	public int compare(ModulationFormatBitRateWrapper o1,
			ModulationFormatBitRateWrapper o2) {
		int nSlots1 = o1.getModulationFormat().createNumberOfRequiredSlots(
				o1.getSlotWidth(), o1.getBitRate());
		int nSlots2 = o2.getModulationFormat().createNumberOfRequiredSlots(
				o2.getSlotWidth(), o2.getBitRate());
		if (nSlots1 < nSlots2) {
			return -1;
		} else if (nSlots1 > nSlots2) {
			return 1;
		} else {
			if (o1.getModulationFormat().getNSymbol() < o2
					.getModulationFormat().getNSymbol()) {
				return -1;
			} else if (o1.getModulationFormat().getNSymbol() > o2
					.getModulationFormat().getNSymbol()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
