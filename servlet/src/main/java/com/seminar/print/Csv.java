package com.seminar.print;

import com.seminar.util.Seminar;
import com.seminar.util.Student;

public class Csv extends SeminarPrinter {

	@Override
	public String header(Seminar seminar) {
		return quote(seminar.course().number()) + ";" +
						quote(seminar.course().name()) + ";" +
						quote(seminar.course().description()) + ";" +
						quote(seminar.location()) + ";" +
						quote(seminar.seatsLeft()) + System.getProperty("line.separator");
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
