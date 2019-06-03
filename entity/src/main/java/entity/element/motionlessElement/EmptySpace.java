package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The Class EmptySpace
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class EmptySpace extends MotionlessElement {

	/**
	 * Path to the sprite.
	 */
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "emptySpace.png";
	private static final char sprite_ref = '_';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Traversable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Traversable;
	/**
	 * The sprite
	 */
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * Instantiates a new emptySpace.
	 * @param map
	 * 				The map.
	 * @param position
	 * 				The position of the empty space.
	 */
	public EmptySpace(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
