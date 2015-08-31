package br.ufpe.eonsimulator.modulation;

public class QAM16ModulationFormat extends QAMModulationFormat {

	@Override
	protected int getM() {
		return 16;
	}

	@Override
	public double getRequiredSNRdB() {
		return 10.52;
	}

}
