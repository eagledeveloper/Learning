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

	public void handleRequest(HttpServletRequest req) {
		
		String courseName = req.getParameter("courseName");
		String courseStartDate = req.getParameter("courseStartDate");
		String courseLocation = req.getParameter("courseLocation");
		String courseTotalSeats = req.getParameter("courseTotalSeats");
		String courseId = req.getParameter("courseId");
		String courseDescription = req.getParameter("courseDescription");
		
		// TODO to change
		_checker = new CourseChecker(courseName, courseStartDate, courseLocation, courseTotalSeats, courseId, courseDescription);
		CourseCreator courseCreator = new CourseCreator(courseName, courseStartDate, courseLocation, courseTotalSeats, courseId, courseDescription);
		
		if(_checker.check()) {
			_courses.add(new ValidCourse(courseName, courseId, courseDescription, courseStartDate, courseLocation, courseTotalSeats));
		}
		
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

}
