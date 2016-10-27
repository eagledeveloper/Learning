package ch.gmtech.learning.refactoring.replacetypecodewithclass;

public class BloodGroup {
	
	private int _bloodGroup;
	
	public static final BloodGroup O = new BloodGroup(0);
	public static final BloodGroup A = new BloodGroup(1);
	public static final BloodGroup B = new BloodGroup(2);
	public static final BloodGroup AB = new BloodGroup(3);
	
	public BloodGroup(int bloodGroup) {
		_bloodGroup = bloodGroup;
	}
	
	public int getBloodGroupCode() {
		return _bloodGroup;
	}
	
	public static BloodGroup createBloodGroup(int bloodGroup) {
		return new BloodGroup(bloodGroup);
	}

}
