package Week10_Sorting;

import java.util.ArrayList;

public class MergeSortArray {
	public static ArrayList<Integer> sort(ArrayList<Integer> S) {
		if(S.size() <= 1) {
			return S;
		} else {
			ArrayList<Integer> S1 = new ArrayList<>(S.subList(0, S.size()/2));
			ArrayList<Integer> S2 = new ArrayList<>(S.subList(S.size()/2, S.size()));
			
			return merge(sort(S1), sort(S2));
		}
	}
	private static ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B){
		int i = 0, j = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while(i < A.size() && j < B.size()) {
			if(A.get(i) < B.get(j)) {
				ans.add(A.get(i));
				i++;
			} else {
				ans.add(B.get(j));
				j++;
			}
		}
		while(i < A.size()) {
			ans.add(A.get(i));
			i++;
		}
		while(j < B.size()) {
			ans.add(B.get(j));
			j++;
		}
		return ans;
	}
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		for(int i = 243; i < 150000673; i += 237) {
			l.add(i % 769);
		}
		long start = System.currentTimeMillis();
		System.out.println(sort(l));
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("Time: " + time);
		// 521ms
	}
}
