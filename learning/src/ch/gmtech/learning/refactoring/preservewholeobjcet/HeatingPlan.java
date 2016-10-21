package ch.gmtech.learning.refactoring.preservewholeobjcet;

public class HeatingPlan {

	private TempRange _range;
	
	boolean withinRange(int low, int high) {
		return (low >= _range.getLow() && high <= _range.getHigh());
	}


}
