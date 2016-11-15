package ch.gmtech.learning.refactoring.replaceinheritancewithdelegation.original;

import java.util.Vector;

public class MyStack extends Vector<Object> {

	public void push(Object element) {
		insertElementAt(element, 0);
	}

	public Object pop() {
		Object result = firstElement();
		removeElementAt(0);
		return result;
	}

}
