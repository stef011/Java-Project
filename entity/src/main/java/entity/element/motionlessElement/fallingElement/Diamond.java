package entity.element.motionlessElement.fallingElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Diamond extends FallingElement {
	
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "diamond.gif";
	private static final char sprite_ref = '^';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Pickable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Diamond(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
