package linkedlist;

public class SinglyLinkedList<T> {
	
	private ListNode<T> head;
	
	
	private static class ListNode<T> {
		private T data;
		private ListNode<T> next;
		
		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	public void printList() {
		ListNode<T> currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}
	
	
	public int length() {
		if (head == null) {
			return 0;
		}
		
		int length = 0;
		ListNode<T> currentNode = head;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.next;
		}
		
		return length;
	}
	
	
	public void insertAtTheBeginning(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		newNode.next = head;
		head = newNode;
	}
	
	
	public void insertAtTheEnd(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		ListNode<T> currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	
	public void insertAt(int position, T data) {
		ListNode<T> newNode = new ListNode<>(data);
		
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode<T> previousNode = head;
			int previousPosition = 1;
			while (previousPosition < position-1) {
				previousNode = previousNode.next;
				previousPosition++;
			}
			ListNode<T> currentNode = previousNode.next;
			newNode.next = currentNode;
			previousNode.next = newNode;
		}
	}
	
	
	public ListNode<T> deleteFirstNode() {
		if (head == null) {
			return null;
		}
		
		ListNode<T> deletePointer = head;
		head = head.next;
		deletePointer.next = null;
		return deletePointer;
	}
	
	
	public ListNode<T> deleteLastNode() {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode<T> deletePointer = head;
		ListNode<T> previousNode = null;
		while (deletePointer.next != null) {
			previousNode = deletePointer;
			deletePointer = deletePointer.next;
		}
		previousNode.next = null;
		return deletePointer;
	}
	
	
	public ListNode<T> deleteNodeAt(int position) {
		if (position == 1) {
			return deleteFirstNode();
		} else {
			ListNode<T> previousNode = head;
			int previousPosition = 1;
			while (previousPosition < position-1) {
				previousNode = previousNode.next;
				previousPosition++;
			}
			ListNode<T> deletePointer = previousNode.next;
			previousNode.next = deletePointer.next;
			return deletePointer;
		}
	}
	
	
	public ListNode<T> deleteNode(T data) {
		ListNode<T> deletePointer = head;
		ListNode<T> previousNode = null;
		
		if (deletePointer != null && deletePointer.data == data) {
			head = deletePointer.next;
			return deletePointer;
		}
		
		while (deletePointer != null && deletePointer.data != data) {
			previousNode = deletePointer;
			deletePointer = deletePointer.next;
		}
		
		if (deletePointer == null) {
			return null;
		}
		
		previousNode.next = deletePointer.next;
		return deletePointer;
	}
	
	
	public boolean contains(T data) {
		if (head == null) {
			return false;
		}
		
		ListNode<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.data == data) {
				return true;
			}
			currentNode = currentNode.next;
		}
		
		return false;
	}
	
	
	public ListNode<T> getMiddleNode() {
		if (head == null) {
			return null;
		}
		
		ListNode<T> slowPointer = head;
		ListNode<T> fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}
	
	
	public ListNode<T> getNthNodeFromEnd(int n) {
		if (head == null) {
			return null;
		}
		
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value");
		}
		
		ListNode<T> mainPointer = head;
		ListNode<T> refPointer = head;
		int counter = 0;
		
		while (counter < n) {
			if (refPointer == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPointer = refPointer.next;
			counter++;
		}
		
		while (refPointer != null) {
			refPointer = refPointer.next;
			mainPointer = mainPointer.next;
		}
		
		return mainPointer;
	}
	
	
	public void reverse() {
		if (head == null) {
			return;
		}
		
		ListNode<T> currentNode = head;
		ListNode<T> newHead = null;
		ListNode<T> nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = newHead;
			newHead = currentNode;
			currentNode = nextNode;
		}
		head = newHead;
	}
	
	
	public void removeDuplicationFromSortedList(SinglyLinkedList<T> sortedList) {
		if (sortedList.head == null) {
			return;
		}
		
		ListNode<T> currentNode = sortedList.head;
		while (currentNode != null && currentNode.next != null) {
			if (currentNode.data == currentNode.next.data) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}
	}
	
	
	public ListNode<T> containsLoop() {
		ListNode<T> fastPointer = head;
		ListNode<T> slowPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if (slowPointer == fastPointer) {
				System.out.println("This List has a loop and its first node is -> " + getFirstNodeOfTheLoop(slowPointer).data);
				return slowPointer;
			}
		}
		System.out.println("This List does not have a loop");
		return null;
	}
	
	
	public ListNode<T> getFirstNodeOfTheLoop(ListNode<T> slowPointer) {
		ListNode<T> firstLoopNodePointer = head;
		
		while (slowPointer != firstLoopNodePointer) {
			firstLoopNodePointer = firstLoopNodePointer.next;
			slowPointer = slowPointer.next;
		}
		
		return firstLoopNodePointer;
	}
	
	
	public void removeLoop(ListNode<T> slowPointer) {
		ListNode<T> pointer = head;
		
		while (slowPointer.next != pointer.next) {
			pointer = pointer.next;
			slowPointer = slowPointer.next;
		}
		slowPointer.next = null;
	}
	
	
	
	
	public static void main(String[] args) {
		
		// Singly LinkedList
		System.out.println("Singly LinkedList");
		SinglyLinkedList<Integer> singlyIntLinkedList = new SinglyLinkedList<Integer>();
		singlyIntLinkedList.head = new ListNode<Integer>(10);
		ListNode<Integer> second = new ListNode<Integer>(1);
		ListNode<Integer> third = new ListNode<Integer>(8);
		ListNode<Integer> fourth = new ListNode<Integer>(11);
		
		// Creating chain
		singlyIntLinkedList.head.next = second;
		second.next = third;
		third.next = fourth;
		
		// Print
		singlyIntLinkedList.printList();
		
		// Length
		System.out.println("Length: " + singlyIntLinkedList.length());
		
		// Insert at the beginning
		System.out.println("Inserted 15 and 87 at the beginning:");
		singlyIntLinkedList.insertAtTheBeginning(15);
		singlyIntLinkedList.insertAtTheBeginning(87);
		singlyIntLinkedList.printList();
		
		// Insert at the end
		System.out.println("Inserted 14 and 77 at the end:");
		singlyIntLinkedList.insertAtTheEnd(14);
		singlyIntLinkedList.insertAtTheEnd(77);
		singlyIntLinkedList.printList();
		
		// Insert at position
		System.out.println("Inserted 7 at position 3:");
		singlyIntLinkedList.insertAt(3, 7);
		singlyIntLinkedList.printList();
		
		// Delete first node
		System.out.println("Deleted first node: " + singlyIntLinkedList.deleteFirstNode().data);
		singlyIntLinkedList.printList();
			
		// Delete last node
		System.out.println("Deleted last node: " + singlyIntLinkedList.deleteLastNode().data);
		singlyIntLinkedList.printList();
			
		// Delete node at given position
		System.out.println("Deleted node at position 4: " + singlyIntLinkedList.deleteNodeAt(4).data);
		singlyIntLinkedList.printList();
		
		// Delete node with given value
		System.out.println("Deleted node with value: " + singlyIntLinkedList.deleteNode(8).data);
		singlyIntLinkedList.printList();
		
		// Contains
		System.out.print("Contains 11: ");
		System.out.println(singlyIntLinkedList.contains(11));
		System.out.print("Contains 55: ");
		System.out.println(singlyIntLinkedList.contains(55));
		
		// Get middle node
		System.out.println("Middle node when length is odd: " + singlyIntLinkedList.getMiddleNode().data);
		System.out.println("Inserted 20 at the beginning:");
		singlyIntLinkedList.insertAtTheBeginning(20);
		singlyIntLinkedList.printList();
		System.out.println("Middle node when length is even: " + singlyIntLinkedList.getMiddleNode().data);
			
		// Get Nth node from the end of the list
		System.out.println("5th item from the end of the list: " + singlyIntLinkedList.getNthNodeFromEnd(5).data);
		
		// Reverse List
		System.out.println("Reversed list:");
		singlyIntLinkedList.reverse();
		singlyIntLinkedList.printList();
		
		// ========================
		// Sorted Singly LinkedList
		System.out.println("========================");
		System.out.println("Sorted Singly LinkedList");
		SinglyLinkedList<Integer> sortedLinkedList = new SinglyLinkedList<Integer>();
		sortedLinkedList.insertAtTheEnd(1);
		sortedLinkedList.insertAtTheEnd(1);
		sortedLinkedList.insertAtTheEnd(2);
		sortedLinkedList.insertAtTheEnd(3);
		sortedLinkedList.insertAtTheEnd(3);
		sortedLinkedList.insertAtTheEnd(4);
		sortedLinkedList.printList();
		
		// Removing duplication
		sortedLinkedList.removeDuplicationFromSortedList(sortedLinkedList);
		System.out.println("Removed duplication:");
		sortedLinkedList.printList();
		
		// ===========================
		// Singly LinkedList with Loop
		System.out.println("========================");
		System.out.println("Singly LinkedList with Loop");
		SinglyLinkedList<Integer> loopLinkedList = new SinglyLinkedList<Integer>();
		loopLinkedList.head = new ListNode<Integer>(1);
		ListNode<Integer> two = new ListNode<>(2);
		ListNode<Integer> three = new ListNode<>(3);
		ListNode<Integer> four = new ListNode<>(4);
		ListNode<Integer> five = new ListNode<>(5);
		ListNode<Integer> six = new ListNode<>(6);
		loopLinkedList.head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = two; // loop
		
		// Contains loop & Get first node of the loop
		System.out.println("Contains loop:");
		System.out.print("Singly LinkedList: ");
		singlyIntLinkedList.containsLoop();
		System.out.print("Sorted LinkedList: ");
		sortedLinkedList.containsLoop();
		System.out.print("Singly LinkedList with Loop: ");
		loopLinkedList.containsLoop();
		
		// Remove Loop
		loopLinkedList.removeLoop(loopLinkedList.containsLoop());
		System.out.println("Loop removed: ");
		loopLinkedList.printList();
	

    }
}

