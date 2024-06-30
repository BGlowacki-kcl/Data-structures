package Week10_Sorting;

import java.util.LinkedList;

public class MergeSort {
	public static LinkedList<Integer> sort(LinkedList<Integer> S) {
		if(S.size() <= 1) {
			return S;
		} else {
			LinkedList<Integer> S1 = new LinkedList<>(S.subList(0, S.size()/2));
			LinkedList<Integer> S2 = new LinkedList<>(S.subList(S.size()/2, S.size()));
			
			return merge(sort(S1), sort(S2));
		}
	}
	private static LinkedList<Integer> merge(LinkedList<Integer> S1, LinkedList<Integer> S2){
		LinkedList<Integer> ans = new LinkedList<>();
		while(!S1.isEmpty() && !S2.isEmpty()) {
			if(S1.getFirst() < S2.getFirst()) {
				ans.add(S1.removeFirst());
			} else {
				ans.add(S2.removeFirst());
			}
		}
		while(!S1.isEmpty()) {
			ans.add(S1.removeFirst());
		}
		while(!S2.isEmpty()) {
			ans.add(S2.removeFirst());
		}
		return ans;	
	}
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		for(int i = 243; i < 150000673; i += 237) {
			l.add(i % 769);
		}
		long start = System.currentTimeMillis();
		System.out.println(sort(l));
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("Time: " + time);
		// 807ms
	}
	
}
