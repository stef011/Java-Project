package entity.element.aliveElement;

import entity.Map;
import entity.element.Direction;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The Mob class
 *
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Mob extends AliveElement {

	/**
	 * The path to the mob.
	 */
	private static final String spritePath = "/sprites/mobs/";
	private static final String imageName = "mob.gif";
	private static final char sprite_ref = 'M';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Mob;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * The constructor
	 * @param map The map
	 * @param position The position in the map
	 */
	
	public Mob(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);	
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
	
	public Mob() {
	}

	/**
	 * The mob movements
	 * @param lastMove
	 * 				Last move of the mob {@link #getLastMove()}
	 * @return The next direction of the mob
	 */
	public Direction checkOnLeft(Direction lastMove) {
		switch(lastMove) {
		case Up:
			return Direction.Left;
		case Left:
			return Direction.Down;
		case Down:
			return Direction.Right;
		case Right:
			return Direction.Up;
		default:
			break;
		}
		return lastMove;
	}

	/**
	 * <p>
	 * Moves the mob :
	 * <ul>
	 *     <li>Randomly</li>
	 *     <li>By following the player</li>
	 * </ul>
	 * </p>
	 */
	public void moveMobs() {
		Direction direction;
		if(this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Traversable || this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Player) {
			direction = this.getLastMove();
		} else if(this.checkAlivePermeability(this.checkOnLeft(this.getLastMove()))==TraversableByAlive.Traversable || this.checkAlivePermeability(this.checkOnLeft(this.getLastMove()))==TraversableByAlive.Player) {
			direction = this.checkOnLeft(this.getLastMove());
		} else if(this.checkAlivePermeability(this.checkOnLeft(this.checkOnLeft(this.getLastMove())))==TraversableByAlive.Traversable || this.checkAlivePermeability(this.checkOnLeft(this.checkOnLeft(this.getLastMove())))==TraversableByAlive.Player) {
			direction = this.checkOnLeft(this.checkOnLeft(this.getLastMove()));
		} else {
			direction = this.checkOnLeft(this.checkOnLeft(this.checkOnLeft(this.getLastMove())));
		}
		this.move(direction);
	}

	/**
	 * Check the environment of the mob to know if he can move, then moves the mob,
	 * if it was a player on the way, kills the player.
	 * @param direction
	 */
	@Override
	public void move(Direction direction) {
		switch(this.checkAlivePermeability(direction)) {
		case Traversable:
			this.setLastMove(direction);
			super.move(direction);
			break;
		case Player:
			this.getMap().getPlayer().die();
			break;
		default:
			break;
		}
	}

	/**
	 * Kills the mob.
	 */
	@Override
	public void die() {
		super.die();
		this.blow();
		this.getMap().getMobs().remove(this);
	}

	/**
	 * Replace the 3 by 3 area with diamond.
	 */
	public void blow() {
		this.replaceByDiamond();
		this.lookAtNextBlock(Direction.Up).replaceByDiamond();
		this.lookAtNextBlock(Direction.Left).replaceByDiamond();
		this.lookAtNextBlock(Direction.Down).replaceByDiamond();
		this.lookAtNextBlock(Direction.Right).replaceByDiamond();
		this.lookAtNextBlock(Direction.RightUp).replaceByDiamond();
		this.lookAtNextBlock(Direction.RightDown).replaceByDiamond();
		this.lookAtNextBlock(Direction.LeftDown).replaceByDiamond();
		this.lookAtNextBlock(Direction.LeftUp).replaceByDiamond();
	}

}
