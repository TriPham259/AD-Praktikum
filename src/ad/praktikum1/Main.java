package ad.praktikum1;

import java.util.Date;
import java.util.Random;

import ad.praktikum1.lists.DoubleLinkedList;
import ad.praktikum1.lists.MyArrayList;

public class Main {

	public static void main(String[] args) {
		// Test for Auf4
		// "10 + 2 * 6" ---> 12 + 6 = 72 787108ns
		// "100 * 2 + 12" ---> 212 31788ns
		// "100 * ( 2 + 12 )" ---> 1400 27564ns
		// "100 * ( 2 + 12 ) / 14" ---> 100 48720ns
		// System.out.println(EvaluateExpressionUsingStacks.evaluate("10 + 2 * 6"));
		// System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * 2 + 12"));
		// System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12
		// )"));
		// System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 ) /
		// 14"));

		// Test for Auf5
		// int leng = 100;
		// int[] a = new int[leng];
		// for (int i = 0; i < leng; i++) {
		// a[i] = leng - i;
		// }
		//
		// System.out.println("max = " + MinMax.minMax(a)[0]);
		// System.out.println("min = " + MinMax.minMax(a)[1]);
		// System.out.println(MinMax.minMax(a)[2] + " Vergleichen");

		// Auf3
		// Testing DoubleLinkedList's performance
//		System.out.println("Testing DoubleLinkedList's performance:");
//		Random rand = new Random(); // random [0, 100]
//		DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
//		DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
//		DoubleLinkedList<Integer> list3 = new DoubleLinkedList<>();
//		long totalTime = 0;
//		long startTime;
//		long endTime;
//		long averageTime;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list1.add(rand.nextInt(101), 0);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at the start: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list2.add(rand.nextInt(101), rand.nextInt(list2.size() + 1));
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at random indexes: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list3.add(rand.nextInt(101), list3.size());
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at the end: \t\t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list1.delete(0);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 random elements at the start: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list2.delete(rand.nextInt(10000 - k));
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 rand. elements at rand. indexes: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list3.delete(list3.size() - 1);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 random elements at the end: \t" + averageTime + " ns");
//
//		// Testing MyArrayList's performance
//		System.out.println("Testing MyArrayList's performance:");
//		MyArrayList<Integer> list4 = new MyArrayList<>();
//		MyArrayList<Integer> list5 = new MyArrayList<>();
//		MyArrayList<Integer> list6 = new MyArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list4.add(rand.nextInt(101), 0);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at the start: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list5.add(rand.nextInt(101), rand.nextInt(list5.size() + 1));
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at random indexes: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 10000; k++) {
//				list6.add(rand.nextInt(101), list6.size());
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Add 10000 random elements at the end: \t\t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list4.delete(0);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 random elements at the start: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list5.delete(rand.nextInt(10000 - k));
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 rand. elements at rand. indexes: \t" + averageTime + " ns");
//
//		totalTime = 0;
//		for (int i = 0; i < 10; i++) {
//			startTime = System.nanoTime();
//			for (int k = 0; k < 1000; k++) {
//				list6.delete(list6.size() - 1);
//			}
//			endTime = System.nanoTime();
//			totalTime += (endTime - startTime);
//		}
//		averageTime = totalTime / 10;
//		System.out.println("Delete 1000 random elements at the end: \t" + averageTime + " ns");
		
		
		// Test for Auf2
//		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
//		list.add("1", 0);
//		list.add("3", list.size());
//		list.add("2", 1);
//		list.add("4", list.size());
//		list.add("0", 0); // (null) 0 1 2 3 4 (null)
//		list.delete(2);
//		list.delete(0);
//		list.delete(list.size() - 1);
//		list.empty();
//		System.out.println(list.getHead().getPrevious());
//		System.out.println(list);
//		System.out.println(list.getTail().getNext());
		
//		DoubleLinkedList<String> list0 = new DoubleLinkedList<String>();
//		list.add("1", 0);
//		list.add("3", list0.size());
//		list.add("2", 1);
//		list.add("4", list0.size());
//		list.add("5", list0.size()); // (null) 1 2 3 4 5 (null)
//		
//		DoubleLinkedList<String> list1 = new DoubleLinkedList<String>();
//		list1.add("6", list1.size());
//		list1.add("7", list1.size());
//		list1.add("8", list1.size());
//		list1.add("9", list1.size());
//		list1.add("10", list1.size()); // (null) 6 7 8 9 10 (null)
//		
//		DoubleLinkedList<String> list2 = new DoubleLinkedList<String>();
//		list2.add("11", list2.size());
//		list2.add("12", list2.size());
//		list2.add("13", list2.size());
//		list2.add("14", list2.size());
//		list2.add("15", list2.size()); // (null) 11 12 13 14 15 (null)
//		
//		list0.join(list1);
//		list0.join(list2);

//		System.out.println(list0);
//		System.out.println(list0.extract(1, 4));

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

		list0.join(list1).join(list2);  

		System.out.println(list0.extract(3, 16));
		System.out.println(list0);
		System.out.println(list1);
		System.out.println(list2);

		

	}

}
