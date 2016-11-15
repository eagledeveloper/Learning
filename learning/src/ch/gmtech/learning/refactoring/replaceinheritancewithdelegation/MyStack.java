package ch.gmtech.learning.refactoring.replaceinheritancewithdelegation;

import java.util.Vector;

public class MyStack {
	
	private Vector<Object> vector = new Vector<>();

	public void push(Object element) {
		vector.insertElementAt(element, 0);
	}

	public Object pop() {
		Object result = vector.firstElement();
		vector.removeElementAt(0);
		return result;
	}

	public boolean isEmpty() {
		return vector.isEmpty();
	}

	public int size() {
		return vector.size();
	}

}
