package com.seminar.util.checker;

public abstract class Checker {
	
	protected String _name;
	protected String _toCheck;
	
	public Checker(String name, String toCheck) {
		_name = name;
		_toCheck = preventNullString(toCheck);
	}
	public abstract boolean isOk();
	public abstract String message();
	
	private String preventNullString(String s) {
		return s == null ? "" : s;
	}

}
