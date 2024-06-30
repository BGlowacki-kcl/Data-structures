package Week5_Lists;

public class DNode<E> implements Position<E>{
	private E element;
	private DNode<E> prev, next;
	
	public DNode(DNode<E> newPrev, DNode<E> newNext, E newElement) {
		prev = newPrev;
		next = newNext;
		element = newElement;
	}
	public E element() throws IllegalStateException{
		if(next == null || prev == null) {
			throw new IllegalStateException("Invalid position!");
		}
		return element;
	}
	public void setNext(DNode<E> newNext) {
		next = newNext;
	}
	public void setPrev(DNode<E> newPrev) {
		prev = newPrev;
	}
	public void setElement(E newElement) {
		element = newElement;
	}
	public DNode<E> getNext(){
		return next;
	}
	public DNode<E> getPrev(){
		return prev;
	}
}
