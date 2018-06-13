package heightBalancedBinaryTree;

/**
 * A generic binary tree.
 * @author Huy Tran PC
 */
public class BinaryTree<T> {
	private Node<?> root;

	/**
	 * Check if a binary tree is height-balanced: the difference 
	 * between the height of two sub-trees of each node is not 
	 * great than 1.
	 * @param root Root of the tree. 
	 * @return True if the tree is height-balanced. 
	 */	
	// Post-order solution, O(n)
	public static boolean isHeightBalanced(Node<?> root) {
		return checkHeightBalanced(root) != -1;
	}
	
	/**
	 * Check if left subtree is height-balanced. If yes, give this height to root, otherwise return -1. 
	 * Check if right subtree is height-balancd. If yes, give this height to root, otherwise return -1.
	 * Check if tree is height-balanced at the root. If yes, return the height of root, otherwise return -1.
	 * Base case: root is null, then tree is height-balanced. Return 0 (height of a null tree).	
	 * @param root Root of the tree. 
	 * @return -1 if the tree is not height-balanced. 
	 */
	private static int checkHeightBalanced(Node<?> root) {
		if (root == null) {
			return 0; 
		}
		
		int leftHeight = checkHeightBalanced(root.getLeft()); 
		if (leftHeight == -1) {
			return -1; 
		}
		
		int rightHeight = checkHeightBalanced(root.getRight()); 
		if (rightHeight == -1) {
			return -1; 
		}
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
//	// Top-down solution, O(n^2)
//	public static boolean isHeightBalanced(Node<?> root) {
//		// stop and return true when a node has no sub-tree.
//		if (root == null) {
//			return true;
//		}
//		
//		int leftTreeHeight = height(root.getLeft());
//		int rightTreeHeight = height(root.getRight());
//		
//		return isHeightBalanced(root.getLeft()) && isHeightBalanced(root.getRight()) 
//				&& Math.abs(leftTreeHeight - rightTreeHeight) <= 1;
//	}
	
	/**
	 * Calculate the height of a binary tree: number of nodes on 
	 * the longest path (from root node to the furthest leaf node). 
	 * @param root Root of the tree. 
	 * @return Height of the tree. 
	 */
	public static int height(Node<?> root) {
		if (root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	} 
	
	public Node<?> getRoot() {
		return root;
	}

	public void setRoot(Node<?> root) {
		this.root = root;
	}
	
}
