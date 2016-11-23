package ch.gmtech.learning.refactoring.introduceforeignmethod;

import java.util.Date;

public class Client {

	public void recalculate() {
		
		Date previousEnd = new Date();
		Date newStart = newStart(previousEnd);
		
	}
	
	private Date newStart(Date date) {
		return new Date(date.getYear(), date.getMonth(), date.getDate() + 1);
	}

}
