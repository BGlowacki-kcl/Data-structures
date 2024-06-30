package Week7_PriorityQueue_Heap;

import java.util.ArrayList;
import java.util.Iterator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
	ArrayList<PQEntry<K,V>> list = new ArrayList<>();
	public int size() { return list.size(); }
	public Entry<K,V> insert(K k, V v) {
		checkKey(k);
		Entry<K,V> entry = new PQEntry<K,V>(k,v);
		list.add((PQEntry<K, V>) entry);
		return entry;
	}
	public Entry<K,V> findMin(){
		if(isEmpty())
			return null;
		Entry<K,V> min = list.get(0);
		for(Entry<K,V> ent : list) {
			if(compare(min, ent) > 0)
				min = ent;
		}
		return min;
	}
	@Override
	public Entry<K, V> min() {
		Entry<K,V> ans = findMin();
		System.out.println(ans.getValue());
		return ans;
	}
	@Override
	public Entry<K, V> removeMin() {
		Entry<K,V> min = findMin();
		Iterator<PQEntry<K, V>> iterator = list.iterator();
		while(iterator.hasNext()) {
			Entry<K,V> cur = iterator.next();
			if(compare(cur, min) == 0) {
				Entry<K, V> ans = cur;
				iterator.remove();
				System.out.println(ans.getValue());
				return ans;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		UnsortedPriorityQueue<Integer, String> q = new UnsortedPriorityQueue<>();
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
	}
	
}
