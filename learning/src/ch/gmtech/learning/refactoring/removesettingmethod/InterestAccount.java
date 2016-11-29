package ch.gmtech.learning.refactoring.removesettingmethod;

public class InterestAccount extends Account {

	private double _interestRate;

	public InterestAccount(String id, double rate) {
		super(id);
		_interestRate = rate;
	}

}
