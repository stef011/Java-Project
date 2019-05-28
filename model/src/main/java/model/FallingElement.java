package model;

public class FallingElement extends MobileElement {
	private boolean falling;
	
	public FallingElement(int x, int y, Map map, Sprite sprite, TraversableByAlive traversableByAlive, TraversableByFalling traversableByFalling) {
		super(x, y, map, sprite, traversableByAlive, traversableByFalling);
		this.setFalling(false);
	}

	public boolean isFalling() {
		return this.falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	
	public FallingCase checkIfCanFall() {
		FallingCase fallingCase = FallingCase.NoFall;
		//checks under
		switch(this.getMap().getOnTheMapXY(this.getX(), this.getY()+1).getTraversableByFalling()) {
			case Traversable:
				fallingCase = FallingCase.FreeFall;
				break;
			case Slippery:
				//checks left and under-left
				if(this.getMap().getOnTheMapXY(this.getX()-1, this.getY()).getTraversableByFalling()==TraversableByFalling.Traversable 
				&& this.getMap().getOnTheMapXY(this.getX()-1, this.getY()+1).getTraversableByFalling()==TraversableByFalling.Traversable) {
					fallingCase = FallingCase.SlideLeft;
				}
				//checks right and under-right
				else if(this.getMap().getOnTheMapXY(this.getX()+1, this.getY()).getTraversableByFalling()==TraversableByFalling.Traversable 
				&& this.getMap().getOnTheMapXY(this.getX()+1, this.getY()+1).getTraversableByFalling()==TraversableByFalling.Traversable) {
					fallingCase = FallingCase.SlideRight;
				}
				else {
					fallingCase = FallingCase.NoFall;
				}
				break;
			default:
				fallingCase = FallingCase.NoFall;
				break;
		}

		return fallingCase;
	}
	
	public void Fall() {
		switch(this.checkIfCanFall()) {
		case FreeFall:
			this.setFalling(true);
			this.moveDown();
			break;
		case SlideLeft:
			this.setFalling(true);
			this.moveLeft();
			this.moveDown();
			break;
		case SlideRight:
			this.setFalling(true);
			this.moveRight();
			this.moveDown();
			break;
		default:
			this.setFalling(false);
			this.doNothing();
			break;
		}
	}
}
