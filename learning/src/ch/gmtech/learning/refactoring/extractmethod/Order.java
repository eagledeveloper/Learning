package ch.gmtech.learning.refactoring.extractmethod;

public class Order {

	private double _amount;
	
	public Order(double amount) {
		_amount = amount;
	}

	public double getAmount() {
		return _amount;
	}

}
