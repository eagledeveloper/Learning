package ch.gmtech.learning.lesson3;

import java.util.List;

public class Seminar {
	
	private final Course course;
	private final String location;
	private final int seatsLeft;
	private final List<Student> studentList;
	
	public Seminar(Course course, String location, int seatsLeft, List<Student> studentList) {
		this.course = course;
		this.location = location;
		this.seatsLeft = seatsLeft;
		this.studentList = studentList;
	}
	
	public String getNameNumber() {
		return course.getName() + ":" + course.getNumber();
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
		String info = "";
		
		for(Student student: studentList) {
			info += student.getInfo() + "\n"; 
		}
		
		return info;
	}

	public String show() {
		return "Name: " + getNameNumber() + "\nDescription: " + getDescription()+ "\nLocation: " + getLocation() 
				+ "\nSeats left: " + getSeatsLeft() + "\nStudents: " + getStudentList();
	}

}
