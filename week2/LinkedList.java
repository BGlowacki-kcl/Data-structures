package Week2_linkedLists;

public class LinkedList<E> {
	protected Node<E> head;
	protected Node<E> tail;
	long size;
	
	public LinkedList(){
		tail = null;
		head = null;
		size = 0;
	}
	public void insertAtHead(E newElement) {
		head = new Node<E>(newElement, head);
		size++;
		if(size == 1) {
			tail = head;
		}
	}
	public E removeAtHead() {
		if(head == null) {
			return null;
		} else {
			E elem = head.getElement();
			head.setElement(null);
			head = head.getNext();
			size--;
			if(head==null) {
				tail = null;
			}
			return elem;
		}
	}
	
	public void insertAtTail(E newElement) {
		Node<E> newNode = new Node<E>(newElement, null);
		tail.setNext(newNode);
		tail = newNode;
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertAtHead(3);
		list.insertAtHead(10);
		list.insertAtHead(15);
		list.insertAtTail(5);
		list.removeAtHead();
		list.insertAtHead(2);
		list.insertAtHead(3);
		list.removeAtHead();
		Node<Integer> l = list.head;
		for(long i = 0; i < list.size; i++) {
			System.out.print(l.getElement() + " ");
			l = l.getNext();
		}
	}
}
