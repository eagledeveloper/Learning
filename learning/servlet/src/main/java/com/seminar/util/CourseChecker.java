package com.seminar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseChecker {
	
	private String _courseName, _startDate, _location, _description;
	private int _totalSeats, _number;

	public CourseChecker(String courseName, String startDate, String location, int totalSeats, int number, String description) {
		_courseName = courseName;
		_startDate = startDate;
		_location = location;
		_totalSeats = totalSeats;
		_number = number;
		_description = description;
	}
	
	public boolean check() {
		return checkCourseName() && checkStartDate() && checkLocation() && checkTotalSeats() && checkNumber() && checkDescription();
	}
	
	public String getCourseName() {
		return _courseName;
	}
	
	public boolean checkCourseName() {
		return !_courseName.isEmpty();
	}
	

	public String getStartDate() {
		return _startDate;
	}
	
	public boolean checkStartDate() {
		
		if(_startDate.isEmpty()) return false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	    Date date = new Date();
		try {
			date = sdf.parse(_startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    if (!_startDate.equals(sdf.format(date))) {
	        return false;
	    }
		
		return true;
	}
	
	public String getLocation() {
		return _location;
	}
	
	public boolean checkLocation() {
		return !_location.isEmpty();
	}

	public int getTotalSeats() {
		return _totalSeats;
	}
	
	public boolean checkTotalSeats() {
		return _totalSeats > 0;
	}

	public int getNumber() {
		return _number;
	}
	
	public boolean checkNumber() {
		return _number >= 0 && _number < _totalSeats;
	}

	public String getDescritpion() {
		return _description;
	}
	
	public boolean checkDescription() {
		return true;
	}

}
