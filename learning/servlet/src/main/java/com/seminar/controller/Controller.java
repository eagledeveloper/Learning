package com.seminar.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.model.Model;
import com.seminar.util.Course;
import com.seminar.util.EmptyCourse;
import com.seminar.view.View;

public class Controller {
	
	private Model _model;
	private View _view;
	
	public Controller(Model model, View view) {
		_model = model;
		_view = view;
	}

	public void handleGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO how to improve it?
		if(req.getRequestURI().equals("/course/") || req.getRequestURI().equals("/") || req.getRequestURI().equals("/course")) {
			resp.getWriter().write(_view.render(_model.courses()));
		} else if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")) {
			// TODO questa è veramente una brutta cosa !!!
			_model.resetId();
			resp.getWriter().write(_view.render(new EmptyCourse()));
		} else if(req.getRequestURI().contains("/course/delete/")) {
			// TODO right place? feedback
			_model.deleteCourse(extractId(req.getRequestURI()));
			resp.sendRedirect("/course/");
		} else if(req.getRequestURI().contains("/course/")) {
			
			if(extractId(req.getRequestURI()) > 0) {
				Course course = _model.course(extractId(req.getRequestURI()));
				resp.getWriter().write(_view.render(course));
			} else {
				resp.sendRedirect("/course/");
			}
			
		} else {
			resp.getWriter().write(_view.renderStatus404Page());
		}
	}

	private int extractId(String url) {
		
		if((url.lastIndexOf("/") + 1) == url.length()) return 0;
		
		return Integer.parseInt(url.substring(url.lastIndexOf("/") + 1));
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		_model.handleRequest(req);
		
		if(_model.handled()) {
			resp.sendRedirect("/course/");
		} else {
			resp.getWriter().write(_view.render(_model.errorCourse()));
		}
		
	}

}
