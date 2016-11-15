package ch.gmtech.learning.refactoring.changebidirectionalassociationtounidirectional.original;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Set _orders = new HashSet();
	
	public void addOrder(Order order) {
		order.setCustomer(this);
	}

	public Set friendOrders() {
		/** should only be used by Order */
		return _orders;
	}

}
