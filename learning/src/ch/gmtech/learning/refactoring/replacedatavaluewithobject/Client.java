package ch.gmtech.learning.refactoring.replacedatavaluewithobject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Client {

	protected static int numberOfOrdersFor(Collection orders, String customer) {
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
		
		orderList.add(new Order("Valentino"));
		orderList.add(new Order("Stefano"));
		orderList.add(new Order("Dario"));
		orderList.add(new Order("Valentino"));
		
		int valentinoOrder = numberOfOrdersFor(orderList, "Valentino");
		
		System.out.println("Result: " + valentinoOrder);
		
		
		
		
		
	}

}
