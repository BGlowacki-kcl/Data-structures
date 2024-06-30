package Week1_recursion;

public class ArrayReverse {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arrRecursivelyReversed = recursive(arr.clone(), 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arrRecursivelyReversed[i] + " ");
		}
		System.out.println();
		int[] arrIterativelyReversed = iterative(arr.clone());
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arrIterativelyReversed[i] + " ");
		}
	}
	private static int[] recursive(int[] array, int x, int y) {
		if(x >= y) return array;
		else {
			int temp = array[x];
			array[x] = array[y];
			array[y] = temp;
			return recursive(array, x+1, y-1);
		}
	}
	private static int[] iterative(int[] array) {
		int x = 0;
		int y = array.length - 1;
		while(x <= y) {
			int temp = array[x];
			array[x] = array[y];
			array[y] = temp;
			x++;
			y--;
		}
		return array;
	}
	
}
