package ch.gmtech.learning.refactoring.hidedelegate.original;

public class Person {

	private Department _department;

	public Department getDepartment() {
		return _department;
	}

	public void setDepartment(Department department) {
		_department = department;
	}

}
