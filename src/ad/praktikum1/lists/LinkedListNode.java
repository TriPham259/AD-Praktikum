package ad.praktikum1.lists;

/**
 * 
 * @author Huy Tran PC
 */
public class LinkedListNode<T> {
	private T data; 
	private LinkedListNode<T> previous;
	private LinkedListNode<T> next;
	
	/**
	 * create a LinkedListNode with a given object and node references 
	 * @param data The data stored in new node
	 * @param previous The previous node in the list 
	 * @param next The next node in the list 
	 */
	public LinkedListNode(T data, LinkedListNode<T> previous, LinkedListNode<T> next) {
		this.data = data; 
		this.previous = previous; 
		this.next = next; 
	}
	
	/**
	 * create a LinkedListNode with only a given object 
	 * @param data The data stored in the new node 
	 */
	public LinkedListNode(T data) {
		this(data, null, null);
	}

	/**
	 * get the data stored in this node 
	 * @return The data in this node 
	 */
	public T getData() {
		return data;
	}

	/**
	 * get the previous node 
	 * @return The previous node 
	 */
	public LinkedListNode<T> getPrevious() {
		return previous;
	}

	/**
	 * set the previous node 
	 * @param The new previous node
	 */
	public void setPrevious(LinkedListNode<T> previous) {
		this.previous = previous;
	}

	/**
	 * get the next node 
	 * @return The next node
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * set the next node 
	 * @param The new next node 
	 */
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
