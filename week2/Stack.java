package Week2_linkedLists;

public class Stack<E> {

	private int t = -1;
	private E[] array;
	int capacity = 1000;
	
	@SuppressWarnings("unchecked")
	public Stack(int cap) {
		array = (E[]) new Object[cap];
	}
	public int size() {
		return t+1;
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public void push(E element) throws IllegalStateException {
		if(size() == array.length)throw new IllegalStateException("Stack is full!");
		array[++t] = element;
	}
	public E pop() {
		if(size() == 0) {
			return null;
		}
		E element = array[t];
		array[t--] = null;
		return element;
	}
	public E top() {
		if(isEmpty()) return null;
		return array[t];
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(10);
		s.push(5);
		s.push(3);
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		System.out.println(s.pop());
	}
}
