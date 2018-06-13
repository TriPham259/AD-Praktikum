package quickSort;

import quickSort.pivot.PivotStrategy;

/**
 * Quicksort takes in a pivot-choosing strategy. 
 */
public class Quicksort<T extends Comparable<T>, U> {

    /**
     * Pivot-choosing strategy. 
     */
    protected PivotStrategy pivotStrategy;

    /**
     * Constructor for a quicksort.
     * @param pivotStrategy Pivot-choosing strategy.
     */
    public Quicksort(PivotStrategy pivotStrategy) {
        this.pivotStrategy = pivotStrategy;
    }

    /**
     * Sort a an array of key-value pairs ascending after the keys. 
     * @param arr Array of key-value pairs. 
     * @param low Lower bound of the array. 
     * @param high Upper bound of the array. 
     */
    public void sort(KeyValPair<T, U>[] arr, int low, int high) {
    	// do nothing if array is null, empty or has only 1 element.
    	if (arr == null || arr.length == 0 || low >= high) {
    		return;
    	}
    	
    	// pick a pivot 
    	int pivotIndex = pivotStrategy.getIndex(arr, low, high);
    	KeyValPair<T, U> pivot = arr[pivotIndex];
    	
    	// partion the array into 2 sub-arrays, so that
    	// all keys before the key-pivot are less than the key-pivot 
    	// all keys after the key-pivot are greater than the key-pivot 
    	// the pivot is considered sorted
    	int i = low;
    	int j = high; 
    	
    	while (i <= j) {
    		// find a key from the left side that is greater than key-pivot 
    		while (arr[i].getKey().compareTo(pivot.getKey()) < 0) {
    			i++;
    		}
    		
    		// find a key from the right side that is less than key-pivot
    		while (arr[j].getKey().compareTo(pivot.getKey()) > 0) {
    			j--;
    		}
    		
    		// swap these 2 keys 
    		if (i <= j) {
    			swap(arr, i, j);
    			// move index to next position on both sides
    			i++; 
    			j--;
    		}
    		
    	}
    	
    	// sort sub-array before the pivot 
    	if (low < j) { 
    		sort(arr, low, j);
    	}
    	
    	// sort sub-array after the pivot
    	if (i < high) {
    		sort(arr, i, high);
    	}
    }
    
    /**
	 * Swap 2 elements in an array. 
	 * @param arr The array. 
	 * @param i1 Index of the first element. 
	 * @param i2 Index of the second element. 
	 */
	public static <T extends Comparable<T>, U> void swap(KeyValPair<T, U>[] arr, int i1, int i2) {
		KeyValPair<T, U> tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

}
