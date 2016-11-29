package ch.gmtech.learning.refactoring.encapsulatecollection.original;

import java.util.Set;

public class Person {

	private Set<Course> _courses;
	
	public Set<Course> getCourses() {
		return _courses;
	}

	public void setCourses(Set<Course> courses) {
		_courses = courses;
	}

}
