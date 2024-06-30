package Week4_StacksQueues;

public class StackTester {

	public static int[] reverseArray(int[] a) {
		int n = a.length;
		Stack<Integer> s = new ArrayStack<>(n);
		for(int i = 0; i < n; i++) { s.push(a[i]); }
		for(int i = 0; i < n; i++) { a[i] = s.pop(); }
		return a;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		array = reverseArray(array);
		for(int x : array) {
			System.out.print(x + " ");
		}
	}
}
