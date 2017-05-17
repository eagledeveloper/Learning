package com.seminar.print;

import com.seminar.util.Course;
import com.seminar.util.Student;

public class Html extends CoursePrinter {

	@Override
	public String header(Course course) {
		return "<html>" + "<head><title>" + course.name()
						+ "</title></head><body><div>"
						+ course.name() + ":</div><ul><li>"
						+ course.description() + "</li><li>"
						+ course.location() + "</li><li>"
						+ course.startDate() + "</li><li>"
						+ course.totalSeats()
						+ "</li></ul><div>partecipanti:</div><ul>";
	}
	
	@Override
	public String render(Student student) {
		return "<li>" + student.name() + " " + student.lastname() + "</li>";
	}

	@Override
	public String footer() {
		return "</ul>" + "</body>" + "</html>";
	}
}
