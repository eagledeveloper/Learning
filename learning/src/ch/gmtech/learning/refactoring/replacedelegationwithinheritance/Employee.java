package ch.gmtech.learning.refactoring.replacedelegationwithinheritance;

public class Employee extends Person {

	public String getLetterHead() {
		return "Emp: " + getLastName();
	}

}
