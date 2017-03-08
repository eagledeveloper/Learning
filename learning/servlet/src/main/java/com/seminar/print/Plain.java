package com.seminar.print;

import com.seminar.util.Course;
import com.seminar.util.Student;

public class Plain extends CoursePrinter {

	@Override
	public String header(Course course) {
		return  "***************************************************************************************************************\n" +
				"Seminario di " + course.name() + " (" + course.number() + ") su " + course.description() + "\n" +
				"Il seminario si terra' presso " + course.location() + " e al momento ci sono ancora " + course.seatsLeft() + " posti disponibili\n" +
				"Data di inizio: " + course.startDate() + "\n" +
				"***************************************************************************************************************\n\n" +
				"Gli studenti attualmente iscritti sono: \n";
	}

	@Override
	public String render(Student student) {
		return "			** " + student.name() + " " + student.lastname() + " ** \n";
	}

	@Override
	public String footer() {
		return "";
	}

}
