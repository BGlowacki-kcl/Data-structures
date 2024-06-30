package Week2_linkedLists;

public class GeomProgression extends Progression{
	long base;
	public GeomProgression(long base) {
		this.base = base;
		first = 1;
		cur = first;
	}
	public GeomProgression(){
		this(1);
	}
	protected long nextValue() {
		cur *= base;
		return cur;
	}
}
