package quickSort.pivot;

import java.util.Random;

import quickSort.KeyValPair;

/**
 * Take a random element of the array as the pivot. 
 */
public class PivotRandom implements PivotStrategy  {

	@Override
	public <T extends Comparable<T>, U> int getIndex(KeyValPair<T, U>[] arr, int low, int high) {
		return low + new Random().nextInt(high - low);
	}
	
}
