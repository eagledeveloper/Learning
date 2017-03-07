package com.seminar.util;

import java.util.Arrays;
import java.util.List;

public class SeminarDetails {

	public static void main(String[] args) {
		new SeminarDetails().start();
	}

	private void start() {
		Seminar matematica = new Seminar("Lugano", new Course("Fondamenti di matematica", 1, "Aritmetica di base", "01.01.2017"));
		Student stefano = new Student("Stefano", "Coluccia");
		matematica.enroll(stefano);
		matematica.enroll(new Student("ValentN-ANO", "Decarli"));
		matematica.enroll(new Student("Manlio", "VaccaLuzzo"));
		
		Seminar informatica = new Seminar("Manno", new Course("informatica", 2, "Sequence diagrams", "01.01.2017"));
		informatica.enroll(stefano);
		
		Seminar chimica = new Seminar("Bioggio", new Course("Chimica", 3, "Ossidoriduzioni", "01.01.2017"));
		
		List<Seminar> seminars = Arrays.asList(matematica, informatica, chimica);
		
		for (Seminar seminar : seminars) {
			
			System.out.println(new PrintFactory(seminar).printPlain());
			System.out.println(new PrintFactory(seminar).printHtml());
			System.out.println(new PrintFactory(seminar).printCsv());
		}
	}
}