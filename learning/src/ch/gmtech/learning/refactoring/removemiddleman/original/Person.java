package ch.gmtech.learning.refactoring.removemiddleman.original;

public class Person {

	private Department _department;

	public Department getDepartment() {
		return _department;
	}

	public void setDepartment(Department department) {
		_department = department;
	}
	
	public Person getManager() {
		return _department.getManager();
	}

}
