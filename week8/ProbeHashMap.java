package Week8_Maps_HashTables;

import java.util.ArrayList;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {
	private MapEntry<K,V>[] table;
	private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);
	
	public ProbeHashMap() { super(); }
	public ProbeHashMap(int cap) { super(cap); }
	public ProbeHashMap(int cap, int n) { super(cap, n); } 
	
	@SuppressWarnings("unchecked")
	protected void createTable() {
		table = (MapEntry<K,V>[]) new MapEntry[capacity];
	}
	private boolean isAvailable(int j) {
		return (table[j] == null || table[j] == DEFUNCT);
	}
	private int findSlot(int h, K k) {
		int avail = -1;
		int j = h;
		do {
			if(isAvailable(j)) { // available
				if(avail == -1) avail = j; // set indx of the first available slot
				if(table[j] == null) break; // if empty then nothing has never been here, so we can just insert a new entry there. If it is DEFUNCT it means there was something, so our key can be already located somewhere further, so we need to check it 
			} else if (table[j].getKey().equals(k)) // If found the needed key
				return j; // return index of this key
			j = (j+1) % capacity; // Go to the next slot
		} while (j != h); // while didn't make the whole cycle
		return -(avail + 1); // 0 if didn't find or negative index
	}
	protected V bucketGet(int h, K k) {
		int j = findSlot(h,k);
		if(j < 0) return null;
		return table[j].getValue();
	}
	protected V bucketPut(int h, K k, V v) {
		int j = findSlot(h, k);
		if(j >= 0)
			return table[j].setValue(v);
		table[-(j+1)] = new MapEntry<>(k,v);
		n++;
		return null;
	}
	protected V bucketRemove(int h, K k) {
		int j = findSlot(h, k);
		if(j < 0) return null;
		V answer = table[j].getValue();
		table[j] = DEFUNCT;
		n--;
		return answer;
	}
	public Iterable<Entry<K,V>> entrySet() {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		for(int h = 0; h < capacity; h++)
			if(!isAvailable(h)) buffer.add(table[h]);
		return buffer;
		
	}
	public static void main(String[] args) {
		ProbeHashMap<Integer, Integer> m = new ProbeHashMap<>();
		m.put(5, 5);
		m.put(2, 2);
		m.put(10,10);
		m.put(1, 1);
		m.put(15, 15);
		m.put(3, 3);
		m.put(3, 5);
		System.out.println(m.get(3));
		System.out.println(m.remove(1));
		System.out.println(m.remove(1));
		System.out.println(m.remove(20));
	}
}
