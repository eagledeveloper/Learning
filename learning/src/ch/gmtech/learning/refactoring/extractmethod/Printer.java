package ch.gmtech.learning.refactoring.extractmethod;

import java.util.Enumeration;
import java.util.Vector;

public class Printer {

	private Vector<Order> _orders = new Vector<Order>();
	private String _name = "Valentino";

	public void printOwing() {
		Enumeration e = _orders.elements();
		double outstanding = 0.0;
		// print banner
		System.out.println("**************************");
		System.out.println("***** Customer Owes ******");
		System.out.println("**************************");
		// calculate outstanding
		while (e.hasMoreElements()) {
			Order each = (Order) e.nextElement();
			outstanding += each.getAmount();
		}
		// print details
		System.out.println("name:" + _name );
		System.out.println("amount: " + outstanding);
	}
	
	public void addOrder(Order order) {
		_orders.add(order);
	}
	
	public static void main(String[] args) {
		Order order1 = new Order(10);
		Order order2 = new Order(20);
		
		Printer printer = new Printer();
		printer.addOrder(order1);
		printer.addOrder(order2);
		
		printer.printOwing();
	}

}
