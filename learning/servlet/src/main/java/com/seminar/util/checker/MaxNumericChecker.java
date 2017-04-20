package com.seminar.util.checker;

import java.util.List;

public class MaxNumericChecker extends Checker {
	
	private int _maxNumber;
	private Checker _checker;

	public MaxNumericChecker(String name, String toCheck, int maxNumber) {
		super(name, toCheck);
		_maxNumber = maxNumber;
		_checker = new NumericChecker(name, toCheck);
	}
	
	@Override
	public boolean isOk() {
		return _checker.isOk() && Integer.valueOf(_toCheck) < _maxNumber;
	}
	
	@Override
	public List<String> message() {
		if(!_checker.isOk()) return _checker.message();
		addMessage(isOk() ? _name + " is valid" : _name + " is too high, it should be less than " + _maxNumber);
		return _messages;
	}

}
