package com.seminar.html;

import java.util.ArrayList;
import java.util.List;

import com.seminar.util.Course;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class HtmlRender {
	
	public String render(List<Course> courses) {
		ArrayList<DomContent> children = new ArrayList<DomContent>();
		
		for(Course course : courses) {
			children.add(TagCreator.li(course.name() + " - " + course.location() + " - " + course.id() + " - seats left: " + course.seatsLeft()));
		}
		
		return TagCreator.html().with(TagCreator.ul().with(children)).render();
	}
	
	public String render(Course course) {
		return createHtml(createInputList(course));
	}

	private String createHtml(List<DomContent> fields) {
		return TagCreator.html().with(createHead1(), TagCreator.body().with(
				TagCreator.div().withClass("container").with(
						TagCreator.div().withClass("row").with(
								TagCreator.div().withClass("col-md-6 col-md-offset-3").with(
										TagCreator.h1("Create Course").withClass("page-header text-center"), 
										TagCreator.form().withClass("form-horizontal").withRole("form").withMethod("post").with(
												fields
												)
										)
								)
						)
				)
				).render();
	}
	
	private List<DomContent> createInputList(Course course) {
		List<DomContent> inputList = new ArrayList<>();
		
		for(Label label : course.labels()) {
			inputList.add(createInput(label));
		}
		
		inputList.add(createSubmit());
		
		return inputList;
	}
	
	private DomContent createHead() {
		return TagCreator.head().with(
				TagCreator.title("Seminar"),
				TagCreator.link().withRel("stylesheet").withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),
				TagCreator.meta().withCharset("utf-8"),
				TagCreator.meta().withContent("width=device-width, initial-scale=1").withName("viewport"),
				TagCreator.script().withSrc("https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"),
				TagCreator.script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js")
				);
	}
	
	private DomContent createHead1() {
		return TagCreator.head().with(
				TagCreator.meta().withContent("text/html; charset=UTF-8").withData("http-equiv", "content-type"),
				TagCreator.meta().withCharset("utf-8"),
				TagCreator.title("courses"),
				TagCreator.meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
				TagCreator.meta().withContent("IE=edge").withData("http-equiv", "X-UA-Compatible"),
				TagCreator.link().withRel("stylesheet").withHref("/css/bootstrap.min.css?v=1.0.0").withData("media", "screen"),
				TagCreator.link().withRel("stylesheet").withHref("/css/custom.css?v=1.0.0"),
				TagCreator.link().withRel("stylesheet").withHref("/css/app.css?v=1.0.0")
				);
	}
	
	private DomContent createInput(Label label) {
		
		List<DomContent> domContentList = new ArrayList<>();
		
		domContentList.add(TagCreator.input().withType("text").withClass("form-control").withId(label.inputName())
				.withName(label.inputName()).withValue(label.inputValue()).withPlaceholder(label.inputPlaceholder()));
		
		domContentList.add(TagCreator.span().withClass(label.span1Class()));
		
		for(String string : label.span2Text()) {
			domContentList.add(TagCreator.span(string).withClass(label.span2Class()));
		}

		return TagCreator.div().withClass(label.divClass())
				.with(TagCreator.label(label.labelName()).withClass("col-sm-2 control-label")).with(
						TagCreator.div().withClass("col-sm-10").with(
								domContentList
								)
						);
	}

	private DomContent createSubmit() {
		return TagCreator.div().withClass("form-group").with(
				TagCreator.div().withClass("col-sm-10 col-sm-offset-2").with(
						TagCreator.input().withType("submit").withClass("btn btn-primary").withId("submit")
								.withName("submit").withValue("Send")
				)
		);
	}

}
