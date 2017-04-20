package com.seminar.util.checker;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class NumericChecker extends Checker {

	public NumericChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		return StringUtils.isNumeric(_toCheck);
	}

	@Override
	public List<String> message() {
		addMessage(isOk() ? _name + " is a valid number" : _name + " isn't a number");
		return _messages;
	}

}
