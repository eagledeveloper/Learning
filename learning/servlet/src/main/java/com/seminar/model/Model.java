package com.seminar.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.seminar.util.Course;
import com.seminar.util.CourseChecker;

public class Model {
	
	private List<Course> _courses = new ArrayList<Course>();
	private CourseChecker _checker;

	public void addCourse(Course course) {
		_courses.add(course);
	}

	public List<Course> courses() {
		return _courses;
	}

	public void handleRequest(HttpServletRequest req) {
		
		String courseName = req.getParameter("courseName");
		String courseStartDate = req.getParameter("courseStartDate");
		String courseLocation = req.getParameter("courseLocation");
		int courseTotalSeats = Integer.valueOf((req.getParameter("courseTotalSeats").isEmpty()? "0" : req.getParameter("courseTotalSeats")));
		int courseNumber = Integer.valueOf((req.getParameter("courseNumber").isEmpty()? "0" : req.getParameter("courseNumber")));
		String courseDescription = req.getParameter("courseDescription");
		
		_checker = new CourseChecker(courseName, courseStartDate, courseLocation, courseTotalSeats, courseNumber, courseDescription);
		
		if(_checker.check()) {
			addCourse(new Course(courseName, courseNumber, courseDescription, courseStartDate, courseLocation, courseTotalSeats));
		}
		
	}

	public CourseChecker checker() {
		return _checker;
	}

}
