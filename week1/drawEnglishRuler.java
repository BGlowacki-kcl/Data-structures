package Week1_recursion;

public class drawEnglishRuler {
	public static void main(String[] args) {
		drawRuler(4, 5);
	}
	private static void drawRuler(int numbers, int between) {
		drawOneTick(between, 0);
		for(int i = 1; i <= numbers; i++) {
			drawTicks(between - 1); // ticks
			drawOneTick(between, i); // with label
		}
	}
	private static void drawTicks(int n) {
		if(n >= 1) {
			drawTicks(n-1);
			drawOneTick(n);
			drawTicks(n-1);
		}
	}
	private static void drawOneTick(int n) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += "-";
		}
		System.out.println(s);
	}
	private static void drawOneTick(int n, int label) {
		String s = "";
		for(int i = 0; i < n; i++) {
			s += "-";
		}
		System.out.println(s + label);
	}
}