package ch.gmtech.learning.refactoring.encapsulatefield;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCustomer {
	
	private Customer _customer;
	
	@Before
	public void setup() {
		_customer = new Customer();
//		_customer._name = "Valentino";
		_customer.setName("Valentino");
	}

	@Test
	public void test() {
//		assertEquals("Valentino", _customer._name);
		assertEquals("Valentino", _customer.getName());
	}

}
