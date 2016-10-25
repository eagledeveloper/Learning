package ch.gmtech.learning.refactoring.extractmethod;

import java.util.Vector;

public class Printer {

	private Vector<Order> _orders = new Vector<Order>();
	private String _name = "Valentino";

	public void printOwing() {
		
		printHeader();
		
		printDetails(calculateOutstanding());
	}

	private double calculateOutstanding() {
		double outstanding = 0.0;
		for(Order order : _orders) {
			outstanding += order.getAmount();
		}
		return outstanding;
	}

	private void printDetails(double outstanding) {
		System.out.println("name: " + _name );
		System.out.println("amount: " + outstanding);
	}

	private void printHeader() {
		System.out.println("**************************");
		System.out.println("***** Customer Owes ******");
		System.out.println("**************************");
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
