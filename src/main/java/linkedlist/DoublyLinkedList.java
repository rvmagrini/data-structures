package linkedlist;

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
		
		System.out.print("null -> ");
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
		
		System.out.print("null -> ");
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
		
		// Insert last
		doublyIntLL.insertLast(77);
		doublyIntLL.insertLast(33);
		System.out.println("[Inserted 77 and 33 last]");
		System.out.print("Print forward: "); 
		doublyIntLL.printForward();
		System.out.println("Length: " + doublyIntLL.length());
	
	}

}