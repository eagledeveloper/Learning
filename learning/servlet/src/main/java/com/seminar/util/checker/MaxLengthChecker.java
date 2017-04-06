package com.seminar.util.checker;

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
	public String message() {
		return isOk() ? _name + " length is ok" : _name + " is to long";
	}

}
