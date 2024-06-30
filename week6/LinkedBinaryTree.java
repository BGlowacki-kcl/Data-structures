package Week6_Trees;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		public E element() { return element; }
		public E getElement() { return element; }
		public Node<E> getParent() { return parent; }
		public Node<E> getLeft() { return left; }
		public Node<E> getRight() { return right; }
		
		public void setElement(E e) { element = e; }
		public void setParent(Node<E> parentNode) { parent = parentNode; }
		public void setLeft(Node<E> leftChild) { left = leftChild; }
		public void setRight(Node<E> rightChild) { right = rightChild; }
	}
	
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type.");
		Node<E> node = (Node<E>) p;
		if(node.getParent() == node)
			throw new IllegalArgumentException("p is no longer in the tree.");
		return node;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public Position<E> root() {
		return root;
	}
	public Node<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	public Node<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	public Node<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	public Position<E> addRoot(E e) throws IllegalArgumentException{
		if(!isEmpty()) throw new IllegalArgumentException("Tree is not empty!");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getLeft() != null) throw new IllegalArgumentException("p has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getRight() != null) throw new IllegalArgumentException("p has right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if(isInternal(p)) throw new IllegalArgumentException("p must be a leaf.");
		size += t1.size() + t2.size();
		if(!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(node);
			t2.root = null;
			t2.size = 0;
		}
	}
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if(child != null) {
			child.setParent(node.getParent());
		}
		if(node == root) {
			root = child;
		} else {
			Node<E> parent = node.getParent();
			if(node == parent.getLeft()) parent.setLeft(child);
			else parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setLeft(null);
		node.setElement(null);
		node.setRight(child);
		node.setParent(node);
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	private void preorder(Node<E> p){
		System.out.print(p.getElement()+" ");
		if(p.getLeft() != null)
			preorder(p.getLeft());
		if(p.getRight() != null)
			preorder(p.getRight());
	}
	private void postorder(Node<E> p){
		if(p.getLeft() != null)
			postorder(p.getLeft());
		if(p.getRight() != null)
			postorder(p.getRight());
		System.out.print(p.getElement()+" ");
	}
	private void inorder(Node<E> p){
		if(p.getLeft() != null)
			inorder(p.getLeft());
		System.out.print(p.getElement()+" ");
		if(p.getRight() != null)
			inorder(p.getRight());
	}
	
	public static void main(String[] args) {
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
		t.addRoot(5);
		Position<Integer> temp = t.addLeft(t.root(), 3);
		t.addRight(t.root(), 2);
		t.addLeft(temp, 5);
		t.addRight(temp, 10);
		t.preorder((Node<Integer>) t.root());
		System.out.println();
		t.postorder((Node<Integer>) t.root());
		System.out.println();
		t.inorder((Node<Integer>) t.root());
	}
	
}
