package ch.gmtech.learning.refactoring.changebidirectionalassociationtounidirectional;

public class Order {

	private Customer _customer;

	public Customer getCustomer() {
		return _customer;
	}

	public void setCustomer(Customer customer) {
		if (_customer != null)
			_customer.friendOrders().remove(this);
		_customer = customer;
		if (_customer != null)
			_customer.friendOrders().add(this);
	}

}
