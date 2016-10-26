package ch.gmtech.learning.refactoring.replacedatavaluewithobject.original;

public class Order {

	private String _customer;
	
	public Order(String customer) {
		_customer = customer;
	}

	public String getCustomerName() {
		return _customer;
	}

	public void setCustomer(String customer) {
		_customer = customer;
	}


}
