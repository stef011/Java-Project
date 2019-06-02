package entity.element.aliveElement;

import entity.element.Direction;
import entity.Map;
import entity.element.Element;
import entity.element.Position;

/**
 * The AliveElements class
 *
 * @author Exars 18-23 Strasbourg grp1
 */

public class AliveElement extends Element {

	/**
	 * The last move of the entity
	 */
	private Direction lastMove = Direction.Left;

	/**
	 * The alive state
	 */
	private boolean alive;

	/**
	 * The constructor
	 * @param map
	 * 				The map
	 * @param position
	 * 				The position of the entity
	 */
	public AliveElement(Map map, Position position) {
		super(map, position);
		this.setAlive(true);
	}
	
	public AliveElement() {
		
	}

	/**
	 * When the entity dies.
	 */
	public void die() {
		this.setAlive(false);
		this.replaceByEmptySpace();
	}

	/**
	 * Is the entity alive ?
	 * @return The state of {@link #alive}
	 */
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Sets the element alive or not.
	 * @param alive
	 * 				True or false.
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the last move of the entity.
	 * @see #lastMove
	 */
	public Direction getLastMove() {
		return lastMove;
	}

	/**
	 * Sets the last move of the Element
	 * @param lastMove
	 * 					Direction of the last move
	 * @see	#lastMove
	 */
	public void setLastMove(Direction lastMove) {
		this.lastMove = lastMove;
	}
}
