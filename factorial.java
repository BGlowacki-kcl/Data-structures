package Week1_recursion;

public class factorial {
	public static void main(String[] args) {
		System.out.println(recursiveFactorial(6));
		System.out.println(iterativeFactorial(6));
	}
	private static int recursiveFactorial(int n) {
		if(n == 0) return 1;
		else return n * recursiveFactorial(n-1); 
	}
	private static int iterativeFactorial(int n) {
		int result = 1;
		while(n > 0) {
			result *= n;
			n--;
		}
		return result;
	}
}
