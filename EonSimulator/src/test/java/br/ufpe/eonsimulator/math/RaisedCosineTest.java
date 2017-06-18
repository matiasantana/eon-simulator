package br.ufpe.eonsimulator.math;

import org.junit.Test;

import br.ufpe.simulator.math.functions.RaisedCosine;

public class RaisedCosineTest {

	@Test
	public void test() {
		double ts = 1 / (128 * Math.pow(10, 9));
		double rollOff = 0.3;
		RaisedCosine raisedCosine = new RaisedCosine(ts, rollOff, 0);

		double pass = 1 * Math.pow(10, 9);
		for (double i = -0.3 * Math.pow(10, 12); i < 0.3 * Math.pow(10, 12); i = i
				+ pass) {
			System.out.println(raisedCosine.value(i));
		}
	}
}
