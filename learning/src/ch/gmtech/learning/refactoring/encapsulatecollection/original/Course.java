package ch.gmtech.learning.refactoring.encapsulatecollection.original;

public class Course {
	
	private String _name;
	private boolean _isAdvanced;

	public Course (String name, boolean isAdvanced) {
		_name = name;
		_isAdvanced = isAdvanced;
	}

	public boolean isAdvanced() {
		return _isAdvanced;
	}

}
