package Week10_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortArray {
	public static void quick(List<Integer> array, int low, int high) {
		if(low < high) {
			int pivotIndex = partition(array, low, high);
			quick(array, low, pivotIndex - 1);
			quick(array, pivotIndex + 1, high);
		}
	}
	private static int partition(List<Integer> array, int low, int high) {
		int pivot = array.get(high);
		int i = low - 1;
		for(int j = low; j < high; j++) 
			if(array.get(j) < pivot)
				Collections.swap(array, ++i, j);
		Collections.swap(array, i + 1, high);
		return i+1;
	}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		for(int i = 243; i < 150000673; i += 237) {
			l.add(i % 769);
		}
		long start = System.currentTimeMillis();
		quick(l, 0, l.size()-1);
		System.out.println(l);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("Time: " + time);
		// 1016ms
	}
}
