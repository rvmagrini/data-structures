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
		
		//Print
		singlyIntLinkedList.printList();
		
		// Length
		System.out.println("Length: " + singlyIntLinkedList.length());

    }
}

