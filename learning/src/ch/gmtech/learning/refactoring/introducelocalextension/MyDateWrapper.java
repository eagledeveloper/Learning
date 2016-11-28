package ch.gmtech.learning.refactoring.introducelocalextension;

import java.util.Date;

public class MyDateWrapper {
	
	private Date _date;
	
	public MyDateWrapper(Date date) {
		_date = date;
	}
	
	public boolean isSameYear(Date date) {
		return same(date.getYear(), _date.getYear());
	}

	private boolean same(int value1, int value2) {
		return value1 == value2;
	}

}
