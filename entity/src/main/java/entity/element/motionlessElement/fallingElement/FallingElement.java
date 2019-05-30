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
				this.moveDown();
			}
			break;
		case Slippery:
			if(this.checkFallingPermeability(Direction.Left)==TraversableByFalling.Traversable && this.lookAtNextBlock(Direction.Left).checkFallingPermeability(Direction.Down)==TraversableByFalling.Traversable) {
				this.setFalling(true);
				this.moveLeft();
				this.moveDown();
			} else if(this.checkFallingPermeability(Direction.Right)==TraversableByFalling.Traversable && this.lookAtNextBlock(Direction.Right).checkFallingPermeability(Direction.Down)==TraversableByFalling.Traversable){
				this.setFalling(true);
				this.moveRight();
				this.moveDown();
			} else {
				this.setFalling(false);
			}
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

}
