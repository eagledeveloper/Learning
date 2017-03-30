package com.seminar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.seminar.html.Label;

public class ValidCourse extends Course {
	
	public ValidCourse(String name, int id, String description, Date startDate, String location, int totalSeats) {
		_name = name;
		_id = id;
		_description = description;
		_startDate = startDate;
		_location = location;
		_totalSeats = totalSeats;
	}
	
	public ValidCourse(String name, String id, String description, String startDate, String location, String totalSeats) {
		_name = name;
		_id = Integer.valueOf(id);
		_description = description;
		try {
			_startDate = new SimpleDateFormat("dd.mm.yyyy").parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
			_startDate = new Date();
		}
		_location = location;
		_totalSeats = Integer.valueOf(totalSeats);
	}

	@Override
	public List<Label> labels() {
		// TODO Auto-generated method stub --> to implement?
		return null;
	}
	
}
