package model;

public class Wall extends MotionlessElement {
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "wall.png";
	private static final char sprite_ref = '#';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Blocking;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Wall() {
		super(sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
