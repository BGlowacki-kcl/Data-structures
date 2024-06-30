package Week4_StacksQueues;

public interface Queue<E> {
	
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E front();
	
}
