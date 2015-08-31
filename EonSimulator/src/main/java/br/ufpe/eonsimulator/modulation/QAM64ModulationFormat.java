package br.ufpe.eonsimulator.modulation;

public class QAM64ModulationFormat extends QAMModulationFormat {

	@Override
	protected int getM() {
		return 64;
	}

	@Override
	public double getRequiredSNRdB() {
		return 14.77;
	}

}
