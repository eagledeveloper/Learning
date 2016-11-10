package ch.gmtech.learning.refactoring.removemiddleman;

public class Department {

	private Person _manager;

	public Department(Person personManager) {
		_manager = personManager;
	}

	public Person getManager() {
		return _manager;
	}

}
