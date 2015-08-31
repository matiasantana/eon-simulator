package br.ufpe.eonsimulator.spectrumAssignment;

import java.util.Properties;

import br.ufpe.simulator.utils.ConvertUtils;

public class SpectrumAssignmentFactory {

	private static final String ASSIGNMENT_ALGORITHM_KEY = "simulation.assignmentAlgorithm";

	public static IsSpectrumAssignmentAlgorithm createSpectrumAssignmentAlgorithm(
			Properties properties) {
		IsSpectrumAssignmentAlgorithm assignmentAlgorithm = null;
		int key = ConvertUtils.convertToInteger(properties
				.getProperty(ASSIGNMENT_ALGORITHM_KEY));
		switch (key) {
		case 0:
			assignmentAlgorithm = new FirstFit();
			break;
		case 1:
			assignmentAlgorithm = new CapacityLossAssignmentAlgorithm();
			break;
		default:
			break;
		}
		return assignmentAlgorithm;
	}
}
