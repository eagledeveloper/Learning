package ch.gmtech.learning.refactoring.replacedatavaluewithobject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testNumberOfOrdersFor() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("Valentino"));
		orders.add(new Order("Stefano"));
		orders.add(new Order("Valentino"));
		assertEquals(2, new Client().numberOfOrdersFor(orders, "Valentino"));
	}

}
