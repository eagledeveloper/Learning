package com.seminar.util.checker;

import java.util.ArrayList;
import java.util.List;

public abstract class Checker {
	
	protected String _name;
	protected String _toCheck;
	protected List<String> _messages = new ArrayList<>();
	
	public Checker(String name, String toCheck) {
		_name = name;
		_toCheck = preventNullString(toCheck);
	}
	public abstract boolean isOk();
	public abstract List<String> message();
	
	private String preventNullString(String s) {
		return s == null ? "" : s;
	}
	
	protected void addMessage(String string) {
		_messages.add(string);
	}
	
	public String name() {
		return _name;
	}
	public String value() {
		return _toCheck;
	}

}
