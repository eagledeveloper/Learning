package ch.gmtech.learning.lesson3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.learning.lesson3.Student;

public class StudentTest {
	
	@Test
	public void testStudent() {
		Student student = new Student("firstName", "lastName");
		assertEquals("firstName lastName", student.getInfo());
	}
	

}
