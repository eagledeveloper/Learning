package com.seminar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	
	private final String _name,_description, _location;
	private final Integer _id, _totalSeats;
	private Date _startDate;
	private final List<Student> _students = new ArrayList<Student>();

	public Course(String name, int id, String description, String startDate, String location, int totalSeats) {
		_name = name;
		_id = id;
		_description = description;
		try {
			_startDate = new SimpleDateFormat("dd.mm.yyyy").parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
			_startDate = new Date();
		}
		_location = location;
		_totalSeats = totalSeats;
	}
	
	public Course(String courseName, String startDate, String location, int totalSeats) {
		this(courseName, 0, "No description", startDate, location, totalSeats);
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

	public Integer id() {
		return _id;
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