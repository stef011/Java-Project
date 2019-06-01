package entity.element;

import entity.element.Direction;
import entity.element.aliveElement.AliveElement;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.Entity;
import entity.Map;

public class Element extends Entity implements IMovement{
	private Sprite sprite;
	private Position position;
	private Map map;
	private TraversableByAlive traversableByAlive;
	private TraversableByFalling traversableByFalling;
	private Breakable breakable;
	
	public Element(Map map, Position position) {
		this.setPosition(position);
		this.setMap(map);
		this.setBreakable(Breakable.Breakable);
	}
	
	
	public Element() {

	}
	
	public void replaceByEmptySpace() {
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), ElementFactory.createEmptySpace(this.getMap(), this.getPosition()));
	}
	
	public void replaceByDiamond() {
		if(this.getBreakable()==Breakable.Breakable){
			FallingElement diamond = ElementFactory.createDiamond(this.getMap(), this.getPosition());
			this.getMap().getFallingElements().add(diamond);
			this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this.getMap().getFallingElements().get(this.getMap().getFallingElements().lastIndexOf(diamond)));
		}
	}
	
	public Direction stringToDirection(String str) {
		switch(str) {
		case "Up":
			return Direction.Up;
		case "Down":
			return Direction.Down;
		case "Left":
			return Direction.Left;
		case "Right":
			return Direction.Right;
		default:
			return null;
		}
	}
	
	public Element lookAtNextBlock(Direction direction) {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		
		switch(direction) {
		case Up:
			return this.getMap().getOnTheMapXY(x, y-1);
		case Down:
			return this.getMap().getOnTheMapXY(x, y+1);
		case Left:
			return this.getMap().getOnTheMapXY(x-1, y);
		case Right:
			return this.getMap().getOnTheMapXY(x+1, y);
		case RightDown:
			return this.getMap().getOnTheMapXY(x+1, y+1);
		case LeftDown:
			return this.getMap().getOnTheMapXY(x-1, y+1);
		case RightUp:
			return this.getMap().getOnTheMapXY(x+1, y-1);
		case LeftUp:
			return this.getMap().getOnTheMapXY(x-1, y-1);
		}
		return null;
	}
	
	public AliveElement getAliveElementOnBottom() {
		return this.getMap().getAliveOnTheMapXY(this.getPosition().getX(), this.getPosition().getY()+1);
	}
	
	public TraversableByAlive checkAlivePermeability(Direction direction) {		
		return this.lookAtNextBlock(direction).getTraversableByAlive();
	}
	
	public TraversableByFalling checkFallingPermeability(Direction direction) {
		return this.lookAtNextBlock(direction).getTraversableByFalling();
	}

	public Sprite getSprite() {
		return this.sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public Position getPosition() {
		return this.position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public TraversableByAlive getTraversableByAlive() {
		return this.traversableByAlive;
	}
	public void setTraversableByAlive(TraversableByAlive traversableByAlive) {
		this.traversableByAlive = traversableByAlive;
	}
	public TraversableByFalling getTraversableByFalling() {
		return this.traversableByFalling;
	}
	public void setTraversableByFalling(TraversableByFalling traversableByFalling) {
		this.traversableByFalling = traversableByFalling;
	}
	public Map getMap() {
		return this.map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void moveUp() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveDown() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveLeft() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveRight() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void doNothing() {
		// As expected, this method does nothing.
	}

	@Override
	public void move(String direc) {
		this.move(this.stringToDirection(direc));
	}

	@Override
	public void move(Direction direction) {
		switch(direction) {
		case Up:
			this.moveUp();
			break;
		case Down:
			this.moveDown();
			break;
		case Left:
			this.moveLeft();
			break;
		case Right:
			this.moveRight();
			break;
		default:
			break;
		}
		
	}


	public Breakable getBreakable() {
		return this.breakable;
	}


	public void setBreakable(Breakable breakable) {
		this.breakable = breakable;
	}
}
