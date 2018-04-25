package lists;

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

	public LinkedListNode<T> getTail() {
		return tail;
	}

	public LinkedListNode<T> getHead() {
		return head;
	}

}