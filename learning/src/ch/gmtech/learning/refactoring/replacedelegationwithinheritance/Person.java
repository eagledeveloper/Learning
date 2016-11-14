package ch.gmtech.learning.refactoring.replacedelegationwithinheritance;

public class Person {

	private String _name;

	public String getFullName() {
		return _name;
	}

	public void setFullName(String name) {
		_name = name;
	}

	public String getLastName() {
		return _name.substring(_name.lastIndexOf(' ') + 1);
	}

}
