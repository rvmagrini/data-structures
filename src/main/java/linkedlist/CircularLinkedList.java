package linkedlist;

public class CircularLinkedList<T> {
	
	private ListNode<T> last;
	private int length;
	
	
	private static class ListNode<T> {
		private ListNode<T> next;
		private T value;
		
		public ListNode(T value) {
			this.value = value;
		}
	}
	
	
	public CircularLinkedList() {
		last = null;
		length = 0;
	}
	
	
	public int length() {
		return length;
	}
	
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	
	public void printList() {
		ListNode<T> currentNode = last.next;
		System.out.print("-> ");
		while (currentNode != last) {
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println(currentNode.value + " -> ");
	}
	
	
	public void insertFirst(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		
		if (isEmpty()) {
			last = newNode;
		} else {
			newNode.next = last.next;
		}
		
		last.next = newNode;;
		length++;
	}
	
	
	public void insertLast(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		
		if (isEmpty()) {
			last = newNode;
			last.next = last;
		} else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		
		length++;
	}
	
	
	
	
	public static void main(String[] args) {
		
		// Circular Singly LinkedList
		CircularLinkedList<Integer> circularIntLL = new CircularLinkedList<>();
		
		ListNode<Integer> first = new ListNode<>(1);
		ListNode<Integer> second = new ListNode<>(2);
		ListNode<Integer> third = new ListNode<>(3);
		ListNode<Integer> fourth = new ListNode<>(4);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		circularIntLL.last = fourth;
		circularIntLL.length = 4;
		System.out.println("isEmpty: " + circularIntLL.isEmpty());
		System.out.println("length: " + circularIntLL.length());
		
		// Print
		circularIntLL.printList();
		
		// Insert first
		circularIntLL.insertFirst(55);
		circularIntLL.printList();
		System.out.println("length: " + circularIntLL.length());
		System.out.println("first: " + circularIntLL.last.next.value + " last: " + circularIntLL.last.value);

		// Insert last
		circularIntLL.insertLast(88);
		circularIntLL.printList();
		System.out.println("length: " + circularIntLL.length());
		System.out.println("first: " + circularIntLL.last.next.value + " last: " + circularIntLL.last.value);

	}

}
