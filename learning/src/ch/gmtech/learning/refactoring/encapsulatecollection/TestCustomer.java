package ch.gmtech.learning.refactoring.encapsulatecollection;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestCustomer {

	@Test
	public void test() {

		Person kent = new Person();
		Set<Course> s = new HashSet<Course>();
		s.add(new Course("Smalltalk Programming", false));
		s.add(new Course("Appreciating Single Malts", true));
		kent.replaceCourses(s);
		assertEquals(2, kent.getCourses().size());
		Course refact = new Course("Refactoring", true);
//		kent.getCourses().add(refact);
		kent.addCourse(refact);
//		kent.getCourses().add(new Course("Brutal Sarcasm", false));
		kent.addCourse(new Course("Brutal Sarcasm", false));
		assertEquals(4, kent.getCourses().size());
//		kent.getCourses().remove(refact);
		kent.removeCourse(refact);
		assertEquals(3, kent.getCourses().size());

	}

}
