package Week7_PriorityQueue_Heap;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
	public HeapPriorityQueue() { super(); }
	public HeapPriorityQueue(Comparator<K> comp) { super(comp); }
	protected int parent(int j) { return (j-1) / 2; }
	protected int left(int j) { return 2*j + 1; }
	protected int right(int j) { return 2*j + 2; }
	protected boolean hasLeft(int j) { return left(j) < heap.size(); }
	protected boolean hasRight(int j) { return right(j) < heap.size(); }
	protected void swap(int i, int j) {
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	protected void upheap(int j) {
		while(j > 0) {
			int p = parent(j);
			if(compare(heap.get(j), heap.get(p)) >= 0) break;
			swap(j, p);
			j = p;
		}
	}
	protected void downheap(int j) {
		while(hasLeft(j)) {
			int leftIndex = left(j);
			int smallChildren = leftIndex;
			if(hasRight(j)) {
				int rightIndex = right(j);
				if(compare(heap.get(leftIndex),heap.get(rightIndex)) > 0)
					smallChildren = rightIndex;
			}
			if(compare(heap.get(smallChildren), heap.get(j)) >= 0) break;
			swap(j, smallChildren);
			j = smallChildren;
		}
	}
	public int size() { return heap.size(); }
	public Entry<K,V> min(){
		if(heap.isEmpty()) return null;
		Entry<K,V> h = heap.get(0);
		System.out.println(h.getValue());
		return h;
	}
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);
		heap.add(newest);
		upheap(heap.size() - 1);
		return newest;
	}
	public Entry<K,V> removeMin() {
		if(heap.isEmpty()) return null;
		Entry<K,V> ans = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size() - 1);
		downheap(0);
		System.out.println(ans.getValue());
		return ans;
	}
	public static void main(String[] args) {
		HeapPriorityQueue<Integer, String> q = new HeapPriorityQueue<>();
		q.insert(5, "numer 5");
		q.insert(2, "numer 2");
		q.insert(10, "numer 10");
		q.insert(50, "numer 50");
		q.insert(1, "numer 1");
		q.removeMin();
		q.min();
		q.min();
		q.removeMin();
		q.insert(1, "numer 1");
		q.removeMin();
		q.removeMin();
		
		int[] a = {0, 10, 42, 3, 25, 3, 25, 49, 1, 102, 5};
		HeapPriorityQueue<Integer, Integer> h = new HeapPriorityQueue<>();
		for(int x : a) {
			h.insert(x, x);
		}
		int size = h.size();
		for(int x = 0; x < size; x++) {
			h.removeMin();
		}
	}
}
