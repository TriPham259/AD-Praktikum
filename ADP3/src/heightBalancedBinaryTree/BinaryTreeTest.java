package heightBalancedBinaryTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static heightBalancedBinaryTree.BinaryTree.*;

/**
 * Test for isHeightBalanced() of BinaryTree.
 * @author Huy Tran PC
 */

public class BinaryTreeTest {
	
	private BinaryTree<?> heightBalancedTree;
	private BinaryTree<?> emptyTree;
	
	@Before
	public void init() {
		emptyTree = new BinaryTree<Object>();
		
		heightBalancedTree = new BinaryTree<Object>();
		heightBalancedTree.setRoot(new Node<String>("0"));
		
		heightBalancedTree.getRoot().setLeft(new Node<Integer>(1));
		heightBalancedTree.getRoot().getLeft().setLeft(new Node<Double>(2.0));
		heightBalancedTree.getRoot().getLeft().getLeft().setLeft(new Node<Integer>(3));
		heightBalancedTree.getRoot().getLeft().setRight(new Node<String>("4"));
		
		heightBalancedTree.getRoot().setRight(new Node<Double>(1.1));
		heightBalancedTree.getRoot().getRight().setLeft(new Node<Integer>(2));
		heightBalancedTree.getRoot().getRight().getLeft().setLeft(new Node<String>("3"));
		heightBalancedTree.getRoot().getRight().setRight(new Node<Integer>(4));
	}
	
	@Test
	public void isHeightBalancedTest() {
		assertTrue("Tree should be height-balanced.", isHeightBalanced(emptyTree.getRoot()));
		assertTrue("Tree should be height-balanced.", isHeightBalanced(heightBalancedTree.getRoot()));
		heightBalancedTree.getRoot().getRight().getRight().setRight(new Node<Integer>(5));
		assertTrue("Tree should be height-balanced.", isHeightBalanced(heightBalancedTree.getRoot()));
	}
	
	@Test
	public void isHeightBalancedNegTest() {
		heightBalancedTree.getRoot().getLeft().getLeft().getLeft().setLeft(new Node<Integer>(5));
		assertFalse("Tree should not be height-balanced.", isHeightBalanced(heightBalancedTree.getRoot()));

	}

}
