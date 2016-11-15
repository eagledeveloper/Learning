package ch.gmtech.learning.refactoring.replaceinheritancewithdelegation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	
	private MyStack myStack;
	
	@Before
	public void setup() {
		myStack = new MyStack();
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(myStack.isEmpty());
	}
	
	@Test
	public void testPush() {
		Object objcet = new Object();
		myStack.push(objcet);
		assertEquals(1, myStack.size());
	}

	@Test
	public void testPop() {
		Object objcet = new Object();
		myStack.push(objcet);
		assertEquals(objcet, myStack.pop());
	}

}
