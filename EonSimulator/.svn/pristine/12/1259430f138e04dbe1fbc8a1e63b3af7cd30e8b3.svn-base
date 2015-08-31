package br.ufpe.eonsimulator.spectrumAssignment;

import org.junit.Assert;
import org.junit.Test;

import br.ufpe.simulatorkernel.domain.SlotOccupancyCollection;

public class CapacityLossAssignmentAlgorithmTest {

	@Test
	public void test() {
		CapacityLossAssignmentAlgorithm algorithm = new CapacityLossAssignmentAlgorithm();
		SlotOccupancyCollection collection = new SlotOccupancyCollection(16);
		collection.setSlotsAsOccupied(0, 1);
		collection.setSlotsAsOccupied(6, 7);
		collection.setSlotsAsOccupied(10, 10);
		collection.setSlotsAsOccupied(14, 15);
		Format format = algorithm.calculateBestFormat(collection, 2, 4);
		int sum = 0;
		for (Integer capacity : format.capacities) {
			sum += capacity;
		}
		Assert.assertEquals(16, sum);
	}
}
