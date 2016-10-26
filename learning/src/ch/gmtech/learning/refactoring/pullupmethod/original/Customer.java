package ch.gmtech.learning.refactoring.pullupmethod.original;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	
	protected Date lastBillDate;
	private List<Bill> billList = new ArrayList<Bill>();
	
	protected void addBill(Date date, double amount) {
		billList.add(new Bill(date, amount));
	}

}
