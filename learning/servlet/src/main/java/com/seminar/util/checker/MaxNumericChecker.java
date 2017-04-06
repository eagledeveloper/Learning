package com.seminar.util.checker;

public class MaxNumericChecker extends NumericChecker {
	
	private int _maxNumber;

	public MaxNumericChecker(String name, String toCheck, int maxNumber) {
		super(name, toCheck);
		_maxNumber = maxNumber;
	}
	
	@Override
	public boolean isOk() {
		System.out.println("isOk di MaxNumericChecker");
		return super.isOk() && Integer.valueOf(_toCheck) < _maxNumber;
	}
	
	@Override
	public String message() {
		System.out.println("message di MaxNumericChecker");
		return super.message() + (isOk() ? "" : "\n" + _name + " is to high, it should be less than " + _maxNumber);
	}

}
