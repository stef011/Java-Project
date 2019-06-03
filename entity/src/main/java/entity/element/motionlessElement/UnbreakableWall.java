package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

/**
 * <h1>The Class UnbreakableWall</h1>
 * Used to build the external walls
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class UnbreakableWall extends MotionlessElement {
	/**
	 * Path to the sprite.
	 */
	private static final String spritePath = "/sprites/settings/";
	/**
	 * Name of the Sprite-Image
	 */
	private static final String imageName = "wall.png";
	/**
	 * Ref of the sprite.
	 */
	private static final char sprite_ref = '#';
	/**
	 * Traversable by an alive element.
	 */
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Blocking;
	/**
	 * Traversable by a falling element.
	 */
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Blocking;
	/**
	 * The sprite
	 */
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);

	/**
	 * Instantiates a new UnbreakableWall.
	 * @param map
	 * 				The map.
	 * @param position
	 * 				The position of the wall.
	 */
	public UnbreakableWall(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
	
	@Override
	public void replaceByDiamond() {
		
	}
}
