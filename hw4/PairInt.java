package Maze;

/**
 * @author Esther Stolbach
 *
 *this class creates pairs of (x,y)
 */
public class PairInt {

	private int x;
	private int y;

	// constructor
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * this method returns the x value
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * this method returns the y value
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * this method sets the x value
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * this method sets the y value
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * this method checks to see if pairs are equal
	 */
	public boolean equals(Object p) {
		if (Object.class.equals(PairInt.class)) {
			PairInt i = (PairInt) p;
			if (i.getY() == y && i.getX() == x) {
				return true;
			}
		}
		return false;
	}

	/**
	 * this method creates a toString
	 */
	public String toString() {
		return "PairInt [x=" + x + ", y=" + y + "]";
	}

	/**
	 * this method copies the pair
	 * 
	 * @return pair
	 */
	public PairInt copy() {
		PairInt pair = new PairInt(x, y);
		return pair;
	}
}
