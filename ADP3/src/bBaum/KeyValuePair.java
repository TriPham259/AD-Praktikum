package bBaum;

/**
 * Repräsentation eines Schlüssel-Wert-Paares.
 */
public class KeyValuePair<K extends Comparable<K>, V> {
    /**
     * Schlüssel.
     */
    private K key;

    /**
     * Wert.
     */
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "->" + value;
    }
}
