package br.ufpe.eonsimulator.modulation;

import br.ufpe.eonsimulator.domain.Simulation;

public interface IsModulationFormat {

	double createRequiredOSNR(Simulation simulation, double bitRate);

	double getNSymbol();
	
	double getRequiredSNRdB();

	int createNumberOfRequiredSlots(double slotWidth, double bitRate);

}
