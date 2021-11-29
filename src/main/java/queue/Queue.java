package queue;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	private ListNode<T> front;
	private ListNode<T> rear;
	private int length;
	
	public Queue() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}
	
	
	private static class ListNode<T> {
		private ListNode<T> next;
		private T value;
		
		public ListNode(T value) {
			this.value = value;
		}
	}
	
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	
	public int length() {
		return length;
	}
	
	
	public void enqueue(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		
		if (isEmpty()) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		
		rear = newNode;
		length++;
	}
	
	
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		
		T frontNode = front.value;
		front = front.next;
		
		if (front == null) {
			rear = null;
		}
		
		length--;
		return frontNode;
	}
	
	
	public T first() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		
		return front.value;
	}
	
	
	public T last() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		
		return rear.value;
	}
	
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "Queue [front=" + front + ", rear=" + rear + ", length=" + length + "]: Queue is empty";
		} else {
			String str = "Queue [front=" + front.value + ", rear=" + rear.value + ", length=" + length + "]: (front) " + front.value;
			ListNode<T> currentNode = front.next;
			while (currentNode != null) {
				str += " - " + currentNode.value;
				currentNode = currentNode.next;
			}
			
			str += " (rear) - null";
			return str;
		}
	}

	

	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<>();
		System.out.println(queue);
		
		// Enqueue
		System.out.println("[Enqueued 1 2 3 4 5]");
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue);
		
		// Dequeue
		System.out.println("[Dequeued]: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("[Dequeued]: " + queue.dequeue());
		System.out.println("[Dequeued]: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("[Dequeued]: " + queue.dequeue());
		System.out.println("[Dequeued]: " + queue.dequeue());
		System.out.println(queue);
		
		// Enqueue
		queue.enqueue(5);
		System.out.println(queue);
		queue.enqueue(4);
		System.out.println(queue);
		queue.enqueue(3);
		System.out.println(queue);
		
		// First and Last
		System.out.println("First: " + queue.first());
		System.out.println("Last: " + queue.last());
		
	}

}
