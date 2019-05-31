package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class EmptySpace extends MotionlessElement {
	
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "emptySpace.png";
	private static final char sprite_ref = '_';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Traversable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Traversable;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public EmptySpace(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
