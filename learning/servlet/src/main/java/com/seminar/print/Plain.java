package com.seminar.print;

import com.seminar.util.Seminar;
import com.seminar.util.Student;

public class Plain extends SeminarPrinter {

	@Override
	public String header(Seminar seminar) {
		return  "***************************************************************************************************************\n" +
				"Seminario di " + seminar.course().name() + " (" + seminar.course().number() + ") su " + seminar.course().description() + "\n" +
				"Il seminario si terra' presso " + seminar.location() + " e al momento ci sono ancora " + seminar.seatsLeft() + " posti disponibili\n" +
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
