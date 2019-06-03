package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The Dirt Class
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Dirt extends MotionlessElement {

	/**
	 * Path to the sprite
	 */
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "dirt.png";
	private static final char sprite_ref = 'X';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Breakable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Blocking;
	/**
	 * The sprite
	 */
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * Instantiates a new dirt.
	 * @param map
	 * 				The map
	 * @param position
	 * 				The position of the Dirt
	 */
	public Dirt(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
