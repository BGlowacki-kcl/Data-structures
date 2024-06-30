package Week9_BinarySearchTree;

import java.util.Comparator;

public class BinarySearchTree<K,V> {
	private Node<K,V> root;
	private int size;
	private Comparator<K> comp;
	
	public BinarySearchTree() {
		root = createNode(null);
		size = 0;
		root.setLeft(createNode(root));
		root.setRight(createNode(root));
		comp = new DefaultComparator<K>();
	}
	public BinarySearchTree(Comparator<K> c) {
		this();
		comp = c;
	}
	public int size() {
		return size;
	}
	private Node<K,V> createNode(Node<K,V> parent) {
		return new Node<K,V>(parent);
	}
	@SuppressWarnings("unused")
	private Node<K,V> createNode(K k, V v) {
		return new Node<K,V>(k, v);
	}
	@SuppressWarnings("unused")
	private int compare(K a, K b) {
		return comp.compare(a, b);
	}
	private Node<K,V> findNode(K k) throws ClassCastException{
		Node<K,V> temp = root;
		boolean ifFound = false;
		while(!ifFound) {
			if(temp.getKey() == null) {
				ifFound = true;
				continue;
			}
			if(comp.compare(temp.getKey(), k) > 0) {
				temp = temp.getLeft();
			} else if(comp.compare(temp.getKey(), k) < 0) {
				temp = temp.getLeft();
			}else {
				ifFound = true;
			}
		}
		return temp;
	}
	public V put(K k, V v) {
		Node<K,V> temp = findNode(k);
		if(temp.getKey() == null) {
			temp.setKey(k);
			temp.setValue(v);
			temp.setLeft(createNode(temp));
			temp.setRight(createNode(temp));
			return null;
		}
		V ans = temp.getValue();
		temp.setValue(v);
		return ans;
	}
	public V get(K k) {
		Node<K,V> temp = findNode(k);
		if(temp.getKey() == null) {
			return null;
		}
		return temp.getValue();
	}
//	private Node<K,V>
//	public V remove(K k) {
//		Node<K,V> tempt = findNode(k);
//		
//	}
	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> b = new BinarySearchTree<>();
		b.put(2, 2);
		b.put(4, 4);
		b.put(1, 1);
		b.put(0, 0);
		System.out.println(b.get(1));
	}
}