package br.ufpe.eonsimulator.modulation;

import java.util.Comparator;
import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;

public class ModulationFormatComparatorFactory {

	private static final String SIMULATION_MODULATION_FORMAT_COMPARATOR = "simulation.modulationFormat.comparator";

	public static Comparator<ModulationFormatBitRateWrapper> createModulationFormatComparator(
			Properties properties) {
		Comparator<ModulationFormatBitRateWrapper> comparator = null;
		int type = ConvertUtils.convertToInteger(properties
				.getProperty(SIMULATION_MODULATION_FORMAT_COMPARATOR));
		switch (type) {
		case 0:
			comparator = new DefaultModulationFormatComparator();
			break;
		case 1:
			comparator = new NumberOfSlotsModulationFormatComparator();
			break;
		default:
			break;
		}
		return comparator;
	}
}
