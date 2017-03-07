package com.seminar.print;

import com.seminar.util.Seminar;
import com.seminar.util.Student;

public class Html extends SeminarPrinter {

	@Override
	public String header(Seminar seminar) {
		return "<html>" + "<head><title>" + seminar.course().name()
						+ "</title></head><body><div>"
						+ seminar.course().name() + ":</div><ul><li>"
						+ seminar.course().description() + "</li><li>"
						+ seminar.location() + "</li><li>"
						+ seminar.course().startDate() + "</li><li>"
						+ seminar.seatsLeft()
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
