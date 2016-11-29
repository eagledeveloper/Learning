package ch.gmtech.learning.refactoring.removesettingmethod.original;

public class Account {

	private String _id;

	public Account(String id) {
		setId(id);
	}

	private void setId(String id) {
		_id = id;
	}

}
