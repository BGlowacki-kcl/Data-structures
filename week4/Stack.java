package Week4_StacksQueues;

public interface Stack<E> {
	
	void push(E el);
	E pop();
	E top();
	boolean isEmpty();
	int size();
	
}
