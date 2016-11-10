package ch.gmtech.learning.refactoring.replacetypecodewithsubclass.original;

public class Employee {

	private int _type;
	
	private static final int ENGINEER = 0;
	private static final int SALESMAN = 1;
	private static final int MANAGER = 2;

	public Employee(int type) {
		_type = type;
	}

}
