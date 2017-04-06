package com.seminar.util.checker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChecker extends Checker {

	public DateChecker(String name, String toCheck) {
		super(name, toCheck);
	}

	@Override
	public boolean isOk() {
		if(_toCheck.isEmpty()) return false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	    Date date = new Date();
		try {
			date = sdf.parse(_toCheck);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    if (!_toCheck.equals(sdf.format(date))) {
	        return false;
	    }
		
		return true;
	}

	@Override
	public String message() {
		return isOk() ? _name + " has a valid format" : _name + " hasn't a valid format, it should be dd.mm.yyyy";
	}

}
