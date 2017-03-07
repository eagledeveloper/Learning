package com.seminar.util;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
	
	private final Course _course;

	private final int _capacity;
	private final static int DEFAULT_CAPACITY = 20;
	private final String _location;
	private final List<Student> _students = new ArrayList<Student>();
	
	public Seminar(String location, Course course, int capacity) {
		_course = course;
		_location = location;
		_capacity = capacity;
	}
	
	public Seminar(String location, Course course) {
		this(location, course, DEFAULT_CAPACITY);
	}

	public Course course() {
		return _course;
	}
	
	public String location() {
		return _location;
	}

	public int seatsLeft() {
		return _capacity - _students.size();
	}

	public void enroll(Student student) {
		if(_students.size() < _capacity)
			_students.add(student);
	}

	public List<Student> students() {
		return _students;
	}
}