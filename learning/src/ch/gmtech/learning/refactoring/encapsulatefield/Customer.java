package ch.gmtech.learning.refactoring.encapsulatefield;

public class Customer {
	
	private String _name;
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

}
