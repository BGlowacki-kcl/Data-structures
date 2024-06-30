package Week5_Lists;

public class ArrayList<E> implements IndexList<E>{

	private E[] A;
	private int capacity = 16;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		A = (E[]) new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public E get(int i) {
		checkIndex(i);
		return A[i];
	}
	public E set(int i, E e) {
		checkIndex(i);
		E previousElement = null;
		if(A[i] != null) {
			previousElement = A[i];
		}
		A[i] = e;
		return previousElement;
	}
	public void add(int i, E e) {
		checkIndex(i);
		if(size+1 == capacity) {
			capacity *= 2;
			@SuppressWarnings("unchecked")
			E newArray[] = (E[]) new Object[capacity];
			for(int x = 0; x < size; x++) {
				newArray[x] = A[x];
			}
			A = newArray;
		}
		for(int x = size - 1; x >= i; x++) {
			A[i+1] = A[i];
		}
		A[i] = e;
		size++;
	}
	public E remove(int i) {
		checkIndex(i);
		E previousElement = A[i];
		for(int x = i; x < size-1; x++) {
			A[x] = A[x+1];
		}
		A[--size] = null;
		return previousElement;
	}
	protected void checkIndex(int i) throws IndexOutOfBoundsException{
		if(i<0 || i >size) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
	}
	public static void main(String[] args) {
		IndexList<Integer> list = new ArrayList<>();
		list.add(0, 10);
		list.add(0, 20);
		System.out.println(list.get(1));
		System.out.println(list.set(2, 5));
		System.out.println(list.remove(0));
		System.out.println(list.size());
		System.out.println(list.remove(0));
		System.out.println(list.isEmpty());
		for(int x = 0; x < 100; x++) {
			list.add(x, x);
		}
		System.out.println(list.get(78));
	}
	
}
