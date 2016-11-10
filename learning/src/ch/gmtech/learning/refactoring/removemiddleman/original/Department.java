package ch.gmtech.learning.refactoring.removemiddleman.original;

public class Department {

	private Person _manager;

	public Department(Person personManager) {
		_manager = personManager;
	}

	public Person getManager() {
		return _manager;
	}

}
