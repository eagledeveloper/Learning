package ch.gmtech.learning.refactoring.hidedelegate;

public class Person {

	private Department _department;

	public void setDepartment(Department department) {
		_department = department;
	}
	
	public Person getManager() {
		return _department.getManager();
	}

}
