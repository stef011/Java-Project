package entity.element.motionlessElement.fallingElement;

import entity.Map;
import entity.element.Direction;
import entity.element.Position;
import entity.element.TraversableByFalling;
import entity.element.motionlessElement.MotionlessElement;

/**
 * Class FallingElement, applied to an Element that can fall.
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class FallingElement extends MotionlessElement {
	/**
	 * The state of the object.
	 */
	private boolean falling;

	/**
	 * Instantiates a new falling element.
	 * @param map
	 * 					The map
	 * @param position
	 * 					The position of the falling element.
	 */
	public FallingElement(Map map, Position position) {
		super(map, position);
		this.setFalling(false);
	}

	/**
	 * Makes the element fall
	 */
	public void fall() {
		switch(this.checkFallingPermeability(Direction.Down)) {
		case Traversable:
			this.setFalling(true);
			this.moveDown();
			break;
		case Alive:
			if(this.isFalling()) {
				this.getAliveElementOnBottom().die();
			}
			break;
		case Slippery:
			this.slide();
			break;
		case Blocking:
			this.setFalling(false);
			break;
		}
	}

	/**
	 * @return {@link #falling}
	 */
	public boolean isFalling() {
		return this.falling;
	}

	/**
	 * Sets {@link #falling}
	 * @param falling
	 * 				The state.
	 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	/**
	 * Chesks if the falling Element can slide.
	 * @param direction
	 * 					The direction to check.
	 * @param directionDiag
	 * 					The Direction at the bottomLeft
	 * @return True or false.
	 */
	public boolean checkIfCanSlide(Direction direction, Direction directionDiag) {
		if(this.checkFallingPermeability(direction)==TraversableByFalling.Traversable 
				&& this.checkFallingPermeability(directionDiag)==TraversableByFalling.Traversable) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Make the element slide.
	 */
	public void slide() {
		if(this.checkIfCanSlide(Direction.Left, Direction.LeftDown)) {
			this.setFalling(true);
			this.moveLeft();
		} else if(this.checkIfCanSlide(Direction.Right, Direction.RightDown)) {
			this.setFalling(true);
			this.moveRight();
		} else {
			this.setFalling(false);
		}
	}

	/**
	 * Replace the element with diamonds.
	 */
	@Override
	public void replaceByDiamond() {
		this.getMap().getFallingElements().remove(this);
		super.replaceByDiamond();
	}
}
