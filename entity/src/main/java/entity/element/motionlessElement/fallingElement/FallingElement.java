package entity.element.motionlessElement.fallingElement;

import entity.Map;
import entity.element.Direction;
import entity.element.Position;
import entity.element.TraversableByFalling;
import entity.element.motionlessElement.MotionlessElement;

public class FallingElement extends MotionlessElement {
	
	private boolean falling;
	public FallingElement(Map map, Position position) {
		super(map, position);
		this.setFalling(false);
	}
	
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

	public boolean isFalling() {
		return this.falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	
	public boolean checkIfCanSlide(Direction direction) {
		if(this.checkFallingPermeability(direction)==TraversableByFalling.Traversable && this.lookAtNextBlock(direction).checkFallingPermeability(Direction.Down)==TraversableByFalling.Traversable) {
			return true;
		} else {
			return false;
		}
	}
	
	public void slide() {
		if(this.checkIfCanSlide(Direction.Left)) {
			this.setFalling(true);
			this.moveLeft();
		} else if(this.checkIfCanSlide(Direction.Right)) {
			this.setFalling(true);
			this.moveRight();
		} else {
			this.setFalling(false);
			doNothing();
		}
	}
	
	@Override
	public void replaceByDiamond() {
		this.getMap().getFallingElements().remove(this);
		super.replaceByDiamond();
	}
}
