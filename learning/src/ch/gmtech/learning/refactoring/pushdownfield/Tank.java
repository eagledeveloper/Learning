package ch.gmtech.learning.refactoring.pushdownfield;

public class Tank extends Unit {
	
	private double _fuel;

	public Tank(int healt, double fuel) {
		super(healt);
		_fuel = fuel;
	}
	
	public double getFuel() {
		return _fuel;
	}

}
