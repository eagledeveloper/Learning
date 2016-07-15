package ch.gmtech.learning.lesson3;

public class Course {
	
	private String name, description;
	private int number;
	
	public Course(String name, int number, String description) {
		this.name = name;
		this.number = number;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getDescription() {
		return description;
	}

}
