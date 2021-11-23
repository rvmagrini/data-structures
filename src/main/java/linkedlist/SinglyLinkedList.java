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
		ListNode<T> currentItem = head;
		while (currentItem != null) {
			System.out.print(currentItem.data + " -> ");
			currentItem = currentItem.next;
		}
		System.out.println("null");
	}
	
	
	public int length() {
		if (head == null) {
			return 0;
		}
		
		int length = 0;
		ListNode<T> currentItem = head;
		while (currentItem != null) {
			length++;
			currentItem = currentItem.next;
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
		
		ListNode<T> currentItem = head;
		while (currentItem.next != null) {
			currentItem = currentItem.next;
		}
		currentItem.next = newNode;
	}
	
	
	public void insertAt(int position, T data) {
		ListNode<T> newNode = new ListNode<>(data);
		
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode<T> previousItem = head;
			int previousPosition = 1;
			while (previousPosition < position-1) {
				previousItem = previousItem.next;
				previousPosition++;
			}
			ListNode<T> currentItem = previousItem.next;
			newNode.next = currentItem;
			previousItem.next = newNode;
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
		ListNode<T> previousItem = null;
		while (deletePointer.next != null) {
			previousItem = deletePointer;
			deletePointer = deletePointer.next;
		}
		previousItem.next = null;
		return deletePointer;
	}
	
	
	public ListNode<T> deleteNodeAt(int position) {
		if (position == 1) {
			return deleteFirstNode();
		} else {
			ListNode<T> previousItem = head;
			int previousPosition = 1;
			while (previousPosition < position-1) {
				previousItem = previousItem.next;
				previousPosition++;
			}
			ListNode<T> deletePointer = previousItem.next;
			previousItem.next = deletePointer.next;
			return deletePointer;
		}
	}
	
	
	public ListNode<T> deleteNode(T data) {
		ListNode<T> deletePointer = head;
		ListNode<T> previousItem = null;
		
		if (deletePointer != null && deletePointer.data == data) {
			head = deletePointer.next;
			return deletePointer;
		}
		
		while (deletePointer != null && deletePointer.data != data) {
			previousItem = deletePointer;
			deletePointer = deletePointer.next;
		}
		
		if (deletePointer == null) {
			return null;
		}
		
		previousItem.next = deletePointer.next;
		return deletePointer;
	}
	
	
	
	
	public static void main(String[] args) {
		
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

    }
}

