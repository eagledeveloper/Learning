package ch.gmtech.learning.refactoring.pullupmethod.original;

import java.util.Date;

public class Bill {

	private Date _date;
	private double _amount;

	public Bill(Date date, double amount) {
		_date = date;
		_amount = amount;
	}

}
