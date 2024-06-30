package Week2_linkedLists;

public class ArithProgression extends Progression{
	long inc;
	public ArithProgression(long inc){
		this.inc = inc;
		cur = first;
	}
	public ArithProgression() {
		this(1);
	}
	protected long nextValue() {
		cur += inc;
		return cur;
	}
}
