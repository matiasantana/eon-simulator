package br.ufpe.eonsimulator.application;

import br.ufpe.eonsimulator.service.DefaultSimulatorService;
import br.ufpe.eonsimulator.service.IsSimulatorService;

public class Main {

	public static void main(String[] args) {
		IsSimulatorService simulatorService = new DefaultSimulatorService();
		simulatorService.run();
	}
}
