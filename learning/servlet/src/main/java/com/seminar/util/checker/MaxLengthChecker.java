package com.seminar.util.checker;

import java.util.List;

public class MaxLengthChecker extends Checker {
	
	private int _maxLength;

	public MaxLengthChecker(String name, String toCheck, int maxLength) {
		super(name, toCheck);
		_maxLength = maxLength;
	}

	@Override
	public boolean isOk() {
		return _toCheck.length() <= _maxLength;
	}

	@Override
	public List<String> message() {
		addMessage(isOk() ? _name + " length is ok" : _name + " is to long");
		return _messages;
	}

}
