package com.seminar.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.seminar.util.Course;
import com.seminar.util.CourseCreator;
import com.seminar.util.ValidCourse;
import com.seminar.util.checker.CourseChecker;

public class Model {
	
	private List<Course> _courses = new ArrayList<Course>();
	private CourseChecker _checker;
	private Course _notValidCourse;
	private CourseCreator _courseCreator;

	public void handleRequest(HttpServletRequest req) {
		
		String name = req.getParameter(Course.NAME);
		String startDate = req.getParameter(Course.START_DATE);
		String location = req.getParameter(Course.LOCATION);
		String totalSeats = req.getParameter(Course.TOTAL_SEATS);
		String id = req.getParameter(Course.ID);
		String description = req.getParameter(Course.DESCRIPTION);
		
		_courseCreator = new CourseCreator(name, startDate, location, totalSeats, id, description);
	}
	
	public List<Course> courses() {
		return _courses;
	}

	public CourseChecker checker() {
		return _checker;
	}

	public boolean handledCorrectly() {
		return _checker.check();
	}

	public Course errorCourse() {
		return _notValidCourse;
	}

	public boolean handled() {
		Course course = _courseCreator.create();
		if(course instanceof ValidCourse) {
			_courses.add(course);
			return true;
		}
		_notValidCourse = course;
		return false;
	}

}
