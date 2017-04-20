package com.seminar.util.checker;

import java.util.List;

public class AlwaysValidChecker extends Checker {

	public AlwaysValidChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		return true;
	}

	@Override
	public List<String> message() {
		addMessage(_name + " is valid!");
		return _messages;
	}

}
