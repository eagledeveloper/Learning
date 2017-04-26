package com.seminar.html;

import java.util.ArrayList;
import java.util.List;

import com.seminar.util.Course;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class HtmlRender {
	
	public String renderNew(List<Course> courses) {
		List<DomContent> courseData = new ArrayList<DomContent>();

		for(Course course : courses) {
			courseData.add(
					TagCreator.tr().with(
							TagCreator.td(course.id().toString()),
							TagCreator.th(course.name()).attr("scope", "row"),
							TagCreator.td(course.location()),
							TagCreator.td("" + course.seatsLeft()),
							TagCreator.td(course.startDate())
				)
			);
		}
		
		DomContent courseElement = 
				TagCreator.div().withClass("col-lg-8 col-md-8 col-sm-9").with(
						TagCreator.table().withClass("table table-striped").with(
								TagCreator.thead().with(
										TagCreator.tr().with(
												TagCreator.th("id"),
												TagCreator.th("name"),
												TagCreator.th("location"),
												TagCreator.th("totalSeats"),
												TagCreator.th("start")
												)
										),
								TagCreator.tbody().with(courseData)
								)
						)
				;
		
		return showView(courseElement);
	}

	public String renderNew(Course course) {
		return showView(createHtml(createInputList(course)));
	}

	private DomContent createHtml(List<DomContent> fields) {
		
		return TagCreator.div().withClass("col-lg-8 col-md-8 col-sm-9").with(
				TagCreator.form().withClass("form-horizontal").withAction("/course/create").withMethod("post").with(
						fields
						)
				);
	}
	
	private List<DomContent> createInputList(Course course) {
		List<DomContent> inputList = new ArrayList<>();
		
		for(Label label : course.labels()) {
			inputList.add(createInput(label));
		}
		
		inputList.add(createSubmit());
		inputList.add(TagCreator.script().withSrc("/js/jquery.min.js"));
		inputList.add(TagCreator.script().withSrc("/js/bootstrap.min.js"));
		
		return inputList;
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
						TagCreator.input()
						.withType("submit")
						.withClass("btn btn-primary")
						.withId("submit")
						.withValue("Send")
						)
				);
	}
	
	public String showView(DomContent domContent) {
		return TagCreator.html().with(
				TagCreator.head().with(
						TagCreator.meta().withContent("text/html; charset=UTF-8").attr("http-equiv", "content-type"),
						TagCreator.meta().withCharset("UTF-8"),
						TagCreator.title("Create courses"),
						TagCreator.meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
						TagCreator.meta().withContent("IE=edge").attr("http-equiv", "X-UA-Compatible"),
						TagCreator.link().withRel("stylesheet").withHref("/css/bootstrap.min.css").attr("media", "screen"),
						TagCreator.link().withRel("stylesheet").withHref("/css/custom.css"),
						TagCreator.link().withRel("stylesheet").withHref("/css/app.css")
						),	
				TagCreator.body().with(
						TagCreator.div().withClass("navbar navbar-default navbar-fixed-top").with(
								TagCreator.div().withClass("container").with(
										TagCreator.div().withClass("navbar-header").with(
												TagCreator.a("Seminar").withHref("/").withClass("navbar-brand"),
												TagCreator.button().withClass("navbar-toggle").withType("button")
												.withData("data-toggle", "collapse").withData("data-target", "#navbar-main").with(
														TagCreator.span().withClass("icon-bar"),
														TagCreator.span().withClass("icon-bar"),
														TagCreator.span().withClass("icon-bar")
														)
												),
										TagCreator.div().withClass("navbar-collapse collapse").withId("navbar-main").with(
												TagCreator.ul().withClass("nav navbar-nav navbar-right").with(
														TagCreator.li().withClass("dropdown").with(
																TagCreator.a("Account").withClass("dropdown-toggle").attr("data-toggle", "dropdown")
																.withId("download").withHref("#").attr("aria-expanded", "false").with(TagCreator.span().withClass("caret")),
																TagCreator.ul().withClass("dropdown-menu").attr("aria-labelledby", "download").with(
																		TagCreator.li().with(TagCreator.a("settings").withHref("/")),
																		TagCreator.li().withClass("divider"),
																		TagCreator.li().with(TagCreator.a("logout").withHref("/"))
																		)
																)
														)
												)
										)
								),
						TagCreator.div().withClass("container").with(
								TagCreator.div().withClass("page-header").withId("banner").with(
										TagCreator.div().withClass("row").with(
												TagCreator.div().withClass("col-lg-8 col-md-7 col-sm-6").with(
														TagCreator.h1("Seminar"),
														TagCreator.p("Manage your courses!").withClass("lead")
														)
												),
										TagCreator.div().withClass("row").with(
												TagCreator.div().withClass("col-lg-2 col-md-2 col-sm-3").with(
														TagCreator.div().withClass("list-group table-of-contents").with(
																TagCreator.a("List").withClass("list-group-item").withHref("/course"),
																TagCreator.a("Create").withClass("list-group-item").withHref("/course/create")
																)
														),
												domContent
												)
										),
								TagCreator.footer().with(
										TagCreator.div().withClass("row").with(
												TagCreator.div().withClass("col-lg-12").with(
														TagCreator.p().with(TagCreator.a("Cerulean theme").withHref("http://bootswatch.com/cerulean").withRel("nofollow")),
														TagCreator.p("Code released under the ").with(TagCreator.a("MIT License").withHref("https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE")),
														TagCreator.p("GmTechnologies")
														)
												)
										)
								),
						TagCreator.script().withSrc("/js/jquery.min.js?v=1.0.0"),
						TagCreator.script().withSrc("/js/bootstrap.min.js?v=1.0.0"),
						TagCreator.script().withSrc("/js/custom.js?v=1.0.0")
						)
				)
				.render();
	}

}
