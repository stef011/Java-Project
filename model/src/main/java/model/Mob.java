package model;

public class Mob extends AliveElement {
	private static final String spritePath = "/sprites/mobs/";
	private static final String imageName = "mob.gif";
	private static final char sprite_ref = 'M';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Alive;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Mob(int x, int y, Map map) {
		super(x, y, map, sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
