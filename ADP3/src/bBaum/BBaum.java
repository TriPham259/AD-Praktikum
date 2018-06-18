package bBaum;

import java.util.ArrayList;
import java.util.List;


/**
 * Basisklasse für einen B-Baum von (sortierbaren) Elementen vom Typ T.
 */
public class BBaum<K extends Comparable<K>, V> {
	/**
	 * Wurzelknoten des BBaum
	 */
	protected BBaumKnoten<K, V> root = null;

	/**
	 * Ordnung des Baumens: Anzahl der Schlüssel liegt zwischen (ordnung-1) und
	 * (2*ordnung-2).
	 */
	protected int deg;

	public BBaum(int deg) {
		this.deg = deg;
	}

	/**
	 * maximum number of key-value-pairs in a node 
	 */
	public int maxNodeSize() {
		return 2 * deg - 2;
	}

	/**
	 * Validiert den Baum (und alle) seine Knoten. Liefert wahr, wenn die
	 * Datenstruktur valide ist, ansonsten falsch.
	 */
	public boolean validate() {
		return root.validate(deg);
	}

	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * Liefert den Wert zu einem Schlüssel im Baum. Liefert null, falls der
	 * Schlüssel nicht gefunden werden kann.
	 *
	 * @param key
	 *            Schlüssel nach dem gesucht wird
	 */
	public V getValFromKey(K key) {
		if (root == null) {
			return null;
		}

		return getValFromKey(key, root);
	}

	/**
	 * Liefert den Wert zu einem Schlüssel im Baum. Liefert null, falls der
	 * Schlüssel nicht gefunden werden kann.
	 *
	 * @param key
	 *            Schlüssel nach dem gesucht wird.
	 * @param node
	 *            Knoten der (rekursiv) durchsucht wird.
	 */
	private V getValFromKey(K key, BBaumKnoten<K, V> node) {
		if (node == null) {
			return null;
		}
		// iterate through all KV-Pairs in node
		for (int i = 0; i < node.size(); i++) {
			KeyValuePair<K, V> key_val = node.getKeyValPair(i);

			if (key_val.getKey().compareTo(key) == 0) {
				return key_val.getValue();
			} else if (key_val.getKey().compareTo(key) > 0) {
				return getValFromKey(key, node.getChild(i));
			}
		}

		return getValFromKey(key, node.getChild(node.numOfChildren() - 1));
	}

	/**
	 * Liefert die Anzahl der Schlüssel im Baum.
	 */
	public int numOfKeys() {
		return numOfKeys(root);
	}

	/**
	 * Liefert die Anzahl der Schlüssel im Knoten und rekursiv in seinen Kindknoten.
	 */
	private int numOfKeys(BBaumKnoten<K, V> node) {
		if (node == null) {
			return 0;
		}
		int anzahlSchluessel = node.size();
		for (int i = 0; i < node.numOfChildren(); i++) {
			anzahlSchluessel += numOfKeys(node.getChild(i));
		}
		return anzahlSchluessel;
	}

	/**
	 * Liefert die Element in der Pre-order Reihenfolge.
	 */
	public List<KeyValuePair<K, V>> printPreOrder() {
		return printPreOrder(root);
	}

	/**
	 * Liefert die Elemente in der Pre-order Reihenfolge.
	 */
	public List<KeyValuePair<K, V>> printPreOrder(BBaumKnoten<K, V> node) {
		if (node == null) {
			return new ArrayList<>();
		}
		List<KeyValuePair<K, V>> preOrderElemente = new ArrayList<>();
		for (int i = 0; i < node.size(); i++) {
			preOrderElemente.addAll(printPreOrder(node.getChild(i)));
			preOrderElemente.add(node.getKeyValPair(i));
		}
		preOrderElemente.addAll(printPreOrder(node.getChild(node.size())));
		return preOrderElemente;
	}

	/**
	 * Leert den gesamten Baum.
	 */
	public void empty() {
		root = null;
	}

	/**
	 * Fügt das Element in den Knoten ein. 
	 * @param key
	 *            Schlüssel des Elementes, das in den aktuellen Knoten eingefügt
	 *            werden soll
	 * @param value
	 *            Wert des Elementes.
	 * @return den neuen Wurzelknoten des Baumes
	 */
	public BBaumKnoten<K, V> insert(K key, V value) {
		KeyValuePair<K, V> insertPair = new KeyValuePair<K, V>(key, value);

		// if tree is empty, simply insert new
		if (root == null) {
			root = new BBaumKnoten<>(insertPair);
			return root;
		}

		BBaumKnoten<K, V> curr = root;
		for (;;) {
			// position of insertPair in current node
			int currPos = curr.searchInNode(insertPair);

			// if position of insertion is in a leaf -> insert
			if (curr.isLeaf()) {
				curr.addKeyValPair(currPos, insertPair);

				// if current node becomes overflowed
				if (curr.size() > maxNodeSize()) {
					splitNode(curr);
				}
				return root;
			} else {
				// traverse down to a child (until reaching a leaf)
				curr = curr.getChild(currPos);
			}
		}
	}

	/**
	 * Split the current node, push the middle element into its parent node
	 */
	public void splitNode(BBaumKnoten<K, V> node) {
		// seperate current node into 3 parts
		int medPos = node.size() / 2;
		KeyValuePair<K, V> med = node.getKeyValPair(medPos);
		BBaumKnoten<K, V> leftSubNode = node.subNode(0, medPos);
		BBaumKnoten<K, V> rightSubNode = node.subNode(medPos + 1, node.size());

		// if root node is to be split
		if (node == root) {
			// set med as new root
			root = new BBaumKnoten<>(med);

			// set leftSubNode and rightSubNode as its two children
			root.setChild(0, leftSubNode);
			root.setChild(1, rightSubNode);
		} else {
			BBaumKnoten<K, V> parent = node.getParent();
			
			// push med into parent and make leftSubNode and rightSubNode its children
			parent.insertKeyChild(leftSubNode, med, rightSubNode);

			// if parent becomes overflowed, split again
			if (parent.size() > maxNodeSize()) {
				splitNode(parent);
			}
		}
	}

	public static void main(String[] args) {
		BBaum<Integer, String> baum = new BBaum<Integer, String>(2);

		baum.insert(23, "23");
		System.out.println(baum); 
		System.out.println(baum.numOfKeys());
		
		baum.insert(42, "42");
		System.out.println(baum);
		System.out.println(baum.numOfKeys());
		
		System.out.println(baum.printPreOrder());
		
		baum.insert(12, "12");
		System.out.println(baum);
		System.out.println(baum.numOfKeys());
		
		baum.insert(25, "25");
		System.out.println(baum);
		
		baum.insert(20, "20");
		System.out.println(baum);
		
		baum.insert(11, "11");
		System.out.println(baum);
		
		baum.insert(24, "24");
		System.out.println(baum);
	}
}
