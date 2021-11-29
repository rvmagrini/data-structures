package stack;

public class Stack<T> {
	
	private ListNode<T> top;
	private int length;
	
	
	private static class ListNode<T> {
		private ListNode<T> next;
		private T value;
		
		public ListNode(T value) {
			this.value = value;
		}
	}
	
	
	public Stack() {
		top = null;
		length = 0;
	}
	
	
	public int length() {
		return length;
	}
	
	
	public boolean isEmpty() {
		return length == 0;
	}


	@Override
	public String toString() {
		String str;
		
		if (isEmpty()) {
			str = "Stack [top=" + top + ", length=" + length + "]: Stack is empty";
		} else {
			str = "Stack [top=" + top.value + ", length=" + length + "]";
			str += ": [" + top.value + "]";
			ListNode<T> currentNode = top.next;
			while (currentNode != null) {
				str += " | " + currentNode.value;
				currentNode = currentNode.next;
			}
			str += " | null";
		}
		
		return str;
	}
	
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		ListNode<Integer> first = new ListNode<Integer>(1);
		stack.top = first;
		stack.length++;
		ListNode<Integer> second = new ListNode<Integer>(2);
		first.next = second;
		stack.length++;
		ListNode<Integer> third = new ListNode<Integer>(3);
		second.next = third;
		stack.length++;
		ListNode<Integer> fourth = new ListNode<Integer>(4);
		third.next = fourth;
		stack.length++;
		ListNode<Integer> fifth = new ListNode<Integer>(5);
		fourth.next = fifth;
		stack.length++;
		System.out.println(stack);
	}
	

}
