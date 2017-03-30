package com.seminar.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PrintFactoryTest {

	private PrintFactory _printFactory;

	@Before
	public void setUp() throws ParseException {
		// TODO da mettere a posto
		Course course = new ValidCourse("Gm course", 1, "Course at gm", new Date(), "Mendrisio", 15);		
		course.enroll(new Student("Valentino", "Decarli"));
		course.enroll(new Student("Gino", "Pilotino"));
		_printFactory = new PrintFactory(course);
	}

	@Test
	public void plain() {
		String expected = "***************************************************************************************************************\n" +
				"Seminario di Gm course (1) su Course at gm\n" +
				"Il seminario si terra' presso Mendrisio e al momento ci sono ancora 13 posti disponibili\n" +
				"Data di inizio: 01.01.2017\n" +
				"***************************************************************************************************************\n\n" +
				"Gli studenti attualmente iscritti sono: \n" +
				"			** Valentino Decarli ** \n" +
				"			** Gino Pilotino ** \n";
		assertEquals(expected, _printFactory.printPlain());
	}

	@Test
	public void html() {
		String expected = "<html>"+
				"<head>"+
				"<title>Gm course</title>"+
				"</head>"+
				"<body>"+
				"<div>Gm course:</div>"+
				"<ul>"+
				"<li>Course at gm</li>"+
				"<li>Mendrisio</li>"+
				"<li>01.01.2017</li>"+
				"<li>13</li>"+
				"</ul>"+
				"<div>partecipanti:</div>"+
				"<ul>"+
				"<li>Valentino Decarli</li>"+
				"<li>Gino Pilotino</li>"+
				"</ul>"+
				"</body>"+
				"</html>";
		assertEquals(expected, _printFactory.printHtml());
	}

	@Test
	public void csv() {
		String expected = "\"1\";\"Gm course\";\"Course at gm\";\"Mendrisio\";\"01.01.2017\";\"13\"\n" +
				"\"Valentino\";\"Decarli\"\n" +
				"\"Gino\";\"Pilotino\"\n";
		assertEquals(expected, _printFactory.printCsv());
	}

}
