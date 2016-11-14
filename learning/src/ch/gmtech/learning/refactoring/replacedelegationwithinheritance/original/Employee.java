package ch.gmtech.learning.refactoring.replacedelegationwithinheritance.original;

public class Employee {

	private Person _person = new Person();

	public String getName() {
		return _person.getName();
	}

	public void setName(String arg) {
		_person.setName(arg);
	}

	public String toString() {
		return "Emp: " + _person.getLastName();
	}

}
