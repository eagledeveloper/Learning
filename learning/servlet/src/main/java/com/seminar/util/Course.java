package com.seminar.util;

public class Course {
	
	private final String _name;
	private final Integer _number;
	private final String _description;
	private final String _startDate;

	public Course(String courseName, Integer courseNumber, String description, String startDate) {
		_name = courseName;
		_number = courseNumber;
		_description = description;
		_startDate = startDate;
	}

	public String description(){
		return _description;
	}

	public String name() {
		return _name;
	}

	public Integer number() {
		return _number;
	}
	
	public String startDate() {
		return _startDate;
	}
}