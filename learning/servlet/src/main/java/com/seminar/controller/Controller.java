package com.seminar.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.html.HtmlForm;
import com.seminar.model.Model;
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
			resp.getWriter().write(_view.renderCourses(_model.courses()));
		} else if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")) {
			resp.getWriter().write(_view.renderEmptyForm());
		} else {
			resp.getWriter().write(_view.renderStatus404Page());
		}
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		_model.handleRequest(req);
		
		if(_model.checker().check()) {
			resp.getWriter().write(_view.renderCourses(_model.courses()));
		} else {
			resp.getWriter().write(new HtmlForm().render(_model.checker()));
		}
		return;
	}

}
