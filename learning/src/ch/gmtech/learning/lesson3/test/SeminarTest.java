package ch.gmtech.learning.lesson3.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ch.gmtech.learning.lesson3.Course;
import ch.gmtech.learning.lesson3.Seminar;
import ch.gmtech.learning.lesson3.Student;

public class SeminarTest {
	
	@Test
	public void testSeminar() {
		Course course = new Course("Course 1", 3, "Simple course 1");
		Seminar seminar = new Seminar(course, "Manno", 5, Arrays.asList(new Student("Ugo", "Campione"), new Student("Gianni", "Fondue")));
		
		assertEquals("Simple course 1", seminar.getDescription());
		assertEquals("Manno", seminar.getLocation());
		assertEquals(5, seminar.getSeatsLeft());
		assertEquals("Course 1:3", seminar.getNameNumber());
		assertEquals("Ugo Campione\nGianni Fondue\n", seminar.getStudentList());
		
		;
	}

}
