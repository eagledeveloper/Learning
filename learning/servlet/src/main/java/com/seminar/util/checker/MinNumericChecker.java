package com.seminar.util.checker;

import java.util.List;

public class MinNumericChecker extends Checker {

	private int _minNumber;
	private Checker _checker;

	public MinNumericChecker(String name, String toCheck, int minNumber) {
		super(name, toCheck);
		_minNumber = minNumber;
		_checker = new NumericChecker(name, toCheck);
	}
	
	@Override
	public boolean isOk() {
		return _checker.isOk() && Integer.valueOf(_toCheck) > _minNumber;
	}
	
	@Override
	public List<String> message() {
		if(!_checker.isOk()) return _checker.message();
		addMessage(isOk() ? _name + " is valid" : _name + " is too low, it should be greater than " + _minNumber);
		return _messages;
	}

}
