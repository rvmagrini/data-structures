package linkedlist;

public class DoublyLinkedList<T> {
	
	private ListNode<T> head;
	private ListNode<T> tail;
	private int length;
	
	
	private static class ListNode<T> {
		private T data;
		private ListNode<T> previous;
		private ListNode<T> next;
		
		public ListNode(T data) {
			this.data = data;
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
	
	
	
	
	public static void main(String[] args) {
		
		// Doubly LinkedList
		System.out.println("Doubly LinkedList");
		DoublyLinkedList<Integer> doublyIntLinkedList = new DoublyLinkedList<Integer>();
		System.out.print("isEmpty: ");
		System.out.println(doublyIntLinkedList.isEmpty());
		System.out.print("length: ");
		System.out.println(doublyIntLinkedList.length());		
	
	}

}
