package entity.element.aliveElement;

import entity.element.Direction;
import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The player class
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Player extends AliveElement {

	/**
	 * The score
	 */
	private int score;
	/**
	 * The path to the sprite
	 */
	private static final String spritePath = "/sprites/player/";
	
	private static final String imageFront = "front.png";
	private static final String imageBack = "back.png";
	private static final String imageLeft = "left.png";
	private static final String imageRight = "right.png";
	
	private static final char sprite_ref = '@';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Player;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite front = new Sprite(sprite_ref, spritePath, imageFront);
	private static final Sprite back = new Sprite(sprite_ref, spritePath, imageBack);
	private static final Sprite left = new Sprite(sprite_ref, spritePath, imageLeft);
	private static final Sprite right = new Sprite(sprite_ref, spritePath, imageRight);

	/**
	 * The constructor
	 * @param map
	 * 				The map
	 * @param position
	 *				The position of the player
	 */
	public Player(Map map, Position position) {
		super(map, position);
		
		front.loadImage();
		back.loadImage();
		left.loadImage();
		right.loadImage();
		
		this.setScore(0);
		this.setSprite(front);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}

	/**
	 * Moves the player up.
	 */
	@Override
	public void moveUp() {
		this.setSprite(back);
		super.moveUp();
	}

	/**
	 * Moves the player down.
	 */
	@Override
	public void moveDown() {
		this.setSprite(front);
		super.moveDown();
	}

	/**
	 * Moves the payer to the left.
	 */
	@Override
	public void moveLeft() {
		this.setSprite(left);
		super.moveLeft();
	}

	/**
	 * Moves the player to the right.
	 */
	@Override
	public void moveRight() {
		this.setSprite(right);
		super.moveRight();
	}

	/**
	 * Checks if the player can move.
	 * @param direction
	 * 					The direction to check.
	 */
	@Override
	public void move(Direction direction) {
		switch(this.checkAlivePermeability(direction)) {
		case Traversable:
		case Breakable:
			super.move(direction);
			break;
		case Pushable:
			this.push(direction);
			break;
		case Pickable:
			this.pick(direction);
			break;
		case Mob:
			this.die();
			break;
		default:
			break;
		}
	}

	/**
	 * Pushes the object.
	 * @param direction
	 * 					The direction to push the object.
	 */
	public void push(Direction direction) {
		if(direction==Direction.Left || direction==Direction.Right) {
			if(this.lookAtNextBlock(direction).checkFallingPermeability(direction)==TraversableByFalling.Traversable) {
				this.lookAtNextBlock(direction).move(direction);
				super.move(direction);
			}
		}
	}

	/**
	 * Picks the object.
	 * @param direction
	 * 					The direction where the player is moving.
	 */
	public void pick(Direction direction) {
		this.getMap().getFallingElements().remove(this.lookAtNextBlock(direction));
		this.setScore(this.getScore()+1);
		super.move(direction);
	}
	
	@Override
	public void replaceByDiamond() {
		super.replaceByDiamond();
		this.die();
	}

	/**
	 * Gets the score
	 * @return {@link #score}
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Sets the score.
	 * @param score
	 * 				The {@link #score}
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
