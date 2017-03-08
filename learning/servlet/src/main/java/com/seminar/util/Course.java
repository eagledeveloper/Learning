package com.seminar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	
	private final String _name,_description, _location;
	private final Integer _number, _totalSeats;
	private final Date _startDate;
	private final List<Student> _students = new ArrayList<Student>();

	public Course(String courseName, int courseNumber, String description, String startDate, String location, int totalSeats) throws ParseException {
		_name = courseName;
		_number = courseNumber;
		_description = description;
		_startDate = new SimpleDateFormat("dd.mm.yyyy").parse(startDate);
		_location = location;
		_totalSeats = totalSeats;
	}
	
	public String location() {
		return _location;
	}

	public int seatsLeft() {
		return _totalSeats - _students.size();
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
		return new SimpleDateFormat("dd.MM.yyyy").format(_startDate);
	}
	
	public void enroll(Student student) {
		if(_students.size() < _totalSeats)
			_students.add(student);
	}

	public List<Student> students() {
		return _students;
	}
}