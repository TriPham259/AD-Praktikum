package model;
/**
 * 
 * @author tripham
 *
 */
public class Criterion {
	private Col col;
	private int min;
	private int max;

	/**
	 * Constructor for Criterion.
	 * 
	 * @param col
	 *            Column to create Criterion.
	 * @param min
	 *            Minimum value of Criterion.
	 * @param max
	 *            Maximum value of Criterion.
	 */
	public Criterion(Col col, int min, int max) throws IllegalArgumentException {
		if (min < 0 || max < 0 || min > max) {
			throw new IllegalArgumentException("Illegal min, max value.");
		}

		this.col = col;
		this.min = min;
		this.max = max;
	}

	public Col getCol() {
		return col;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	@Override
	public String toString() {
		return "Criterion {col = " + col + "; min = " + min + "; max = " + max + "}";
	}

}
