package ad.praktikum1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ad.praktikum1.lists.DoubleLinkedList;
import ad.praktikum1.lists.LinkedListNode;

public class DoubleLinkedListTest {

	@Test
	public void testDoubleLinkedList() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.add("1", 0);
		list.add("3", list.size());
		list.add("2", 1);
		list.add("4", list.size());
		list.add("0", 0); // (null) 0 1 2 3 4 (null)

        assertEquals(5, list.size());
        assertEquals("0 1 2 3 4 ", list.toString());
        
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
        
        assertEquals("2", list.get(2));

        list.delete(2);  // (null) 0 1 3 4 (null) 
        assertEquals(4, list.size());
        assertEquals("0 1 3 4 ", list.toString());

        list.delete(0);  // (null) 1 3 4 (null) 
        assertEquals(3, list.size());
        assertEquals("1 3 4 ", list.toString());

        list.delete(list.size() - 1);  // (null) 1 3 (null) 
        assertEquals(2, list.size());
		assertEquals("1 3 ", list.toString());

        list.empty();
        assertEquals(0, list.size());
		assertNull(list.getHead());
		assertNull(list.getTail());
		
		// test join and extract
		DoubleLinkedList<String> list0 = new DoubleLinkedList<String>();
		list0.add("1", 0);
		list0.add("3", list0.size());
		list0.add("2", 1);
		list0.add("4", list0.size());
		list0.add("5", list0.size()); // (null) 1 2 3 4 5 (null)
        
		DoubleLinkedList<String> list1 = new DoubleLinkedList<String>();
		list1.add("5", list1.size()); 
		list1.add("6", list1.size());
		list1.add("7", list1.size());
		list1.add("8", list1.size());
		list1.add("9", list1.size()); // (null) 5 6 7 8 9 (null)
		
		DoubleLinkedList<String> list2 = new DoubleLinkedList<String>();
		list2.add("11", list2.size());
		list2.add("12", list2.size());
		list2.add("13", list2.size());
		list2.add("14", list2.size());
		list2.add("15", list2.size()); // (null) 11 12 13 14 15 (null)
		
		list0.join(list1);
		assertEquals("1 2 3 4 5 5 6 7 8 9 ", list0.toString());
		list0.join(list2);
        assertEquals("1 2 3 4 5 5 6 7 8 9 11 12 13 14 15 ", list0.toString());
		
        assertEquals("2 3 4 ", list0.extract(1, 4).toString());
        

	}

}
