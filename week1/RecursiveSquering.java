package Week1_recursion;

public class RecursiveSquering {
	public static void main(String[] args) {
		System.out.println(slowerRecursive(2, 6));
		System.out.println(fasterRecursion(2, 6));
	}
	private static int slowerRecursive(int x, int p) {
		if(p <= 1) return x;
		else return x * slowerRecursive(x, p-1);
	}
	private static int fasterRecursion(int x, int p) {
		if(p == 1) return x;
		else if (p % 2 == 0) {
			int z = fasterRecursion(x, p/2);
			return z * z;
		} else {
			int z = fasterRecursion(x, (p-1)/2);
			return x * z * z;
		}
	}
}
