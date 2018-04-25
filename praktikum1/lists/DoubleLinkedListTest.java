package lists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

//	public static void main(String[] args) {
	@Test
	public void testDoubleLinkedList()
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.add("1", 0);
        list.add("3", 1);
        list.add("2", 1);
        list.add("4", 3);
        list.add("0", 0); // (null) 0 1 2 3 4 (null) 

        assertEquals(5, list.size());
        assertEquals(new int[] {0, 1, 2, 3, 4}, list.toArray());

        list.delete(2);  // (null) 0 1 3 4 (null) 
        assertEquals(4, list.size());
        assertEquals(new int[] {0, 1, 3, 4}, list.toArray());

        list.delete(0);  // (null) 1 3 4 (null) 
        assertEquals(3, list.size());
        assertEquals(new int[] {1, 3, 4}, list.toArray());

        list.delete(list.size());  // (null) 1 3 (null) 
        assertEquals(2, list.size());
		assertEquals(new int[] {1, 3}, list.toArray());

        list.empty();
        assertEquals(0, list.size());
		assertNull(list.getHead());
		assertNull(list.getTail());

        LinkedListNode<String> node = list.getHead();
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
		
//		MyArrayList<String> list = new MyArrayList<>();
//		list.add("2", 0);
//		list.add("4", 1);
//		list.add("3", 1);
//		list.add("1", 0);
//		list.add("5", 4);
//		list.add("0", 0);
//		list.delete(3);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}

		// Testing DoubleLinkedList's performance
//		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
//		list.add(6, list.size());
//		list.add(5, list.size());
//		list.add(4, list.size());
//		list.add(3, list.size());
//		list.add(2, list.size());
//		list.add(1, list.size());
//		list.add(0, list.size());
//		list.delete(list.size() - 1);
//		list.delete(list.size() - 1);
//		list.delete(list.size() - 1);
//		list.delete(list.size() - 1);
//		list.delete(list.size() - 1);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
        


	}

}
