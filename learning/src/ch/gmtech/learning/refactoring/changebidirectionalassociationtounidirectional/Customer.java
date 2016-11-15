package ch.gmtech.learning.refactoring.changebidirectionalassociationtounidirectional;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Set<Order> _orders = new HashSet();
	
	public void addOrder(Order order) {
		order.setCustomer(this);
	}

	public Set<Order> friendOrders() {
		return _orders;
	}

}
