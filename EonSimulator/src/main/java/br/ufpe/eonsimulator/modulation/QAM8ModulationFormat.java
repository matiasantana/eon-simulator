package br.ufpe.eonsimulator.modulation;

public class QAM8ModulationFormat extends QAMModulationFormat {

	@Override
	protected int getM() {
		return 8;
	}

	@Override
	public double getRequiredSNRdB() {
		return 9.03;
	}

}
