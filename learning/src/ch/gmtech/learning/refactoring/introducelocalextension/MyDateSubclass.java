package ch.gmtech.learning.refactoring.introducelocalextension;

import java.util.Date;

public class MyDateSubclass extends Date {

	public MyDateSubclass(int year, int month, int day) {
		super(year, month, day);
	}
	
	public boolean isSameYear(Date date) {
		return same(date.getYear(), getYear());
	}

	private boolean same(int value1, int value2) {
		return value1 == value2;
	}
	
}
