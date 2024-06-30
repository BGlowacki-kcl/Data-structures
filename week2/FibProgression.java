package Week2_linkedLists;

public class FibProgression extends Progression{
	long prev;
	public FibProgression(long second) {
		prev = second - first;
	}
	public FibProgression() {
		this(1);
	}
	protected long nextValue() {
		long temp = cur;
		cur = cur + prev;
		prev = temp;
		return cur;
	}
}
