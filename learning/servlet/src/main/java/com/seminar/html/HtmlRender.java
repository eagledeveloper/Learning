package com.seminar.html;

import java.util.ArrayList;
import java.util.List;

import com.seminar.util.Course;
import com.seminar.util.CourseChecker;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class HtmlRender {
	
	public String render(Course course) {
		return createHtml(createInputList(course));
	}

	public String render(CourseChecker checker) {
		return createHtml(createInputList(checker));
	}
	
	private String createHtml(List<DomContent> fields) {
		return TagCreator.html().with(createHead(), TagCreator.body().with(

				TagCreator.div().withClass("container").with(

						 TagCreator.div().withClass("row").with(

						 TagCreator.div().withClass("col-md-6 col-md-offset-3").with(
						
						TagCreator.h1("Create Course").withClass("page-header text-center"), 

						TagCreator.form().withClass("form-horizontal").withRole("form").withMethod("post").with(

								fields

						)
						
						)
						 
						 )
				))).render();
	}
	
	private List<DomContent> createInputList(Course course) {
		List<DomContent> inputList = new ArrayList<>();
		
		for(Label label : course.labels()) {
			inputList.add(createInput(label));
		}
		
		inputList.add(createSubmit());
		
		return inputList;
	}
	
	private List<DomContent> createInputList(CourseChecker checker) {
		List<DomContent> inputList = new ArrayList<>();
		
		inputList.add(createInput("Course Name", "courseName", checker.checkCourseName(), checker.getCourseName()));
		inputList.add(createInput("Course Id", "courseId", checker.checkId(), checker.getId()));
		inputList.add(createInput("Course Description", "courseDescription", checker.checkDescription(), checker.getDescritpion()));
		inputList.add(createInput("Course StartDate", "courseStartDate", checker.checkStartDate(), checker.getStartDate()));
		inputList.add(createInput("Course Location", "courseLocation", checker.checkLocation(), checker.getLocation()));
		inputList.add(createInput("Course Seats", "courseTotalSeats", checker.checkTotalSeats(), checker.getTotalSeats()));
		inputList.add(createSubmit());
		
		return inputList;
	}

	private DomContent createHead() {
		return TagCreator.head().with(TagCreator.title("Seminar"),
				TagCreator.link().withRel("stylesheet")
						.withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),
				TagCreator.meta().withCharset("utf-8"),
				TagCreator.meta().withContent("width=device-width, initial-scale=1").withName("viewport"),
				TagCreator.script().withSrc("https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"),
				TagCreator.script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js")
				);
	}
	
	private DomContent createInput(Label label) {
		
		// div --> class
				// input --> id
				// input + label --> name
				// input --> value
				// input --> placeholder? --> when empty == labelName
				// span1 --> class
				// span2 --> text, class

				return TagCreator.div().withClass(label.divClass())
						.with(TagCreator.label(label.labelName()).withClass("col-sm-2 control-label")).with(

								TagCreator.div().withClass("col-sm-10").with(

										TagCreator.input().withType("text").withClass("form-control").withId(label.inputName())
												.withName(label.inputName()).withValue(label.inputValue()).withPlaceholder(label.inputPlaceholder())
												, TagCreator.span().withClass(label.span1Class())
												, TagCreator.span(label.span2Text()).withClass(label.span2Class())
												
								)

				);
		
	}

	private DomContent createInput(String labelName, String idName, boolean isOk, String value) {
		
		// div --> class
		// input --> id
		// input + label --> name
		// input --> value
		// input --> placeholder? --> when empty == labelName
		// span1 --> class
		// span2 --> text, class

		return TagCreator.div().withClass(isOk? "form-group has-success has-feedback" : "form-group has-error has-feedback")
				.with(TagCreator.label(labelName).withClass("col-sm-2 control-label")).with(

						TagCreator.div().withClass("col-sm-10").with(

								TagCreator.input().withType("text").withClass("form-control").withId(idName)
										.withName(idName).withValue(value)
										, TagCreator.span().withClass(isOk? "glyphicon glyphicon-ok form-control-feedback" : "glyphicon glyphicon-remove form-control-feedback")
										, TagCreator.span(isOk? labelName + " is valid" : "Provide a valid " + labelName + "!").withClass("help-block")
										
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
