package ch.gmtech.learning.refactoring.introduceforeignmethod.original;

import java.util.Date;

public class Client {

	public void recalculate() {
		
		Date previousEnd = new Date();
		Date newStart = new Date(previousEnd .getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
		
	}

}
