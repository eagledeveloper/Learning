package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.html.HtmlForm;
import com.seminar.html.Status404;
import com.seminar.util.Course;
import com.seminar.util.CourseChecker;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		super.init();
		courses.add(new Course("Standard Name", 1, "Default description", "15.02.2017", "Lugano", 20));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().equals("/xxx") || req.getRequestURI().equals("/course/whatever")){
			resp.getWriter().write(new Status404().render());
		} else if(req.getRequestURI().equals("/course/")) {
			resp.getWriter().write(printCourses());
		} else if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")) {
			resp.getWriter().write(new HtmlForm().render());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		// aggiungere validazione qui?
		
		
		String courseName = req.getParameter("courseName");
		String courseStartDate = req.getParameter("courseStartDate");
		String courseLocation = req.getParameter("courseLocation");
		int courseTotalSeats = Integer.valueOf((req.getParameter("courseTotalSeats").isEmpty()? "0" : req.getParameter("courseTotalSeats")));
		int courseNumber = Integer.valueOf((req.getParameter("courseNumber").isEmpty()? "0" : req.getParameter("courseNumber")));
		String courseDescription = req.getParameter("courseDescription");
		
		CourseChecker checker = new CourseChecker(courseName, courseStartDate, courseLocation, courseTotalSeats, courseNumber, courseDescription);
		
		if(checker.check()) {
			courses.add(new Course(courseName, courseStartDate, courseLocation, courseTotalSeats));
			resp.sendRedirect("/course/");
		} else {
			resp.getWriter().write(new HtmlForm().render(checker));
		}
		
	}

	private String printCourses() {
		ArrayList<DomContent> children = new ArrayList<DomContent>();
		
		for(Course course : courses) {
			children.add(TagCreator.li(course.name()));
		}
		
		return TagCreator.html().with(TagCreator.ul().with(children)).render();
	}
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	
}
