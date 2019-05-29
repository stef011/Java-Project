package entity.element.motionlessElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Dirt extends MotionlessElement {
	
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "dirt.png";
	private static final char sprite_ref = 'X';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Breakable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Blocking;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Dirt(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
