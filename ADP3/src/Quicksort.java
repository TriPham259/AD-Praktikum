

/**
 * Basisklasse für die Implementierung des Quicksort-Algorithmus.
 */
public abstract class Quicksort<T extends Comparable<T>, U> {

    /**
     * Strategy zum Finden des Pivot-Elements.
     */
    protected PivotStrategie pivotStrategy;

    /**
     * Konstrucktor.
     */
    public Quicksort(PivotStrategie pivotStrategy) {
        this.pivotStrategy = pivotStrategy;
    }

    /**
     * Sortiert das Array a in-situ.
     *
     * @param a Array mit Schlüssel-Wert-Paaren, die nach den Schlüsseln aufsteigend sortiert werden sollen.
     */
    public abstract void sortiere(KeyValuePair<T, U>[] a);



}
