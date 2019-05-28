package model;

public class Rock extends FallingElement {
	private static final String spritePath = "/sprites/settings/";
	private static final String imageName = "rock.png";
	private static final char sprite_ref = 'O';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Pushable;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Rock(int x, int y, Map map) {
		super(x, y, map, sprite, traversableByAlive, traversableByFalling);
		sprite.loadImage();
	}
}
