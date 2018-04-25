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
		if (size == 0) {
			LinkedListNode<T> newNode = new LinkedListNode<T>(data);
			head = newNode;
			tail = newNode;
			size++;
		} else {
			// add before head
			if (index == 0) {
				addToFront(data);
				// add after tail
			} else if (index == size) {
				addToBack(data);
				// general case
			} else {
				LinkedListNode<T> nodeRef = head;
				for (int i = 0; i < index; i++) {
					nodeRef = nodeRef.getNext();
				}
				LinkedListNode<T> newNode = new LinkedListNode<T>(data, nodeRef.getPrevious(), nodeRef);
				nodeRef.getPrevious().setNext(newNode);
				nodeRef.setPrevious(newNode);
				size++;
			}
		}
	}

	public void addToFront(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (size != 0) {
			LinkedListNode<T> a = new LinkedListNode<T>(data, null, head);
			head.setPrevious(a);
			head = a;
		} else {
			LinkedListNode<T> a = new LinkedListNode<T>(data, null, null);
			head = a;
			tail = a;
		}
		size++;
	}

	public void addToBack(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (size != 0) {
			LinkedListNode<T> newLinkedNode = new LinkedListNode<T>(data, tail, null);
			tail.setNext(newLinkedNode);
			tail = newLinkedNode;
		} else {
			LinkedListNode<T> newLinkedNode = new LinkedListNode<T>(data, null, null);
			tail = newLinkedNode;
			head = newLinkedNode;
		}
		size++;
	}

	@Override
	public T delete(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        T data = null;
        if (index < size - 1 && index > 0) {
            LinkedListNode<T> nodeRef = head;
            for (int i = 0; i < index; i++) {
            	nodeRef = nodeRef.getNext();
            }
            nodeRef.getPrevious().setNext(nodeRef.getNext());
            nodeRef.getNext().setPrevious(nodeRef.getPrevious());
            data = nodeRef.getData();
            size--;
        } else if (index == 0) {
            data = deleteFromFront();
        } else if (index == size - 1) {
            data = deleteFromBack();
        }
        return data;
	}

	public T deleteFromFront() {
		if (size == 0) {
			return null;
		}
		T data;
		if (size == 1) {
			data = head.getData();
			head = null;
			tail = null;
		} else {
			data = head.getData();
			head.getNext().setPrevious(null);
			head = head.getNext();
		}
		size--;
		return data;
	}

	public T deleteFromBack() {
		if (size == 0) {
			return null;
		}
		T object;
		if (size == 1) {
			object = head.getData();
			head = null;
			tail = null;
		} else {
			object = tail.getData();
			tail.getPrevious().setNext(null);
			tail = tail.getPrevious();
		}
		size--;
		return object;
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
