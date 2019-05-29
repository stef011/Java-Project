package entity.element.aliveElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Mob extends AliveElement {
	
	private static final String spritePath = "/sprites/mobs/";
	private static final String imageName = "mob.gif";
	private static final char sprite_ref = 'M';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Mob;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Mob(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
