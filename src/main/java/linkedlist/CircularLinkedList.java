package linkedlist;

import java.util.NoSuchElementException;

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
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
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
	
	
	public T deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is empty");
		}
		
		ListNode<T> deletePointer = last.next;
		if (last.next == last) {
			last = null;
		} else {
			last.next = last.next.next;
		}
		
		deletePointer.next = null;
		length--;
		return deletePointer.value;
		
	}
	
	
	public T deleteLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is empty");
		}
		
		ListNode<T> deletePointer = last.next;
		if (last == last.next) {
			last = null;
		} else {
			ListNode<T> previousNode = null;
			while (deletePointer != last) {
				previousNode = deletePointer;
				deletePointer = deletePointer.next;
			}
			
			previousNode.next = last.next;
			last = previousNode;
		}
		
		deletePointer.next = null;
		length--;
		return deletePointer.value;
	}
	
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "List is empty";
		}
		
		ListNode<T> currentNode = last.next;
		String str = "CircularLinkedList: -> ";
		while (currentNode != last) {
			str += currentNode.value + " -> ";
			currentNode = currentNode.next;
		}
		str += currentNode.value + " -> ";
		return str;
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
		
		// Print
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		
		// Insert first
		System.out.print("[Inserted 55 and 33 first] ");
		circularIntLL.insertFirst(55);
		circularIntLL.insertFirst(33);
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		
		// Insert last
		System.out.print("[Inserted 88 and 99 last] ");
		circularIntLL.insertLast(88);
		circularIntLL.insertLast(99);
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		
		// Delete first
		System.out.print("[Deleted first node: " + circularIntLL.deleteFirst() + "] ");
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		
		// Delete last
		System.out.print("[Deleted last node: " + circularIntLL.deleteLast() + "] ");
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		
		circularIntLL.deleteLast();
		circularIntLL.deleteLast();
		circularIntLL.deleteLast();
		circularIntLL.deleteLast();
		circularIntLL.deleteLast();
		System.out.println("length " + circularIntLL.length() + " | firstNode " + circularIntLL.last.next.value + " | lastNode " + circularIntLL.last.value);
		circularIntLL.deleteLast();
		System.out.println(circularIntLL);
		circularIntLL.printList();
		System.out.println("length " + circularIntLL.length());

		
	}

}
