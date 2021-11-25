package linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
	
	private ListNode<T> head;
	private ListNode<T> tail;
	private int length;
	
	
	private static class ListNode<T> {
		private T value;
		private ListNode<T> previous;
		private ListNode<T> next;
		
		public ListNode(T value) {
			this.value = value;
		}
	}
	
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	
	public int length() {
		return length;
	}
	
	
	public void printForward() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		
		ListNode<T> currentNode = head;
		
		while (currentNode != null) {
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}
	
	
	public void printBackward() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		
		ListNode<T> currentNode = tail;
		
		while (currentNode != null) {
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.previous;
		}
		System.out.println("null");
	}
	
	
	public void insertFirst(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	
	public void insertLast(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		
		tail = newNode;
		length++;
	}
	
	
	public ListNode<T> deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		ListNode<T> deletePointer = head;
		if (head == tail) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		
		head = head.next;
		deletePointer.next = null;
		length--;
		return deletePointer;
	}
	
	
	public ListNode<T> deleteLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		ListNode<T> deletePointer = tail;
		if (tail == head) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		
		tail = tail.previous;
		deletePointer.previous = null;
		length--;
		return deletePointer;
	}
	
	
	
	
	public static void main(String[] args) {
		
		// Doubly LinkedList
		System.out.println("Doubly LinkedList");
		DoublyLinkedList<Integer> doublyIntLL = new DoublyLinkedList<Integer>();
		System.out.println("isEmpty: " + doublyIntLL.isEmpty());
		System.out.println("length: " + doublyIntLL.length());
		
		// Chaining
		ListNode<Integer> first = new ListNode<>(1);
		ListNode<Integer> second = new ListNode<>(2);
		ListNode<Integer> third = new ListNode<>(3);
		ListNode<Integer> fourth = new ListNode<>(4);
		doublyIntLL.head = first;
		first.next = second;
		second.previous = first;
		second.next = third;
		third.previous = second;
		third.next = fourth;
		fourth.previous = third;
		doublyIntLL.tail = fourth;
		doublyIntLL.length = 4;
		
		System.out.println("Head Node: " + doublyIntLL.head.value);
		System.out.println("Tail Node: " + doublyIntLL.tail.value);
		System.out.println("isEmpty: " + doublyIntLL.isEmpty());
		System.out.println("Length: " + doublyIntLL.length());
		
		// Print list
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.print("Print backward: ");
		doublyIntLL.printBackward();
		
		// Insert first
		doublyIntLL.insertFirst(15);
		doublyIntLL.insertFirst(25);
		System.out.println("[Inserted 15 and 25 first]");
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.println("Length: " + doublyIntLL.length());

		
		// Insert last
		doublyIntLL.insertLast(77);
		doublyIntLL.insertLast(33);
		System.out.println("[Inserted 77 and 33 last]");
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.println("Length: " + doublyIntLL.length());
		
		// Delete first
		System.out.println("[Deleted first node]: " + doublyIntLL.deleteFirst().value);
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.println("Length: " + doublyIntLL.length());
		
		// Delete last
		System.out.println("[Deleted last node]: " + doublyIntLL.deleteLast().value);
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.println("Length: " + doublyIntLL.length());

		
	}

}
