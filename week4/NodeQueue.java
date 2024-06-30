package Week4_StacksQueues;

public class NodeQueue<E> implements Queue<E> {

	protected Node<E> head, tail;
	protected int size;
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void enqueue(E e) {
		Node<E> newNode = new Node<E>(e, null);
		if(size==0) head = newNode;
		else tail.setNext(newNode);
		tail = newNode;
		size++;
	}
	public E dequeue() throws IllegalStateException{
		if(size==0) throw new IllegalStateException("Queue is empty!");
		E element = head.getElement();
		head = head.getNext();
		size--;
		if(size==0) tail = null;
		return element;
	}
	public E front() {
		if(size==0) throw new IllegalStateException("Queue is empty!");
		return head.getElement();
	}
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayQueue<>(10);
		System.out.println(q.isEmpty());
		q.enqueue(3);
		System.out.println(q.isEmpty());
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
