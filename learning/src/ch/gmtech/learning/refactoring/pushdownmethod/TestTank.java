package ch.gmtech.learning.refactoring.pushdownmethod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTank {

	@Test
	public void testFuel() {
		
		Tank tank = new Tank(10, 5);
		assertEquals(5.0, tank.getFuel(), 0);
		
	}

}
