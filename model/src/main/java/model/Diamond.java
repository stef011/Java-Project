package model;

public class Diamond extends FallingElement {
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "diamond.gif";
	private static final char sprite_ref = '^';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Pickable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Diamond(int x, int y, Map map) {
		super(x, y, map, sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
