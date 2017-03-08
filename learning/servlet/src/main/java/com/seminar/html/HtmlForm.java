package com.seminar.html;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class HtmlForm {

	public String render() {
		return createHtml();
	}

	private String createHtml() {
		return TagCreator.html().with(createHead(), TagCreator.body().with(

				TagCreator.div().withClass("container").with(

//						TagCreator.div().withClass("row").with(

//								TagCreator.div().withClass("col-md-6 col-md-offset-3").with(

										TagCreator.form().withClass("form-horizontal").withRole("form")
												.withMethod("post").with(

														createSubhead(), createInput("Course Name", "courseName"),
														createInput("Course Number", "courseNumber"),
														createInput("Course Description", "courseDescription"),
														createInput("Course StartDate", "courseStartDate"),
														createSubmit()

										)
//			, TagCreator.script().withSrc("/js/jquery.min.js"), TagCreator.script().withSrc("/js/bootstrap.min.js")
			))).render();
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

	private DomContent createSubhead() {

		return TagCreator.h1("Create Course");

	}

	private DomContent createInput(String labelName, String idName) {
		
		// form-group has-success has-feedback --> glyphicon glyphicon-ok form-control-feedback 
		// form-group has-warning has-feedback --> glyphicon glyphicon-warning-sign form-control-feedback
		// form-group has-error has-feedback --> glyphicon glyphicon-remove form-control-feedback

		return

		TagCreator.div().withClass("form-group has-warning has-feedback").with(TagCreator.label(labelName).withClass("col-sm-2 control-label"))
				.with(

						TagCreator.div().withClass("col-sm-10").with(

								TagCreator.input().withType("text").withClass("form-control").withId(idName)
										.withName(idName).withPlaceholder(labelName).withCondRequired(true)
								, TagCreator.span().withClass("glyphicon glyphicon-remove form-control-feedback")

						)

		);

	}

	private DomContent createSubmit() {

		return TagCreator.div().withClass("form-group").with(

				TagCreator.div().withClass("col-sm-10").with(

						TagCreator.input().withType("submit").withClass("btn btn-primary").withId("submit")
								.withName("submit").withValue("Send")

				)

		);

	}

}
