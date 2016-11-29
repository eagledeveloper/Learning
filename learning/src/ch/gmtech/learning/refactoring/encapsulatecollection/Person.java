package ch.gmtech.learning.refactoring.encapsulatecollection;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Set<Course> _courses = new HashSet<Course>();
	
	public Set<Course> getCourses() {
		return new HashSet<>(_courses);
//		return _courses;
	}

	public void replaceCourses(Set<Course> courses) {
		_courses = new HashSet<>();
		
		for(Course course : courses) {
			addCourse(course);
		}
	}
	
	public boolean addCourse(Course course) {
		return _courses.add(course);
	}
	
	public boolean removeCourse(Course course) {
		return _courses.remove(course);
	}

}
