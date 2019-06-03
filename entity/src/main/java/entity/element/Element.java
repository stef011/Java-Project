package entity.element;

import entity.element.Direction;
import entity.element.aliveElement.AliveElement;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.Entity;
import entity.Map;

/**
 * <h1>The Element Class.</h1>
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Element extends Entity {
	/**
	 * The sprite
	 */
	private Sprite sprite;
	/**
	 * The position of the element
	 */
	private Position position;
	/**
	 * The map.
	 */
	private Map map;
	/**
	 * @see	TraversableByAlive
	 */
	private TraversableByAlive traversableByAlive;
	/**
	 * @see TraversableByFalling
	 */
	private TraversableByFalling traversableByFalling;

	/**Instantiates a new Element.
	 * @param map
	 * 
	 * 				The map.
	 * @param position
	 * 				The position if the element.
	 */
	public Element(Map map, Position position) {
		this.setPosition(position);
		this.setMap(map);
	}
	
	/**
	 * Instantiates a new Element.
	 */
	public Element() {
	}

	/**
	 * Replace the element by an empty space.
	 */
	public void replaceByEmptySpace() {
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), ElementFactory.createEmptySpace(this.getMap(), this.getPosition()));
	}

	/**
	 * Replace the element by diamonds.
	 */
	public void replaceByDiamond() {
		FallingElement diamond = ElementFactory.createDiamond(this.getMap(), this.getPosition());
		this.getMap().getFallingElements().add(diamond);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this.getMap().getFallingElements().get(this.getMap().getFallingElements().lastIndexOf(diamond)));

	}

	/**
	 * Return the direction.
	 * @param str
	 * 				The direction string.
	 * @return The {@link Direction}
	 */
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

	/**
	 * Return the Object at the direction specified
	 * @param direction
	 * 					The direction.
	 * @return The {@link Element} located at the direction specified.
	 */
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

	/**
	 * @return The {@link AliveElement} on the bottom (if there is one).
	 */
	public AliveElement getAliveElementOnBottom() {
		return this.getMap().getAliveOnTheMapXY(this.getPosition().getX(), this.getPosition().getY()+1);
	}

	/**
	 * Check if it can traverse the element at the direction specified.
	 * @param direction
	 * 					The direction
	 * @return TraversableByAlive
	 */
	public TraversableByAlive checkAlivePermeability(Direction direction) {		
		return this.lookAtNextBlock(direction).getTraversableByAlive();
	}

	/**
	 * Check if it can traverse the element at the direction specified.
	 * @param direction The direction
	 * @return TraversableByFalling
	 */
	public TraversableByFalling checkFallingPermeability(Direction direction) {
		return this.lookAtNextBlock(direction).getTraversableByFalling();
	}

	/**
	 * Gets the Sprite
	 * @return The {@link #sprite}
	 */
	public Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite
	 * @param sprite
	 * 				The sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Gets the position
	 * @return The {@link #position}.
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 * @param position
	 * 					The position.
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Get the permeability for {@link AliveElement}.
	 * @return {@link #traversableByAlive}
	 */
	public TraversableByAlive getTraversableByAlive() {
		return this.traversableByAlive;
	}

	/**
	 * Sets the permeability for {@link AliveElement}.
	 * @param traversableByAlive
	 * 						{@link TraversableByAlive}
	 */
	public void setTraversableByAlive(TraversableByAlive traversableByAlive) {
		this.traversableByAlive = traversableByAlive;
	}

	/**
	 * Get the permeability for {@link FallingElement}.
	 * @return The {@link #traversableByFalling} Element
	 */
	public TraversableByFalling getTraversableByFalling() {
		return this.traversableByFalling;
	}

	/**
	 * Sets the permeability for {@link FallingElement}.
	 * @param traversableByFalling  Enum {@link TraversableByFalling}
	 */
	public void setTraversableByFalling(TraversableByFalling traversableByFalling) {
		this.traversableByFalling = traversableByFalling;
	}

	/**
	 * Gets the map
	 * @return The {@link #map}
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 * @param map
	 * 				The map.
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * Moves the element Up
	 */
	public void moveUp() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}

	/**
	 * Moves the element Down
	 */
	public void moveDown() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}

	/**
	 * Moves the element to the Left
	 */
	public void moveLeft() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}

	/**
	 * Move the element to the Right
	 */
	public void moveRight() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}

	/**
	 * Moves the element to the direction
	 * @param direction
	 * 					The direction where the element moves.
	 */
	public void move(String direction) {
		this.move(this.stringToDirection(direction));
	}

	/**
	 * Moves the element to the direction provided.
	 * @param direction
	 * 					The direction where the element moves.
	 */
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
}
