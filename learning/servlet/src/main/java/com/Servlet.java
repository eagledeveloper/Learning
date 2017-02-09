package com;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seminar.util.Course;
import com.seminar.util.PrintFactory;
import com.seminar.util.Seminar;
import com.seminar.util.Student;

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().equals("/try/me")){
			resp.getWriter().write("<h1>you did it!</h1>");
		} else if(req.getRequestURI().equals("/course/html")) {
			resp.getWriter().write(new PrintFactory(prepareSeminar()).printHtml());
		} else if(req.getRequestURI().equals("/course/csv")) {
			printAndDownloadCsv(resp);
		} else if(req.getRequestURI().equals("/course/raw")) {
			resp.getWriter().write(new PrintFactory(prepareSeminar()).printPlain());
		} else if(req.getRequestURI().equals("/try/bootstrap")) {
			resp.getWriter().write(PrintFactory.printForm());
		} else if(req.getRequestURI().equals("/course/create")) {
			resp.getWriter().write(PrintFactory.printForm());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	private void printAndDownloadCsv(HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/csv");
		resp.setHeader("Content-Disposition", "attachment; filename=\"seminar.csv\"");
	    try
	    {
	        OutputStream outputStream = resp.getOutputStream();
	        String outputResult = new PrintFactory(prepareSeminar()).printCsv();
	        outputStream.write(outputResult.getBytes());
	        outputStream.flush();
	        outputStream.close();
	    } catch(Exception e) {
	        System.out.println(e.toString());
	    }
		
	    resp.getWriter().write(new PrintFactory(prepareSeminar()).printCsv());
		
	}

	private Seminar prepareSeminar() {
		Seminar seminar = new Seminar("Mendrisio", new Course("GM Learning", 1, "Internal school at GM"));
		seminar.enroll(new Student("Valentino", "Decarli"));
		seminar.enroll(new Student("Ugo", "Campione"));
		return seminar;
	}
	
	
}
