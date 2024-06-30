package Week4_StacksQueues;

public class ArrayQueue<E> implements Queue<E> {
	
	protected int f;
	protected int r;
	protected E[] queue;
	protected int N;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int cap) {
		queue = (E[]) new Object[cap];
		r = f = 0;
		N = cap;
	}
	
	public int size() {
		return (r-f+N) % N; 
	}
	public boolean isEmpty() {
		return r == f;
	}
	public void enqueue(E e) throws IllegalStateException {
		if(size() == N-1) throw new IllegalStateException("Queue is full!");
		queue[r] = e;
		r = (r+1)%N;
	}
	public E dequeue() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException("Queue is empty!");
		E element = queue[f];
		queue[f] = null;
		f = (f+1)%N;
		return element;
	}
	public E front() throws IllegalStateException {
		if(isEmpty()) throw new IllegalStateException("Queue is empty!");
		return queue[f];
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayQueue<>(10);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.size());
		q.enqueue(4);
		q.enqueue(7);
		q.enqueue(9);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
