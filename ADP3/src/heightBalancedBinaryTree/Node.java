package heightBalancedBinaryTree;

/**
 * A generic node in a generic binary tree. 
 * @author Huy Tran PC
 */
public class Node<T> {
	private T data; 
	private Node<?> left; 
	private Node<?> right; 
	
	/**
	 * Constructor for a node.
	 * @param data
	 */
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Node<?> getLeft() {
		return left;
	}

	public Node<?> getRight() {
		return right;
	}

	public void setLeft(Node<?> left) {
		this.left = left;
	}

	public void setRight(Node<?> right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Node: " + data;
	}
	
}

