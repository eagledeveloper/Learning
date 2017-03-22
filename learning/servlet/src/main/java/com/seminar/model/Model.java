package com.seminar.model;

import java.util.List;

import com.seminar.util.Course;

public class Model {
	
	private List<Course> _courses;

	public void addCourse(Course course) {
		_courses.add(course);
	}

	public List<Course> getCourses() {
		return _courses;
	}

}
