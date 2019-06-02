package entity.element.motionlessElement.fallingElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The rock class
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Rock extends FallingElement {

	/**
	 * Path to the sprite
	 */
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "rock.png";
	private static final char sprite_ref = 'O';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Pushable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	/**
	 * The sprite
	 */
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * Instantiates a new Rock.
	 * @param map
	 *				The actual map.
	 * @param position
	 * 				The position of the rock.
	 */
	public Rock(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
