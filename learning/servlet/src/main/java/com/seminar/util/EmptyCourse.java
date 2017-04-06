package com.seminar.util;

import java.util.List;

import com.seminar.html.Label;

public class EmptyCourse extends Course {
	
	public EmptyCourse() {
		_labels.add(new Label("courseName", "Course Name"));
		_labels.add(new Label("courseId", "Course Id"));
		_labels.add(new Label("courseDescription", "Course Description"));
		_labels.add(new Label("courseStartDate", "Course StartDate"));
		_labels.add(new Label("courseLocation", "Course Location"));
		_labels.add(new Label("courseTotalSeats", "Course Seats"));
	}
	
	@Override
	public List<Label> labels() {
		return _labels;
	}

}
