package com.seminar.util;

import com.seminar.print.Csv;
import com.seminar.print.Html;
import com.seminar.print.Plain;

public class PrintFactory {

	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain() {

		return new Plain().print(_seminar);

	}

	public String printHtml() {

		return new Html().print(_seminar);

	}

	public String printCsv() {
		
		return new Csv().print(_seminar);
		
	}
}