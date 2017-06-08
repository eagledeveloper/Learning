package com.seminar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.seminar.html.Label;
import com.seminar.html.SuccesLabel;

public class ValidCourse extends Course {
	
	public ValidCourse(String name, int id, String description, Date startDate, String location, int totalSeats) {
		_name = name;
		_id = id;
		_description = description;
		_startDate = startDate;
		_location = location;
		_totalSeats = totalSeats;
		
		initLabels();
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
		
		initLabels();
	}

	private void initLabels() {
		_labels.add(new SuccesLabel(Course.NAME, Course.NAME, _name, Arrays.asList("")));
		_labels.add(new SuccesLabel(Course.DESCRIPTION, Course.DESCRIPTION, _description, Arrays.asList("")));
		_labels.add(new SuccesLabel(Course.START_DATE, Course.START_DATE, new SimpleDateFormat("dd.mm.yyyy").format(_startDate), Arrays.asList("")));
		_labels.add(new SuccesLabel(Course.LOCATION, Course.LOCATION, _location, Arrays.asList("")));
		_labels.add(new SuccesLabel(Course.TOTAL_SEATS, Course.TOTAL_SEATS, String.valueOf(_totalSeats), Arrays.asList("")));
	}

	@Override
	public List<Label> labels() {
		return _labels;
	}
	
}
