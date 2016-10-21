package ch.gmtech.learning.refactoring.decomposeconditional;

public class Season {
	
	public double calculateCharge() {
		
		double charge;
		
		if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
			charge = quantity * _winterRate + _winterServiceCharge;
		} else {
			charge = quantity * _summerRate;
		}
		
		return charge;
		
	}
	

}