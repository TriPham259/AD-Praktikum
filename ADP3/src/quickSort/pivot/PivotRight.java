package quickSort.pivot;

import quickSort.KeyValPair;

/**
 * Take the rightmost element of the array as the pivot. 
 */
public class PivotRight implements PivotStrategy {

	@Override
	public <T extends Comparable<T>, U> int getIndex(KeyValPair<T, U>[] arr, int low, int high) {
		return high;
	}

}
