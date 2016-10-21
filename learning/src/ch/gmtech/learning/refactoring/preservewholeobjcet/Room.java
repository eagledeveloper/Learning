package ch.gmtech.learning.refactoring.preservewholeobjcet;

public class Room {

	boolean withinPlan(HeatingPlan plan) {
		int low = daysTempRange().getLow();
		int high = daysTempRange().getHigh();
		return plan.withinRange(low, high);
	}

}
