package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.controller.Controller;
import com.seminar.model.Model;
import com.seminar.view.View;

public class Servlet extends HttpServlet {
	
	private Controller controller;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		Model model = new Model();
		View view = new View();
		controller = new Controller(model, view);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		controller.handleGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		controller.handlePost(req, resp);
		
		// renderlo OCP 100%
		
//		Map<String, String[]> parameterMap = req.getParameterMap();
//		
//		String courseName = req.getParameter("courseName");
//		String courseStartDate = req.getParameter("courseStartDate");
//		String courseLocation = req.getParameter("courseLocation");
//		int courseTotalSeats = Integer.valueOf((req.getParameter("courseTotalSeats").isEmpty()? "0" : req.getParameter("courseTotalSeats")));
//		int courseNumber = Integer.valueOf((req.getParameter("courseNumber").isEmpty()? "0" : req.getParameter("courseNumber")));
//		String courseDescription = req.getParameter("courseDescription");
//		
//		CourseChecker checker = new CourseChecker(courseName, courseStartDate, courseLocation, courseTotalSeats, courseNumber, courseDescription);
//		
//		if(checker.check()) {
//			courses.add(new Course(courseName, courseStartDate, courseLocation, courseTotalSeats));
//			resp.sendRedirect("/course/");
//		} else {
//			resp.getWriter().write(new HtmlForm().render(checker));
//		}
		
	}

}
