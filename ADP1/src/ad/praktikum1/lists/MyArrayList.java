package ad.praktikum1.lists;

import java.util.Arrays;


public class MyArrayList<T> implements ListInterface<T> {
	private T data[];
	private int size; // current size
	public int capacity; // maximum capacity
	private static final int DEFAULT_CAPACITY = 200;

	public MyArrayList(int capacity) {
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(T elem, int index) throws IllegalArgumentException {
		if (index < 0 || index >= size + 1) {
			throw new IllegalArgumentException();
		}
		if (size == capacity) {
			// copy old data to new data
			capacity *= 2;
			T[] datanew = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				datanew[i] = data[i];
			}
			
			data = datanew;
		}
		
		int tmp = size;
		while (tmp > index) {
			data[tmp] = data[tmp - 1];
			tmp--;
		}
		data[index] = elem;
		size++;
	}

	@Override
	public T delete(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		} else {
			T elem = data[index];
			data[index] = null;
			int tmp = index;
			while (tmp < size) {
				data[tmp] = data[tmp + 1];
				data[tmp + 1] = null;
				tmp++;
			}
			size--;
			return elem;
		}
	}

	@Override
	public T get(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		} else {
			return data[index];
		}
	}

	@Override
	public void empty() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	public MyArrayList<T> join(MyArrayList<T> otherList) {
		int newSize = size + otherList.size();
		if (newSize > capacity) {
			capacity *= 2;
			T[] datanew = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				datanew[i] = data[i];
			}
			data = datanew;
		} 
		
		for (int i = size, j = 0; i < newSize; i++) {
			data[i] = (T) otherList.getData()[j];
			j++;
		}
		
		size = newSize;
		return this;
	}

	public T[] getData() {
		return data;
	}

	@Override
	public ListInterface<T> extract(int start, int end) throws IllegalArgumentException {
		if (start < 0 || end > size || end < start) {
			throw new IllegalArgumentException();
		}
		
		MyArrayList<T> newList = new MyArrayList<>(size);
		
		for (int i = start; i < end; i++) {
			newList.add(data[i], newList.size());
		}
		
		return newList;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += data[i] + " ";
		}
		return str;
	}


}
