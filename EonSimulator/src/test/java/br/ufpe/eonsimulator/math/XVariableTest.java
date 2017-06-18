package br.ufpe.eonsimulator.math;

import org.junit.Test;

import br.ufpe.simulator.math.functions.XVariable;

public class XVariableTest {

	@Test
	public void test() {
		XVariable xVariable = new XVariable(20, 20.7, 0, 100);
		System.out.println(xVariable.value(3 * Math.pow(10, 11),
				3 * Math.pow(10, 11), 2.75 * Math.pow(10, 11)));
	}
}
