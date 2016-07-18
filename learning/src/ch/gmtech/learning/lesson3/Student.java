package ch.gmtech.learning.lesson3;

public class Student {
	
	private final String firstName, lastName;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getInfo() {
		return firstName + " " + lastName;
	}
	
}
