package ad.praktikum1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ad.praktikum1.lists.DoubleLinkedList;
import ad.praktikum1.lists.MyArrayList;

class MyArrayListTest {

	@Test
	void testMyArrayList() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.add("1", 0);
		list.add("3", list.size());
		list.add("2", 1);
		list.add("4", list.size());
		list.add("0", 0); // 0 1 2 3 4

        assertEquals(5, list.size());
        assertEquals("0 1 2 3 4 ", list.toString());
        
        
        assertEquals("2", list.get(2));

        list.delete(2);  // 0 1 3 4
        assertEquals(4, list.size());
        assertEquals("0 1 3 4 ", list.toString());

        list.delete(0);  // 1 3 4
        assertEquals(3, list.size());
        assertEquals("1 3 4 ", list.toString());

        list.delete(list.size() - 1);  // 1 3
        assertEquals(2, list.size());
		assertEquals("1 3 ", list.toString());

        list.empty();
        assertEquals(0, list.size());
		
		
        MyArrayList<String> list0 = new MyArrayList<>();
		list0.add("2", 0);
		list0.add("4", 1);
		list0.add("3", 1);
		list0.add("1", 0);
		list0.add("5", 4);
		list0.add("0", 0);  // 0 1 2 3 4 5
		
		MyArrayList<String> list1 = new MyArrayList<>();
		list1.add("6", 0);
		list1.add("8", 1);
		list1.add("7", 1);
		list1.add("9", 3);
		list1.add("5", 0);  // 5 6 7 8 9
		
		MyArrayList<String> list2 = new MyArrayList<>();
		list2.add("11", list2.size());
		list2.add("12", list2.size());
		list2.add("13", list2.size());
		list2.add("14", list2.size());
		list2.add("15", list2.size()); // 11 12 13 14 15
		
		list0.join(list1);
        assertEquals("0 1 2 3 4 5 5 6 7 8 9 ", list0.toString());
		
		list0.join(list2);
        assertEquals("0 1 2 3 4 5 5 6 7 8 9 11 12 13 14 15 ", list0.toString());
		
		//extract
        assertEquals("5 6 7 8 9 11 12 13 14 15 ", list0.extract(6, 16).toString());
	}

}
