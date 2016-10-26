package ch.gmtech.learning.refactoring.replacedatavaluewithobject;

public class Order {

	private Customer _customer;
	
	public Order(String name) {
		_customer = new Customer(name);
	}

	public String getCustomerName() {
		return _customer.getName();
	}

	public void setCustomer(String name) {
		_customer = new Customer(name);
	}


}
