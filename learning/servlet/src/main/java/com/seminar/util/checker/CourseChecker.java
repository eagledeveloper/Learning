package com.seminar.util.checker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class CourseChecker {
	
	private String _courseName, _startDate, _location, _description, _totalSeats, _id;

	public CourseChecker(String courseName, String startDate, String location, String totalSeats, String id, String description) {
		_courseName = courseName;
		_startDate = startDate;
		_location = location;
		_totalSeats = totalSeats;
		_id = id;
		_description = description;
	}
	
	public boolean check() {
		return checkCourseName() && checkStartDate() && checkLocation() && checkTotalSeats() && checkId() && checkDescription();
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

	public String getTotalSeats() {
		return _totalSeats;
	}
	
	public boolean checkTotalSeats() {
		return !_totalSeats.isEmpty() && StringUtils.isNumeric(_totalSeats) && Integer.valueOf(_totalSeats) > 0;
	}

	public String getId() {
		return _id;
	}
	
	public boolean checkId() {
		return !_id.isEmpty() && StringUtils.isNumeric(_id) && Integer.valueOf(_id) > 0;
	}

	public String getDescritpion() {
		return _description;
	}
	
	public boolean checkDescription() {
		return true;
	}

}
