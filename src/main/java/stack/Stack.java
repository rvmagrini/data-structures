package stack;

import java.util.EmptyStackException;

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
	
	
	public void push(T value) {
		ListNode<T> newNode = new ListNode<>(value);
		newNode.next = top;
		top = newNode;
		length++;
	}
	
	
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		T topValue = top.value;
		top = top.next;
		length--;
		return topValue;
	}
	
	
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.value;
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
		System.out.println(stack);
		
		// Push
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("[Pushed]: 1 2 3 4 5");
		System.out.println(stack);
		
		// Pop
		System.out.println("[Popped]: " + stack.pop());
		System.out.println(stack);
		System.out.println("[Popped]: " + stack.pop());
		System.out.println(stack);
		
		// Peek
		System.out.println("[Peeked]: " + stack.peek());
		System.out.println(stack);
		
		// Pop
		System.out.println("[Popped]: " + stack.pop());
		System.out.println(stack);
		System.out.println("[Popped]: " + stack.pop());
		System.out.println(stack);
		System.out.println("[Popped]: " + stack.pop());
		System.out.println(stack);
		
	}

}
