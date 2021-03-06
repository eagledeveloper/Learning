package ch.gmtech.learning.refactoring.replacetypecodewithsubclass;

public abstract class Employee {

	public static final int ENGINEER = 0;
	public static final int SALESMAN = 1;
	public static final int MANAGER = 2;
	private int _type;
	
	private Employee(int type) {
		_type = type;
	}
	
//	public static Employee createEmployee(int type) {
//		return new Employee(type);
//	}

	abstract int getType();

	public Employee() {
		super();
	}

}