package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * <h1>The Class Wall</h1>
 * Used to set the insides walls
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Wall extends MotionlessElement {
	/**
	 * Path to the sprite.
	 */
	private static final String spritePath = "/sprites/settings/";
	/**
	 * The Image of the Sprite.
	 */
	private static final String imageName = "wall.png";
	/**
	 * The Sprite ref.
	 */
	private static final char sprite_ref = '#';
	/**
	 * Not traversable by alive elements.
	 */
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Blocking;
	/**
	 * Not traversable by falling elements.
	 */
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	/**
	 * The sprite
	 */
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * The constructor
	 * @param map
	 * 				The map.
	 * @param position
	 * 				The position of the Wall.
	 */
	public Wall(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
