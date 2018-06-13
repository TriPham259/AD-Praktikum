package quickSort.pivot;

import quickSort.KeyValPair;
import quickSort.Quicksort;

/**
 * Find the pivot among the first, last and middle elements of the array. Also sort these 3 elements. 
 */

public class PivotMedian implements PivotStrategy {

	@Override
	public <T extends Comparable<T>, U> int getIndex(KeyValPair<T, U>[] arr, int low, int high) {
		int mid = (low + high) / 2; 
		
		if (arr[high].getKey().compareTo(arr[low].getKey()) < 0) 
			Quicksort.swap(arr, high, low);
		
		if (arr[mid].getKey().compareTo(arr[low].getKey()) < 0) 
			Quicksort.swap(arr, mid, low);
		
		if (arr[high].getKey().compareTo(arr[mid].getKey()) < 0) 
			Quicksort.swap(arr, high, mid);
		
		return mid;
	}

}
