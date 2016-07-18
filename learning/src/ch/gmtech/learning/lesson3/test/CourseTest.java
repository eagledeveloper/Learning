package ch.gmtech.learning.lesson3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.gmtech.learning.lesson3.Course;

public class CourseTest {
	
	@Test
	public void testCourse() {
		Course course = new Course("Course 1", 3, "Simple course 1");
		
		assertEquals("Course 1", course.getName());
		assertEquals(3, course.getNumber());
		assertEquals("Simple course 1", course.getDescription());
	}

}
