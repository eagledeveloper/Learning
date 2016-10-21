package ch.gmtech.learning.refactoring.introduceparameterobject;

import java.util.Date;

public class Entry {

	private Date _chargeDate;
	private double _value;

	public Entry(double value, Date chargeDate) {
		_value = value;
		_chargeDate = chargeDate;
	}

	public Date getDate() {
		return _chargeDate;
	}

	public double getValue() {
		return _value;
	}

}
