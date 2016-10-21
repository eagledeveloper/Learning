package ch.gmtech.learning.lesson6;

public class SimpleIntegerQueue {

	private int[] queue;
	private int front;
	private int rear;
	private int MAXSIZE;
	
	public SimpleIntegerQueue(int dimension) {
		this.MAXSIZE = dimension;
		queue = new int[MAXSIZE];
		front = 0;
		rear = -1;
	}

	public int peek() {
		return queue[front];
	}

	public boolean isFull() {
		if (rear == MAXSIZE - 1)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (front < 0 || front > rear)
			return true;
		return false;
	}

	public int enqueue(int data) {
		if (isFull())
			return 0;
		
		rear = rear + 1;
		queue[rear] = data;
		return 1;
	}

	public int dequeue() {
		if (isEmpty())
			return 0;

		int data = queue[front];
		front = front + 1;
		return data;
	}

}
