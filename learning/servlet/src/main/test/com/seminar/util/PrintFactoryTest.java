package com.seminar.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PrintFactoryTest {

	private PrintFactory _printFactory;

	@Before
	public void setUp() {
		Seminar seminar = new Seminar("Zürich", new Course("Computer science", 1, "Lorem ipsum dolor sit amet", "01.01.2017"));
		seminar.enroll(new Student("Ugo", "Campione"));
		seminar.enroll(new Student("Sandra", "Bach"));
		_printFactory = new PrintFactory(seminar);
	}

	@Test
	public void plain() {
		String expected = "***************************************************************************************************************\n" +
				"Seminario di Computer science (1) su Lorem ipsum dolor sit amet\n" +
				"Il seminario si terra' presso Zürich e al momento ci sono ancora 18 posti disponibili\n" +
				"Data di inizio: 01.01.2017\n" +
				"***************************************************************************************************************\n\n" +
				"Gli studenti attualmente iscritti sono: \n" +
				"			** Ugo Campione ** \n" +
				"			** Sandra Bach ** \n";
		assertEquals(expected, _printFactory.printPlain());
	}

	@Test
	public void html() {
		String expected = "<html>"+
				"<head>"+
				"<title>Computer science</title>"+
				"</head>"+
				"<body>"+
				"<div>Computer science:</div>"+
				"<ul>"+
				"<li>Lorem ipsum dolor sit amet</li>"+
				"<li>Zürich</li>"+
				"<li>01.01.2017</li>"+
				"<li>18</li>"+
				"</ul>"+
				"<div>partecipanti:</div>"+
				"<ul>"+
				"<li>Ugo Campione</li>"+
				"<li>Sandra Bach</li>"+
				"</ul>"+
				"</body>"+
				"</html>";
		assertEquals(expected, _printFactory.printHtml());
	}

	@Test
	public void csv() {
		String expected = "\"1\";\"Computer science\";\"Lorem ipsum dolor sit amet\";\"Zürich\";\"01.01.2017\";\"18\"\n" +
				"\"Ugo\";\"Campione\"\n" +
				"\"Sandra\";\"Bach\"\n";
		assertEquals(expected, _printFactory.printCsv());
	}

}
