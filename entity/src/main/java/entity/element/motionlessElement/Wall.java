package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Wall extends MotionlessElement {
	
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "wall.png";
	private static final char sprite_ref = '#';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Blocking;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Wall(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
