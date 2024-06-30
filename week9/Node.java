package Week9_BinarySearchTree;

public class Node<K,V>{
	private Node<K,V> parent;
	private Node<K,V> left;
	private Node<K,V> right;
	private K key;
	private V value;
		
	public Node() {
		key = null;
		value = null;
		parent = left = right = null;
	}
	public Node(Node<K,V> p) {
		parent = p;
		key = null;
		value = null;
		left = right = null;
	}
	public Node(K k, V v) {
		key = k;
		value = v;
		parent = left = right = null;
	}
	public void setParent(Node<K,V> n) {
		parent = n;
	}
	public void setLeft(Node<K,V> n) {
		parent = n;
	}
	public void setRight(Node<K,V> n) {
		parent = n;
	}
	public Node<K,V> getParent() {
		return parent;
	}
	public Node<K,V> getLeft() {
		return left;
	}
	public Node<K,V> getRight() {
		return right;
	}
	public void setKey(K k) {
		key = k;
	}
	public void setValue(V v) {
		value = v;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
