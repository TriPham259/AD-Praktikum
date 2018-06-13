package quickSort;

/**
 * Key-value pair.
 */
public class KeyValPair<T extends Comparable<T>, U> {
    /**
     * Key.
     */
    private T key;

    /**
     * Value.
     */
    private U val;

    /**
     * Constructor for a key-value pair.
     * @param key Key.
     * @param val Value.
     */
    public KeyValPair(T key, U val) {
        this.key = key;
        this.val = val;
    }

    public T getKey() {
        return key;
    }

    public U getVal() {
        return val;
    }

    @Override
    public String toString() {
        return key + "=>" + val;
    }
}
