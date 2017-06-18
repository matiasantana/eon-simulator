package br.ufpe.eonsimulator.modulation;

public class QAM32ModulationFormat extends QAMModulationFormat {

	@Override
	protected int getM() {
		return 32;
	}

	@Override
	public double getRequiredSNRdB() {
		return 12.57;
	}

}
