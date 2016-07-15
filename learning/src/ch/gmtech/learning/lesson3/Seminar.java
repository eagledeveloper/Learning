package ch.gmtech.learning.lesson3;

public class Seminar {
	
	private Course course;
	private Enrollment enrollment;
	private String location;
	private int seatsLeft;
	
	public Seminar(Course course, Enrollment enrollment, String location, int seatsLeft) {
		this.course = course;
		this.enrollment = enrollment;
		this.location = location;
		this.seatsLeft = seatsLeft;
	}
	
	public String getName() {
		return course.getName() + ", number: " + course.getNumber();
	}
	
	public String getDescription() {
		return course.getDescription();
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getSeatsLeft() {
		return seatsLeft;
	}
	
	public String getStudentList() {
		return enrollment.getInfo();
	}

	public String show() {
		return "Name: " + getName() + "\nDescription: " + getDescription()+ "\nLocation: " + getLocation() 
				+ "\nSeats left: " + getSeatsLeft() + "\nStudents: " + getStudentList();
	}

}
