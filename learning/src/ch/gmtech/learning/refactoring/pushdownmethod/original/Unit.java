package ch.gmtech.learning.refactoring.pushdownmethod.original;

public class Unit {
	
	private int _healt;
	protected double _fuel;
	
	public Unit(int healt) {
		_healt = healt;
	}
	
	public int getHealt() {
		return _healt;
	}

	public double getFuel() {
		return _fuel;
	}
}
