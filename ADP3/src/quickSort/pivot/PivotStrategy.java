package quickSort.pivot;

import quickSort.KeyValPair;

/**
 * Interface for pivot-choosing strategies. 
 */
public interface PivotStrategy {
    /**
     * Return the index of the pivot. 
     * @param arr Array of key-value pairs. 
     * @param low Lower bound of array.
     * @param high Upper bound of array.
     * @return Index of the pivot. 
     */
    public <T extends Comparable<T>, U> int getIndex(KeyValPair<T, U>[] arr, int low, int high);
}
