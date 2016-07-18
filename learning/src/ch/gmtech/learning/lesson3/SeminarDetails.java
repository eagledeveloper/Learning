package ch.gmtech.learning.lesson3;

import java.util.Arrays;

public class SeminarDetails {
	
	public static void main(String[] args) {
		
		Course course = new Course("GM course", 1, "Learning by GM");
		Student student1 = new Student("Valentino", "Decarli");
		Student student2 = new Student("Stefano", "Coluccia");
		Seminar seminar = new Seminar(course, "Manno", 5, Arrays.asList(student1, student2));
		
		System.out.println(seminar.show());
		
		
	}

}
