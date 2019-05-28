package model;

public class EmptySpace extends MotionlessElement {
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "emptySpace.png";
	private static final char sprite_ref = '_';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Traversable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Traversable;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public EmptySpace() {
		super(sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
