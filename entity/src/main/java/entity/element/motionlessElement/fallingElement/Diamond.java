package entity.element.motionlessElement.fallingElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * The Diamond class.
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Diamond extends FallingElement {
	/**
	 * The path to the sprite
	 */
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "diamond.gif";
	private static final char sprite_ref = '^';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Pickable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * Instantiates a new diamond.
	 * @param map
	 * 				The map
	 * @param position
	 * 				The position of the diamond.
	 */
	public Diamond(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
