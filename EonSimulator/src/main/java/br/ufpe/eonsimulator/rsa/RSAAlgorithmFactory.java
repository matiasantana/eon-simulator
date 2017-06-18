package br.ufpe.eonsimulator.rsa;

import java.util.Comparator;
import java.util.Properties;

import br.ufpe.eonsimulator.modulation.ModulationFormatBitRateWrapper;
import br.ufpe.simulator.utils.ConvertUtils;

public class RSAAlgorithmFactory {

	private static final String RSA_ALGORITHM_KEY = "simulation.rsaAlgorithm";
	private static final String RSA_K_FILTER_KEY = "simulation.rsaAlgorithm.kFilter";
	private static final String RSA_QOT_FILTER_KEY = "simulation.rsaAlgorithm.qotFilter";

	public static IsRSAAlgorithm createRsaAlgorithm(
			Properties properties,
			Comparator<ModulationFormatBitRateWrapper> modulationFormatComparator) {
		IsRSAAlgorithm rsaAlgorithm = null;
		String key = properties.getProperty(RSA_ALGORITHM_KEY);
		int kFilter = ConvertUtils.convertToInteger(properties
				.getProperty(RSA_K_FILTER_KEY));
		boolean qotFilter = ConvertUtils.convertToBoolean(properties
				.getProperty(RSA_QOT_FILTER_KEY));
		switch (ConvertUtils.convertToInteger(key)) {
		case 0:
			rsaAlgorithm = new RSAMinHopMaxOSNRAlgorithm(
					modulationFormatComparator, kFilter, qotFilter);
			break;
		case 1:
			rsaAlgorithm = new RSAMinHopMinOSNRAlgorithm(
					modulationFormatComparator, kFilter, qotFilter);
			break;
		case 2:
			rsaAlgorithm = new RSAMinLengthAlgorithm(
					modulationFormatComparator, kFilter, qotFilter);
			break;
		case 3:
			rsaAlgorithm = new RSAMinCostAlgorithm(modulationFormatComparator,
					kFilter, qotFilter);
			break;
		default:
			break;
		}
		return rsaAlgorithm;
	}
}
