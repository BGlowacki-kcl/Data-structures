package Week2_linkedLists;

public class Progression {
	long first;
	long cur;
	
	public Progression() {
		cur = first = 0;
	}
	protected long firstValue() {
		cur = first;
		return cur;
	}
	protected long nextValue() {
		return ++cur;
	}
	void printProgression(int n) {
		System.out.print(first+" ");
		for(int i = 0; i < n; i++) {
			System.out.print(nextValue() + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Progression prog = new Progression();
		prog.printProgression(10);
		
		Progression arth = new ArithProgression(5);
		arth.printProgression(10);
		
		Progression geo = new GeomProgression(3);
		geo.printProgression(10);
		
		Progression fib = new FibProgression(4);
		fib.printProgression(10);
	}
}
