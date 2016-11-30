package ch.gmtech.learning.refactoring.pushdownfield.original;

public class Tank extends Unit {

	public Tank(int healt) {
		super(healt);
	}
	
	public Tank(int healt, double fuel) {
		this(healt);
		_fuel = fuel;
	}

}
