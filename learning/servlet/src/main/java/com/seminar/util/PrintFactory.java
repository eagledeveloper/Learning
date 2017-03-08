package com.seminar.util;

import com.seminar.print.Csv;
import com.seminar.print.Html;
import com.seminar.print.Plain;

public class PrintFactory {

	private final Course _course;

	public PrintFactory(Course course) {
		_course = course;
	}

	public String printPlain() {
		return new Plain().print(_course);
	}

	public String printHtml() {
		return new Html().print(_course);
	}

	public String printCsv() {
		return new Csv().print(_course);
	}
	
}