package com.seminar.print;

import com.seminar.util.Course;
import com.seminar.util.Student;

public class Csv extends CoursePrinter {

	@Override
	public String header(Course course) {
		return quote(course.id()) + ";" +
						quote(course.name()) + ";" +
						quote(course.description()) + ";" +
						quote(course.location()) + ";" +
						quote(course.startDate()) + ";" +
						quote(course.totalSeats()) + System.getProperty("line.separator");
	}
	
	@Override
	public String render(Student student) {
		return quote(student.name()) + ";" + quote(student.lastname()) + System.getProperty("line.separator");
	}

	@Override
	public String footer() {
		return "";
	}

	private String quote(Object field) {
		return wrap("\"", field);
	}

	private String wrap(String wrapper, Object wrapped) {
		return wrapper + wrapped + wrapper;
	}
}
