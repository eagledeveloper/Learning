package com.seminar.view;

import java.util.ArrayList;
import java.util.List;

import com.seminar.html.HtmlForm;
import com.seminar.html.Status404;
import com.seminar.util.Course;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class View {

	private List<Course> _courses;

	public View(List<Course> courses) {
		_courses = courses;
	}

	public String renderStatus404Page() {
		return new Status404().render();
	}

	public String renderEmptyForm() {
		return new HtmlForm().render();
	}

	public String renderCourses() {
		ArrayList<DomContent> children = new ArrayList<DomContent>();
		
		for(Course course : _courses) {
			children.add(TagCreator.li(course.name() + " - " + course.location() + " - seats left: " + course.seatsLeft()));
		}
		
		return TagCreator.html().with(TagCreator.ul().with(children)).render();
	}
	
}
