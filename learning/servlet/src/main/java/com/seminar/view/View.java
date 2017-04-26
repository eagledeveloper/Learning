package com.seminar.view;

import java.util.List;

import com.seminar.html.HtmlRender;
import com.seminar.html.Status404;
import com.seminar.util.Course;

public class View {

	public String renderStatus404Page() {
		return new Status404().render();
	}
	
	public String render(Course course) {
		return new HtmlRender().renderNew(course);
	}

	public String render(List<Course> courses) {
		return new HtmlRender().renderNew(courses);
	}

}
