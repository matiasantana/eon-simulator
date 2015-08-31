package br.ufpe.eonsimulator.modulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;
import br.ufpe.simulator.utils.StringUtil;

public class ModulationFormatFactory {

	private static final String MODULATION_FORMAT_KEY = "simulation.modulationFormat";

	public static List<IsModulationFormat> createModulationFormats(
			Properties properties) {
		List<IsModulationFormat> modulationFormats = new ArrayList<IsModulationFormat>();
		String key = properties.getProperty(MODULATION_FORMAT_KEY);
		List<String> keys = StringUtil.split(key, ",");
		for (String keyString : keys) {
			IsModulationFormat modulationFormat = null;
			switch (ConvertUtils.convertToInteger(keyString)) {
			case 0:
				modulationFormat = new QAM4ModulationFormat();
				break;
			case 1:
				modulationFormat = new QAM8ModulationFormat();
				break;
			case 2:
				modulationFormat = new QAM16ModulationFormat();
				break;
			case 3:
				modulationFormat = new QAM32ModulationFormat();
				break;
			case 4:
				modulationFormat = new QAM64ModulationFormat();
				break;
			default:
				break;
			}
			modulationFormats.add(modulationFormat);
		}
		return modulationFormats;
	}
}
