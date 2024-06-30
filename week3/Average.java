package Week3_AnalysisOfAlg;

public class Average {
	
	public static int[] linearAverage(int[] X) {
		int n = X.length;
		int[] A = new int[n];
		int sum = 0;
		for(int x = 0; x < n; x++) {
			sum += X[x];
			A[x] = sum / (x+1);
		}
		return A;
	}
	public static int[] quadraticAverage(int[] X) {
		int n = X.length;
		int[] A = new int[n];
		int sum;
		for(int x = 0; x < n; x++) {
			sum = 0;
			for(int y = 0; y <= x; y++) {
				sum += X[y];
			}
			A[x] = sum / (x+1);
		}
		return A;
	}

	public static void main(String[] args) {
		int[] X = new int[] {0, 5, 10, 26, 1, 0, 46, -1, 2, 4, 6, 8};
		int[] B = quadraticAverage(X);
		for(int i = 0; i < X.length; i++) {
			System.out.print(B[i]+" ");
		}
		System.out.println();
		int[] C = linearAverage(X);
		for(int i = 0; i < X.length; i++) {
			System.out.print(C[i]+" ");
		}
	}
}
