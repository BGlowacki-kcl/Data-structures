package Week4_StacksQueues;

public class Node<E> {
	public E element;
	public Node<E> next;
	 
	public Node(E el, Node<E> node) {
		element = el;
		next = node;
	}
	public Node() {
		this(null, null);
	}
	public E getElement() {
		return element;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setElement(E el) {
		this.element = el;
	}
	public void setNext(Node<E> node) {
		this.next = node;
	}
}
