package com.seminar.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.model.Model;
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
		if(req.getRequestURI().equals("/course/")) {
			resp.getWriter().write(_view.render(_model.courses()));
		} else if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")) {
			resp.getWriter().write(_view.render(new EmptyCourse()));
		} else {
			resp.getWriter().write(_view.renderStatus404Page());
		}
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		_model.handleRequest(req);
		
		// todo da sistemare
//		if(_model.handled()) {
//			resp.getWriter().write(_view.render(_model.courses()));
//		} else {
////		resp.getWriter().write(_view.renderNotEmptyForm(_model.checker()));
//			resp.getWriter().write(_view.render(_model.notValidCourse()));
//		}
		
		if(_model.handledCorrectly()) {
			resp.getWriter().write(_view.render(_model.courses()));
		} else {
			resp.getWriter().write(_view.renderNotEmptyForm(_model.checker()));
		}
	}

}
