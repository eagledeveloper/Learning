package ch.gmtech.learning.refactoring.changebidirectionalassociationtounidirectional;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	
	@Before
	public void setup() {
		customer = new Customer();
	}

	@Test
	public void testFriendOrders() {
		assertEquals(0, customer.friendOrders().size());
		customer.addOrder(new Order());
		assertEquals(1, customer.friendOrders().size());
	}

}
