package Week1_recursion;

public class Fibbonacci {
	public static void main(String[] args) {
		System.out.println(recursiveFib(10));
		System.out.println(fasterRecursiveFib(10)[0]);
		System.out.println(iterativeFib(10));
	}
	private static int recursiveFib(int i) {
		if(i <= 1) return i;
		else return recursiveFib(i-1) + recursiveFib(i-2);
	}
	private static int[] fasterRecursiveFib(int i) {
		if(i <= 1) return new int[] {i, 0};
		else {
			int[] F = fasterRecursiveFib(i-1);
			return new int[] {F[0] + F[1], F[0]};
		}
	}
	private static int iterativeFib(int i) {
		if(i <= 1) return i;
		else {
			int previous = 0;
			int current = 1;
			int next;
			for(int x = 1; x < i; x++) {
				next = previous + current;
				previous = current;
				current = next;
			}
			return current;
		}
	}
}
