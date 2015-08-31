package br.ufpe.eonsimulator.rsa;

import java.util.Comparator;
import java.util.Properties;

import br.ufpe.eonsimulator.modulation.ModulationFormatBitRateWrapper;
import br.ufpe.simulator.utils.ConvertUtils;

public class RSAAlgorithmFactory {

	private static final String RSA_ALGORITHM_KEY = "simulation.rsaAlgorithm";
	private static final String RSA_QOT_FILTER_KEY = "simulation.rsaAlgorithm.qotFilter";
	private static final String RSA_QOT_FILTER_K_KEY = "simulation.rsaAlgorithm.qotFilterK";

	public static IsRSAAlgorithm createRsaAlgorithm(
			Properties properties,
			Comparator<ModulationFormatBitRateWrapper> modulationFormatComparator) {
		IsRSAAlgorithm rsaAlgorithm = null;
		String key = properties.getProperty(RSA_ALGORITHM_KEY);
		boolean qotFilter = ConvertUtils.convertToBoolean(properties
				.getProperty(RSA_QOT_FILTER_KEY));
		int qotFilterK = ConvertUtils.convertToInteger(properties
				.getProperty(RSA_QOT_FILTER_K_KEY));
		switch (ConvertUtils.convertToInteger(key)) {
		case 0:
			rsaAlgorithm = new RSAMinHopMaxOSNRAlgorithm(
					modulationFormatComparator, qotFilter, qotFilterK);
			break;
		case 1:
			rsaAlgorithm = new RSAMinHopMinOSNRAlgorithm(
					modulationFormatComparator, qotFilter, qotFilterK);
			break;
		case 2:
			rsaAlgorithm = new RSAMinLengthAlgorithm(
					modulationFormatComparator, qotFilter, qotFilterK);
			break;
		case 3:
			rsaAlgorithm = new RSAMinCostAlgorithm(modulationFormatComparator,
					qotFilter, qotFilterK);
			break;
		default:
			break;
		}
		return rsaAlgorithm;
	}
}
