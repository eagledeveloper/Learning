package com.seminar.util.checker;

import java.util.List;

public class NotEmptyChecker extends Checker {
	
	public NotEmptyChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		return !_toCheck.isEmpty();
	}

	@Override
	public List<String> message() {
		addMessage(isOk() ? _name + " is valid" :  _name + " cannot be empty");
		return _messages;
	}

}
