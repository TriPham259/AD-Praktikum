package lists;

import java.util.Arrays;

import sun.awt.datatransfer.DataTransferer;

public class MyArrayList<T> implements ListInterface<T> {
	private T data[];
	private int num; // current size
	private int capacity; // maximum capacity
	private static final int DEFAULT_CAPACITY = 100;

	public MyArrayList(int capacity) {
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
		num = 0;
	}

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public int size() {
		return num;
	}

	@Override
	public void add(T elem, int index) throws IllegalArgumentException {
		if (index < 0 || index >= num + 1) {
			throw new IllegalArgumentException();
		}
		if (num == capacity) {
			// copy old data to new data
			T[] datanew = Arrays.copyOf((T[]) data, capacity * 2);
			data = datanew;
		}
		
		int tmp = num;
		while (tmp > index) {
			data[tmp] = data[tmp - 1];
			tmp--;
		}
		data[index] = elem;
		num++;
	}

	@Override
	public T delete(int index) throws IllegalArgumentException {
		if (index < 0 || index >= num) {
			throw new IllegalArgumentException();
		} else {
			T elem = data[index];
			data[index] = null;
			int tmp = index;
			while (tmp < num) {
				data[tmp] = data[tmp + 1];
				data[tmp + 1] = null;
				tmp++;
			}
			num--;
			return elem;
		}
	}

	@Override
	public T get(int index) throws IllegalArgumentException {
		if (index < 0 || index >= num) {
			throw new IllegalArgumentException();
		} else {
			return data[index];
		}
	}

	@Override
	public void empty() {
		for (int i = 0; i < num; i++) {
			data[i] = null;
		}
		num = 0;
	}

	@Override
	public ListInterface<T> concat(ListInterface<T> list) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListInterface<T> extract(int start, int end) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
