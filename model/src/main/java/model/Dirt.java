package model;

public class Dirt extends MotionlessElement {
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "dirt.png";
	private static final char sprite_ref = 'X';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Breakable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Blocking;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Dirt() {
		super(sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
