package queue;

public class Queue<T> {
	
	private ListNode<T> front;
	private ListNode<T> rear;
	private int length;
	
	
	private static class ListNode<T> {
		private ListNode<T> next;
		private T value;
		
		public ListNode(T value) {
			this.value = value;
		}
	}
	
	
	public Queue() {
		front = null;
		rear = null;
		length = 0;
	}
	
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	
	public int length() {
		return length;
	}
	
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "Queue [front=" + front + ", rear=" + rear + ", length=" + length + "]: Queue is empty";
		} else {
			String str = "Queue [front=" + front.value + ", rear=" + rear.value + ", length=" + length + "]: (front) " + front.value;
			ListNode<T> currentNode = front.next;
			while (currentNode != null) {
				str += " - " + currentNode.value;
				currentNode = currentNode.next;
			}
			
			str += " (rear) - null";
			return str;
		}
	}

	

	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<>();
		System.out.println(queue);
		queue.front = new ListNode<Integer>(1);
		queue.rear = new ListNode<Integer>(2);
		queue.front.next = queue.rear;
		queue.length = 2;
		System.out.println(queue);
		
	}

}
