package com.seminar.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.html.HtmlForm;
import com.seminar.model.Model;
import com.seminar.util.Course;
import com.seminar.util.CourseChecker;
import com.seminar.view.View;

public class Controller {
	
	private Model _model;
	private View _view;
	
	public Controller(Model model, View view) {
		_model = model;
		_view = view;
	}

	public void handleGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(req.getRequestURI().equals("/course/")) {
			resp.getWriter().write(_view.renderCourses(_model.getCourses()));
		} else if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")) {
			resp.getWriter().write(_view.renderEmptyForm());
		} else {
			resp.getWriter().write(_view.renderStatus404Page());
		}
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// passare al model i parametri?
		
		String courseName = req.getParameter("courseName");
		String courseStartDate = req.getParameter("courseStartDate");
		String courseLocation = req.getParameter("courseLocation");
		int courseTotalSeats = Integer.valueOf((req.getParameter("courseTotalSeats").isEmpty()? "0" : req.getParameter("courseTotalSeats")));
		int courseNumber = Integer.valueOf((req.getParameter("courseNumber").isEmpty()? "0" : req.getParameter("courseNumber")));
		String courseDescription = req.getParameter("courseDescription");
		
		CourseChecker checker = new CourseChecker(courseName, courseStartDate, courseLocation, courseTotalSeats, courseNumber, courseDescription);
		
		if(checker.check()) {
			_model.addCourse(new Course(courseName, courseNumber, courseDescription, courseStartDate, courseLocation, courseTotalSeats));
			resp.getWriter().write(_view.renderCourses(_model.getCourses()));
		} else {
			resp.getWriter().write(new HtmlForm().render(checker));
		}
		return;
	}

}
