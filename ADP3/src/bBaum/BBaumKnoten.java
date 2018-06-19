package bBaum;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentation eines Knotens in einem B-Baum. Die Elemente, die im Knoten als
 * Schlüssel repräsentiert werden, müssen sortierbar sein.
 */
public class BBaumKnoten<K extends Comparable<K>, V> {

	/**
	 * Array von Schlüsseln (t-1 bis 2t-2)
	 */
	private List<KeyValuePair<K, V>> keyValPairs;

	/**
	 * Array von Referenzen auf Kindknoten (t bis 2*t-1)
	 */
	private List<BBaumKnoten<K, V>> children;

	/**
	 * Referenz auf den Elternknoten
	 */
	private BBaumKnoten<K, V> parent;
	
	public BBaumKnoten() {
		keyValPairs = new ArrayList<KeyValuePair<K, V>>();
		children = new ArrayList<>();
	}

	public BBaumKnoten(KeyValuePair<K, V> element) {
		keyValPairs = new ArrayList<KeyValuePair<K, V>>();
		keyValPairs.add(element);

		// 2 Kinder
		children = new ArrayList<>();
		children.add(null);
		children.add(null);
	}

	/**
	 * Überprüfen, ob Knoten einer Blattknoten ist (bzw. hat keine Kindknoten).
	 * @return falsch, wenn der Knoten mindestens einen nicht-null Kindknoten hat,
	 * sonst wahr.
	 */
	public boolean isLeaf() {
		for (BBaumKnoten<K, V> child : children) {
			if (child != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Liefert die Anzahl der Schlüssel im Knoten.
	 */
	public int size() {
		return keyValPairs.size();
	}
	
	/**
	 * Liefert die Anzahl der Kindknoten
	 */
	public int numOfChildren() {
		return children.size();
	}


	/**
	 * Extract from current node the pairs that have index within left..(right-1)
	 * and children index in left..right
	 * 
	 * @param left index lower bound
	 * @param right index strict upper bound
	 * @return subnode
	 */
	public BBaumKnoten<K, V> subNode(int left, int right) {
		BBaumKnoten<K, V> res = new BBaumKnoten<>();
		for (int i = left; i < right; i++) {
			res.addKeyValPair(i - left, getKeyValPair(i));
			res.setChild(i - left, getChild(i));
		}
		res.setChild(right - left, getChild(right));

		return res;
	}

	/**
	 * Fügt ein Element als Schlüssel an dem gegebenen Index ein (vor dem Schlüssel,
	 * der bisher an der Stelle stand). Fügt außerdem automatisch eine
	 * null-Kindknoten-Referenz ein.
	 */
	public void addKeyValPair(int index, KeyValuePair<K, V> element) {
		if (keyValPairs.size() == 0) {
			children.add(null);
		}
		keyValPairs.add(index, element);
		children.add(index, null);
	}

	/**
	 * Liefert den Schlüssel an dem gegebenen Index.
	 */
	public KeyValuePair<K, V> getKeyValPair(int index) {
		return keyValPairs.get(index);
	}

	/**
	 * Liefert den Elternknoten des Knotens.
	 */
	public BBaumKnoten<K, V> getParent() {
		return parent;
	}

	/**
	 * Liefert das Kind am gegebenen Index.
	 */
	public BBaumKnoten<K, V> getChild(int index) {
		return children.get(index);
	}

	/**
	 * Fügt einen neuen Schlüssel ein, setzt den Kindknoten links des Schlüssels und
	 * fügt einen neuen Kindknoten rechts des Schlüssels ein.
	 */
	public void insertKeyChild(BBaumKnoten<K, V> linkerKnoten, KeyValuePair<K, V> teiler,
			BBaumKnoten<K, V> rechterKnoten) {
		// Finde index des Teiler
		int index = -1;
		if (teiler.getKey().compareTo(getKeyValPair(0).getKey()) < 0) {
			index = 0;
		} else if (teiler.getKey().compareTo(getKeyValPair(size() - 1).getKey()) > 0) {
			index = size();
		} else {
			for (int i = 0; i < size() - 1; i++) {
				if (teiler.getKey().compareTo(getKeyValPair(i + 1).getKey()) < 0) {
					index = i + 1;
					break;
				}
			}
		}
		addKeyValPair(index, teiler);
		setChild(index, linkerKnoten);
		
		children.add(getChild(numOfChildren() - 1));
		for (int i = numOfChildren() - 2; i > index + 2; i--) {
			setChild(i, getChild(i - 1));
		}
		
		setChild(index + 1, rechterKnoten);
	}

	/**
	 * Ersetzt den Kindknoten am gegebenen Index. Index muss bereits gültig sein,
	 * kein Hinzufügen.
	 */
	public void setChild(int index, BBaumKnoten<K, V> knoten) {
		children.set(index, knoten);
		if (knoten != null) {
			knoten.setParent(this);
		}
	}

	/**
	 * Setzt den Elternknoten.
	 */
	public void setParent(BBaumKnoten<K, V> knoten) {
		parent = knoten;
	}

	/**
	 * Find the position of a key (to put) in a node
	 * 
	 * @param target
	 *            a key that needs to be search
	 * @return the index of the leftmost element in this node that is not less than
	 *         target.
	 */
	public int searchInNode(KeyValuePair<K, V> target) {
		int l = 0;
		int r = size() - 1;

		while (l <= r) {
			int m = (l + r) / 2;
			int comp = target.getKey().compareTo(getKeyValPair(m).getKey());
			if (comp == 0)
				return m;
			else if (comp < 0)
				r = m - 1;
			else
				l = m + 1;
		}
		return l;
	}

	/**
	 * Validiert den Knoten (Konsistenzprüfung). Liefert wahr, wenn der Knoten
	 * valide ist.
	 */
	public boolean validate(int ordnung) {
		// Schlüssel
		if (keyValPairs.size() < ordnung - 1 || keyValPairs.size() > ordnung * 2 - 1) {
			System.out.println("Validierung fehlgeschlagen: ungültige Schlüsselanzahl");
			return false;
		}

		// Kinder
		if (children.size() != keyValPairs.size() + 1) {
			System.out.println("Validierung fehlgeschlagen: ungültige Kindknotenanzahl");
			return false;
		}

		// Schlüsselreihenfolge
		for (int i = 0; i < keyValPairs.size() - 1; i++) {
			if (keyValPairs.get(i).getKey().compareTo(keyValPairs.get(i + 1).getKey()) > 0) {
				System.out.println("Validierung fehlgeschlagen: Schlüsselreihenfolge falsch");
				return false;
			}
		}

		// Position der Kinder
		if (keyValPairs.size() > 0) {
			if (children.get(0) != null) {
				// Größter Schlüssel des ersten Kindes muss kleiner als erster Schlüssel sein.
				if (children.get(0).getKeyValPair(children.get(0).size() - 1).getKey()
						.compareTo(keyValPairs.get(0).getKey()) > 0) {
					System.out.println("Kind " + 0 + " passt nicht in den Schlüsselbereich.");
					return false;
				}
			}
			if (children.get(children.size() - 1) != null) {
				// Kleinster Schlüssel des letzten Kindes muss größer sein als letzter
				// Schlüssely
				if (children.get(children.size() - 1).getKeyValPair(0).getKey()
						.compareTo(keyValPairs.get(keyValPairs.size() - 1).getKey()) < 0) {
					System.out.println("Kind " + (children.size() - 1) + " passt nicht in den Schlüsselbereich.");
					return false;
				}
			}
			for (int i = 0; i < keyValPairs.size() - 1; i++) {
				K schluesselLinks = keyValPairs.get(i).getKey();
				K schluesselRechts = keyValPairs.get(i + 1).getKey();
				if (children.get(i) != null) {
					K kindSchluesselMin = children.get(i + 1).getKeyValPair(0).getKey();
					K kindSchluesselMax = children.get(i + 1).getKeyValPair(children.get(i).size() - 1).getKey();
					if (kindSchluesselMin.compareTo(schluesselLinks) < 0) {
						System.out.println("Kind " + i + " passt nicht in den Schlüsselbereich.");
						return false;
					}
					if (kindSchluesselMax.compareTo(schluesselRechts) > 0) {
						System.out.println("Kind " + i + " passt nicht in den Schlüsselbereich.");
						return false;
					}
				}
			}
		}

		// Prüfe Kindknoten
		for (BBaumKnoten<K, V> kind : children) {
			if (kind != null) {
				if (!kind.validate(ordnung)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public String toString() {
		String ergebnis = "(" + ((getChild(0) != null) ? " " + getChild(0) + " " : "") + ")";
		for (int i = 0; i < keyValPairs.size(); i++) {
			ergebnis += getKeyValPair(i).getKey() + "";
			ergebnis += "(" + ((getChild(i + 1) != null) ? " " + getChild(i + 1) + " " : "") + ")";
		}
		ergebnis += "";
		return ergebnis;
	}

	
}
