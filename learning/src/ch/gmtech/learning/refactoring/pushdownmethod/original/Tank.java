package ch.gmtech.learning.refactoring.pushdownmethod.original;

public class Tank extends Unit {

	public Tank(int healt) {
		super(healt);
	}
	
	public Tank(int healt, double fuel) {
		this(healt);
		_fuel = fuel;
	}

}
