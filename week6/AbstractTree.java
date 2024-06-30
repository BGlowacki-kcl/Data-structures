package Week6_Trees;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
	public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
	public boolean isRoot(Position<E> p) { return p == root(); }
	public boolean isEmpty(Position<E> p) { return size() == 0; }
}
