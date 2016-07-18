package ch.gmtech.learning.lesson3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.gmtech.learning.lesson3.Student;

public class StudentTest {
	
	@Test
	public void testStudent() {
		Student student = new Student("firstName", "lastName");
		assertEquals("firstName lastName", student.getInfo());
	}

}
