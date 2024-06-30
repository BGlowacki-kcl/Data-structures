package Week4_StacksQueues;

public class ArrayStack<E> implements Stack<E> {

	protected E[] stack;
	protected int top = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int cap){
		stack = (E[]) new Object[10];
	}
	
	public void push(E element) throws IllegalStateException {
		if(stack.length - 1 == top) throw new IllegalStateException("Stack is full!");
		stack[++top] = element;
	}
	public E pop() throws IllegalStateException{
		if(isEmpty()) throw new IllegalStateException("Stack is empty!");
		E element = stack[top];
		stack[top--] = null;
		return element;
	}
	public E top() throws IllegalStateException{
		if(isEmpty()) throw new IllegalStateException("Stack is empty!");
		return stack[top];
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public int size() {
		return top+1;
	}
	public static void main(String[] args) {
		Stack<Integer> s = new ArrayStack<>(10);
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
