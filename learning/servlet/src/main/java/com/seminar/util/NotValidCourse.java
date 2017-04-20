package com.seminar.util;

import java.util.List;

import com.seminar.html.ErrorLabel;
import com.seminar.html.Label;
import com.seminar.html.SuccesLabel;
import com.seminar.util.checker.Checker;

public class NotValidCourse extends Course {
	
	public NotValidCourse(Checker idChecker, Checker nameChecker, Checker descriptionChecker, Checker startDateChecker, Checker locationChecker, Checker totalSeatsChecker) {
		_labels.add(createLabel(Course.ID, idChecker));
		_labels.add(createLabel(Course.NAME, nameChecker));
		_labels.add(createLabel(Course.DESCRIPTION, descriptionChecker));
		_labels.add(createLabel(Course.START_DATE, startDateChecker));
		_labels.add(createLabel(Course.LOCATION, locationChecker));
		_labels.add(createLabel(Course.TOTAL_SEATS, totalSeatsChecker));
	}
	
	private Label createLabel(String id, Checker checker) {
		if(!checker.isOk()) {
			return new ErrorLabel(id, checker.name(), checker.value(), checker.message());
		}
		return new SuccesLabel(id, checker.name(), checker.value(), checker.message());
	}
	
	@Override
	public List<Label> labels() {
		return _labels;
	}

}
