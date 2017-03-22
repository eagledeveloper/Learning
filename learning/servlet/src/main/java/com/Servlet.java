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
	
	private static final long serialVersionUID = 1L;
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
	}

}
