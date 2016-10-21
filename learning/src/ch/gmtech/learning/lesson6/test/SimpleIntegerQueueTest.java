package ch.gmtech.learning.lesson6.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.gmtech.learning.lesson6.SimpleIntegerQueue;

public class SimpleIntegerQueueTest {
	
	private SimpleIntegerQueue queue;
	
	@Before
	public void setUp() {
		queue = new SimpleIntegerQueue(3);
	}
	
	@Test
	public void isEmpty() {
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	public void isFull() {
	}
	
	@Test
	public void enqueueData() {
		assertEquals(1, queue.enqueue(1));
	}
	
	@Test
	public void dequeueData() {
	}
	
	@Test
	public void peekData() {
		
		
		assertEquals(false, queue.isEmpty());
		assertEquals(1, queue.enqueue(2));
		assertEquals(1, queue.enqueue(3));
		assertEquals(0, queue.enqueue(4));
		assertEquals(true, queue.isFull());
		assertEquals(1, queue.dequeue());
		assertEquals(false, queue.isFull());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		
	}

}
