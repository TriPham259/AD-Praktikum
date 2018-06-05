

//muss angepasst werden!!!
import PivotStrategyMedian;
import QuicksortLoesung;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testklasse für das Quicksort-Verfahren.
 */
public class TestQuicksort {

    /**
     * Verschiedene Konstanzen für die Generierung von Testdaten in der Methode generierDaten().
     */
    private enum DatenGenerierung {
        IN_REIHENFOLGE, ZUFALL, RUECKWAERTS
    }

    /**
     * Mit dieser Instanz wird getestet.
     */
    // TODO: Legen Sie hier eine Instanz Ihrer Implementierung an.
    Quicksort<Integer, String> qs = //null;
            new QuicksortLoesung<>(new PivotStrategyMedian());

    private KeyValuePair<Integer, String>[] generiereDaten(int anzahl, DatenGenerierung datenGenerierung) {
        KeyValuePair<Integer, String>[] daten = new KeyValuePair[anzahl];
        for (int i = 0; i < daten.length; i++) {
            switch (datenGenerierung) {
                case IN_REIHENFOLGE:
                    daten[i] = new KeyValuePair<Integer, String>(i, i + "");
                    break;
                case ZUFALL:
                    int wert = (int) (Math.random() * anzahl * 10);
                    daten[i] = new KeyValuePair<Integer, String>(wert, wert + "");
                    break;
                case RUECKWAERTS:
                    daten[i] = new KeyValuePair<Integer, String>(anzahl - i, (anzahl - i) + "");
                    break;
            }
        }
        return daten;
    }

    @Test
    public void test() {
        KeyValuePair<Integer, String>[] daten = generiereDaten(10, DatenGenerierung.RUECKWAERTS);
        //ausgeben("vorher: ", daten);

        qs.sortiere(daten);
        for (int i = 0; i < daten.length - 1; i++) {
            assertTrue("Daten sind nicht korrekt sortiert", daten[i].getKey().compareTo(daten[i + 1].getKey()) <= 0);
        }

        //ausgeben("nachher: ", daten);
    }

    /**
     * Hilfsmethode zur Ausgabe eines Arrays auf der Konsole.
     *
     * @param nachricht Diese Nachricht wird mit ausgegeben.
     * @param daten     Array
     */
    public static <T extends Comparable<T>, U> void ausgeben(String nachricht, KeyValuePair<T, U>[] daten) {
        System.out.print(nachricht + ": ");
        for (KeyValuePair<T, U> element : daten) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
