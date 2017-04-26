package com.seminar.util;

import java.util.List;

import com.seminar.html.Label;

public class EmptyCourse extends Course {
	
	public EmptyCourse() {
		_labels.add(new Label(Course.ID));
		_labels.add(new Label(Course.NAME));
		_labels.add(new Label(Course.DESCRIPTION));
		_labels.add(new Label(Course.START_DATE));
		_labels.add(new Label(Course.LOCATION));
		_labels.add(new Label(Course.TOTAL_SEATS));
	}
	
	@Override
	public List<Label> labels() {
		return _labels;
	}

}
