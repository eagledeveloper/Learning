package com.seminar.util.checker;

public class NotEmptyChecker extends Checker {
	
	public NotEmptyChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		return !_toCheck.isEmpty();
	}

	@Override
	public String message() {
		return isOk() ? _name + " is valid" :  _name + " cannot be empty";
	}

}
