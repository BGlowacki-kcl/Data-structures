package Week5_Lists;

import java.security.InvalidParameterException;

import javax.swing.text.BadLocationException;

public interface PositionList<E> { //extends Iterable<E>{
	public int size();
	public boolean isEmpty();
	public Position<E> first() throws Exception;
	public Position<E> last() throws Exception;
	public Position<E> next(Position<E> p) throws InvalidParameterException, BadLocationException;
	public Position<E> prev(Position<E> p) throws InvalidParameterException, BadLocationException;
	public void addFirst(E e);
	public void addLast(E e);
	public void addNext(Position<E> p, E e) throws Exception;
	public void addPrev(Position<E> p, E e) throws Exception;
	public E remove(Position<E> p) throws Exception;
	public E set(Position<E> p, E e) throws Exception;
}
