package ch.gmtech.learning.lesson3;

import java.util.List;

public class Enrollment {
	
	private List<Student> studentList;
	
	public Enrollment(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public String getInfo() {
		
		String info = "";
		
		for(Student student: studentList) {
			info += student.getInfo() + ", "; 
		}
		
		return info.substring(0, info.length() - 2);
	}

}
