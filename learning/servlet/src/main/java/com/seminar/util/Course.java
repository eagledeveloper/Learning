package com.seminar.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seminar.html.Label;

public abstract class Course {
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String START_DATE = "startDate";
	public static final String LOCATION = "location";
	public static final String TOTAL_SEATS = "totalSeats";
	
	protected String _name,_description, _location;
	protected int _id, _totalSeats;
	protected Date _startDate;
	protected List<Student> _students = new ArrayList<Student>();
	protected List<Label> _labels = new ArrayList<>();
	
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

	public abstract List<Label> labels();
	
}