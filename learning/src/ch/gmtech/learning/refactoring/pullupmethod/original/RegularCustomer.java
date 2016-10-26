package ch.gmtech.learning.refactoring.pullupmethod.original;

import java.util.Date;

public class RegularCustomer extends Customer {

	private double charge;

	private void createBill(Date date) {
		double chargeAmount = chargeFor(lastBillDate, date);
		addBill(date, charge);
	}

	private double chargeFor(Date startDate, Date endDate) {
		double result = 0.0;
		
		
		
		return result;
	}

}
