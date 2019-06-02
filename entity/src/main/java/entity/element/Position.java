package entity.element;

/**
 * <h1>The Position class</h1>
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Position {
	/**
	 * x position
	 */
	private int x;
	/**
	 * y position
	 */
	private int y;

	/**
	 * The constructor
	 * @param x {@see #x}
	 * @param y {@see #y}
	 */
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Get {@link #x}
	 * @return {@link #x}
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Sets {@link #x}
	 * @param x {@link #x}
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get {@link #y}
	 * @return {@link #y}
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets {@link #y}
	 * @param y {@link #y}
	 */
	public void setY(int y) {
		this.y = y;
	}
}
