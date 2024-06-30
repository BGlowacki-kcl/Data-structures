package Week5_Lists;

public class NodePositionList<E> implements PositionList<E>{

	protected int numElts;
	protected DNode<E> header, trailer;
	
	public NodePositionList() {
		numElts = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(header, null, null);
		header.setNext(trailer);
	}
	public DNode<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof DNode)) throw new IllegalArgumentException("Invalid p!");
		DNode<E> node = (DNode<E>) p;
		if(node.getNext() == null) throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}
	private Position<E> position(DNode<E> node){
		if(node == header || node == trailer) return null;
		return node;
	}
	public int size() {
		return numElts;
	}
	public boolean isEmpty() {
		return numElts==0;
	}
	public Position<E> first() {
		return header.getNext();
	}
	public Position<E> last() {
		return trailer.getPrev();
	}
	public Position<E> next(Position<E> p) throws IllegalArgumentException{
		DNode<E> node = validate(p);
		return position(node.getNext());
	}
	public Position<E> prev(Position<E> p) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		return position(node.getPrev());
	}
	private Position<E> addBetween(E e, DNode<E> pred, DNode<E> succ){
		DNode<E> newest = new DNode<>(pred, succ, e);
		pred.setNext(newest);
		succ.setPrev(newest);
		numElts++;
		return newest;
	}
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public void addNext(Position<E> p, E e) throws IllegalArgumentException{
		DNode<E> node = validate(p);
		addBetween(e, node, node.getNext());
	}
	public void addPrev(Position<E> p, E e) throws IllegalArgumentException{
		DNode<E> node = validate(p);
		addBetween(e, node.getPrev(), node);
	}
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		DNode<E> node = validate(p);
		E ans = node.element();
		node.setElement(e);
		return ans;
	}
	public E remove(Position<E> p) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		DNode<E> predecessor = node.getPrev();
		DNode<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		numElts--;
		E ans = node.element();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return ans;
	}
	public static void mian(String[] main) {
		
	}
}
