package com.seminar.view;

import java.util.ArrayList;
import java.util.List;

import com.seminar.html.HtmlRender;
import com.seminar.html.Status404;
import com.seminar.util.Course;
import com.seminar.util.checker.CourseChecker;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class View {

	public String renderStatus404Page() {
		return new Status404().render();
	}
	
	public String render(Course course) {
		return new HtmlRender().render(course);
	}

	public String renderNotEmptyForm(CourseChecker checker) {
		return new HtmlRender().render(checker);
	}

	public String render(List<Course> courses) {
		ArrayList<DomContent> children = new ArrayList<DomContent>();
		
		for(Course course : courses) {
			children.add(TagCreator.li(course.name() + " - " + course.location() + " - " + course.id() + " - seats left: " + course.seatsLeft()));
		}
		
		return TagCreator.html().with(TagCreator.ul().with(children)).render();
	}

}
