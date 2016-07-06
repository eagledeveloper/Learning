package ch.gmtech.learning.lesson2;

public class Student {
	
	private final String firstName, lastName;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getInfo() {
		return getFullName();
	}
	
	private String getFullName() {
		return firstName + " " + lastName;
	}

}
