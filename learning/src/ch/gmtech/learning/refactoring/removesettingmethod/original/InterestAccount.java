package ch.gmtech.learning.refactoring.removesettingmethod.original;

public class InterestAccount extends Account {

	private double _interestRate;

	public InterestAccount(String id, double rate) {
		super(id);
//		setId(id);
		_interestRate = rate;
	}

}
