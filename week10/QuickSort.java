package Week10_Sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuickSort {
	public static LinkedList<Integer> quick(LinkedList<Integer> S){
		if(S.size() <= 1) {
			return S;
		} else {
			ArrayList<LinkedList<Integer>> l = new ArrayList<>(); 
			l = partition(S, S.getLast());
			LinkedList<Integer> L = l.get(0);
			LinkedList<Integer> E = l.get(1);
			LinkedList<Integer> G = l.get(2);
			LinkedList<Integer> ans = mergeLists(quick(L), E, quick(G));
			return ans;
		}
	}
	@SafeVarargs
	private static <T> LinkedList<T> mergeLists(LinkedList<T>... lists) {
        LinkedList<T> mergedList = new LinkedList<>();
        for (LinkedList<T> list : lists) {
            mergedList.addAll(list);
        }
        return mergedList;
    }
	private static ArrayList<LinkedList<Integer>> partition(LinkedList<Integer> S, int pivot){
		Iterator<Integer> i = S.iterator();
		LinkedList<Integer> L = new LinkedList<>();
		LinkedList<Integer> E = new LinkedList<>();
		LinkedList<Integer> G = new LinkedList<>();
		
		while(i.hasNext()) {
			int temp = i.next();
			if(temp < pivot) {
				L.add(temp);
			} else if(temp == pivot) {
				E.add(temp);
			} else {
				G.add(temp);
			}
		}
		ArrayList<LinkedList<Integer>> ans = new ArrayList<>();
		ans.add(L);
		ans.add(E);
		ans.add(G);
		return ans;
	}
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		for(int i = 243; i < 150000673; i += 237) {
			l.add(i % 769);
		}
		long start = System.currentTimeMillis();
		System.out.println(quick(l));
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("Time: " + time);
		// 540ms
	}
}
