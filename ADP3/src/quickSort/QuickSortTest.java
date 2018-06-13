package quickSort;

import org.junit.Test;

import quickSort.pivot.PivotLeft;
import quickSort.pivot.PivotMedian;
import quickSort.pivot.PivotMiddle;
import quickSort.pivot.PivotRandom;
import quickSort.pivot.PivotRight;

import static org.junit.Assert.assertTrue;

/**
 * Test quicksort with different pivot-choosing strategies and arrays.
 */
public class QuickSortTest {
    private Quicksort<Integer, String> qs;
    private KeyValPair<Integer, String>[] data;
    private static final int SMALL_NUM = 1000; 
    private static final int BIG_NUM = 10000;

    @Test
    public void pivotStrategyLeftTest() {   	
    	System.out.println("Leftmost strategy:");
        qs = new Quicksort<>(new PivotLeft());
        
    	System.out.println("\tArray with ascending keys (only small number)");
		data = generateData(SMALL_NUM, Order.ASCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
		
    	System.out.println("\tArray with descending keys (only small number)");
    	data = generateData(SMALL_NUM, Order.DESCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    	
    	System.out.println("\tArray with random keys");
    	data = generateData(BIG_NUM, Order.RANDOM);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    }
    
    @Test
    public void pivotStrategyRightTest(){
    	System.out.println("Rightmost strategy:");
        qs = new Quicksort<>(new PivotRight());
    	
        System.out.println("\tArray with ascending keys (only small number)");
		data = generateData(SMALL_NUM, Order.ASCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
		
    	System.out.println("\tArray with descending keys (only small number)");
    	data = generateData(SMALL_NUM, Order.DESCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    	
    	System.out.println("\tArray with random keys");
    	data = generateData(BIG_NUM, Order.RANDOM);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    }

    @Test
    public void pivotStrategyMiddleTest(){
    	System.out.println("Middle strategy:");
    	qs = new Quicksort<>(new PivotMiddle());
    
    	System.out.println("\tArray with ascending keys");
		data = generateData(BIG_NUM, Order.ASCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
		
    	System.out.println("\tArray with descending keys");
    	data = generateData(BIG_NUM, Order.DESCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    	
    	System.out.println("\tArray with random keys");
    	data = generateData(BIG_NUM, Order.RANDOM);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    }
    
    @Test
    public void pivotStrategyRandomTest(){
    	System.out.println("Random strategy:");
    	qs = new Quicksort<>(new PivotRandom());
    	
    	System.out.println("\tArray with ascending keys");
		data = generateData(BIG_NUM, Order.ASCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
		
    	System.out.println("\tArray with descending keys");
    	data = generateData(BIG_NUM, Order.DESCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    	
    	System.out.println("\tArray with random keys");
    	data = generateData(BIG_NUM, Order.RANDOM);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    }
    
    @Test 
    public void pivotStrategyMedianOfThreeTest(){
    	
    	System.out.println("Median-of-3 strategy:");
    	qs = new Quicksort<>(new PivotMedian());
    	
    	System.out.println("\tArray with ascending keys");
		data = generateData(BIG_NUM, Order.ASCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);

    	System.out.println("\tArray with descending keys");
    	data = generateData(BIG_NUM, Order.DESCENDING);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    	
    	System.out.println("\tArray with random keys");
    	data = generateData(BIG_NUM, Order.RANDOM);
		qs.sort(data, 0, data.length - 1);
		isSorted(data);
    }
    
    /**
     * Orders of keys in the array. 
     */
    private enum Order {
        ASCENDING, DESCENDING, RANDOM 
    }
    
    /**
     * Generate an array of key-value pairs. 
     * @param num Number of elements in the array. 
     * @param order Order of keys in the array.
     * @return An array of key-value pairs. 
     */
    private KeyValPair<Integer, String>[] generateData(int num, Order order) {
        KeyValPair<Integer, String>[] arr = new KeyValPair[num];
        for (int i = 0; i < arr.length; i++) {
            switch (order) {
                case ASCENDING:
                    arr[i] = new KeyValPair<Integer, String>(i, "");
                    break;
                case DESCENDING:
                    arr[i] = new KeyValPair<Integer, String>(num - i - 1, "");
                    break;
                case RANDOM:
                    int wert = (int) (Math.random() * num * 10);
                    arr[i] = new KeyValPair<Integer, String>(wert, "");
                    break;
            }
        }
        return arr;
    }
    
    /**
     * Print keys of each element in the array. 
     * @param message Message to be included. 
     * @param data Array of key-value pairs.
     */
    private static <T extends Comparable<T>, U> void printKeys(String message, KeyValPair<T, U>[] arr) {
        System.out.print(message);
        String str = "{";
        for (KeyValPair<T, U> pair : arr) {
            str += pair.getKey() + ", ";
        }
        System.out.println(str.replaceAll(". $", "}"));
    }
    
    /**
     * Check if the array is sorted correctly.
     * @param arr Array of key-value pairs. 
     */
    private static <T extends Comparable<T>, U> void isSorted(KeyValPair<T, U>[] arr) {
    	for (int i = 0; i < arr.length - 1; i++) {
			assertTrue("Array is not correctly sorted.",
					arr[i].getKey().compareTo(arr[i + 1].getKey()) <= 0);
		}
    }
    

}
