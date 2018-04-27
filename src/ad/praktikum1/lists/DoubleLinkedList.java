package ad.praktikum1.lists;

/**
 * 
 * @author Huy Tran PC
 */
public class DoubleLinkedList<T> implements ListInterface<T> {
	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;
	private int size;

	public DoubleLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(T data, int index) throws IllegalArgumentException {
		if (index < 0 || index > size || data == null) {
			throw new IllegalArgumentException();
		}
		// list is empty, index must be 0
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			// add before head
			if (index == 0) {
				newNode.setNext(head);
				head.setPrevious(newNode);
				head = newNode;
			// add after tail
			} else if (index == size) {
				newNode.setPrevious(tail);
				tail.setNext(newNode);
				tail = newNode;
			// general case
			} else {
				LinkedListNode<T> nodeRef = head;
				for (int i = 0; i < index; i++) {
					nodeRef = nodeRef.getNext();
				}
				newNode.setPrevious(nodeRef.getPrevious());
				newNode.setNext(nodeRef);
				nodeRef.getPrevious().setNext(newNode);
				nodeRef.setPrevious(newNode);
			}
		}
		size++;
	}

	@Override
	public T delete(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		// list is empty, nothing to delete
		if (size == 0) {
			return null;
		}
		T data;
		// list has only 1 element to delete
		if (size == 1) {
			data = head.getData();
			head = null;
			tail = null;
		} else {
			// delete before front
			if (index == 0) {
				data = head.getData();
				head.getNext().setPrevious(null);
				head = head.getNext();
			// delete after tail
			} else if (index == size - 1) {
				data = tail.getData();
				tail.getPrevious().setNext(null);
				tail = tail.getPrevious();
			// general case
			} else {
				LinkedListNode<T> nodeRef = head;
				for (int i = 0; i < index; i++) {
					nodeRef = nodeRef.getNext();
				}
				nodeRef.getPrevious().setNext(nodeRef.getNext());
				nodeRef.getNext().setPrevious(nodeRef.getPrevious());
				data = nodeRef.getData();
			}
		}
		size--;
		return data;
	}

	@Override
	public T get(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			return head.getData();
		}
		if (index == size - 1) {
			return tail.getData();
		}
		LinkedListNode<T> nodeRef = head;
		for (int i = 0; i < index; i++) {
			nodeRef = nodeRef.getNext();
		}
		return nodeRef.getData();
	}

	@Override
	public void empty() {
		head = null;
		tail = null;
		size = 0;
	}

	public ListInterface<T> join(DoubleLinkedList<T> otherList) throws IllegalArgumentException {
		tail.setNext(otherList.getHead());
		tail = otherList.getTail();
		size += otherList.size;
		return this; 
	}

	@Override
	public ListInterface<T> extract(int start, int end) throws IllegalArgumentException {
		if (start < 0 || end > size || end < start) {
			throw new IllegalArgumentException();
		}
		
		DoubleLinkedList<T> newList = new DoubleLinkedList<>();
		
		LinkedListNode<T> nodeRef = head;
		for (int i = 0; i < start; i++) {
			nodeRef = nodeRef.getNext();
		}
		
		for (int i = start; i < end; i++) {
			newList.add(nodeRef.getData(), newList.size());
			nodeRef = nodeRef.getNext();
		}
		
		return newList;
	}

	public LinkedListNode<T> getTail() {
		return tail;
	}

	public LinkedListNode<T> getHead() {
		return head;
	}
	
	public String toString() {
		String str = "";
		LinkedListNode<String> node = (LinkedListNode<String>) head;
		while (node != null) {
			str += node.getData() + " ";
			node = node.getNext();
		}
		return str;
	}

}