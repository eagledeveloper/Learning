package ch.gmtech.learning.refactoring.replacedatavaluewithobject.original;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Client {

	private static int numberOfOrdersFor(Collection orders, String customer) {
		int result = 0;
		Iterator iter = orders.iterator();
		while (iter.hasNext()) {
			Order each = (Order) iter.next();
			if (each.getCustomerName().equals(customer))
				result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		List<Order> orderList = new ArrayList<>();
		Order order1 = new Order("Valentino");
		Order order2 = new Order("Stefano");
		Order order3 = new Order("Dario");
		Order order4 = new Order("Valentino");
		
		int valentinoOrder = numberOfOrdersFor(orderList, "Valentino");
		
		System.out.println("Result: " + valentinoOrder);
		
		
		
		
		
	}

}
