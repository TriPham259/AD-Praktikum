package quickSort.pivot;

import quickSort.KeyValPair;

/**
 * Take the middle element of the array as the pivot. 
 */
public class PivotMiddle implements PivotStrategy{

	@Override
	public <T extends Comparable<T>, U> int getIndex(KeyValPair<T, U>[] arr, int low, int high) {
		return low + (high  - low) / 2; 
	}

}
