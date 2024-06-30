package Week5_Lists;

public interface IndexList<E> {

	int size();
	boolean isEmpty();
	E get(int i) throws IndexOutOfBoundsException;
	E set(int i, E e) throws IndexOutOfBoundsException;
	void add(int i, E e) throws IndexOutOfBoundsException;
	E remove(int i) throws IndexOutOfBoundsException;
	
}
