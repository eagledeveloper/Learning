package com.seminar.util.checker;

import org.apache.commons.lang3.StringUtils;

public class NumericChecker extends Checker {

	public NumericChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		System.out.println("isOk di NumericChecker");
		return StringUtils.isNumeric(_toCheck);
	}

	@Override
	public String message() {
		System.out.println("message di NumericChecker");
		return isOk() ? _name + " is a valid number" : _name + " isn't a number";
	}

}
