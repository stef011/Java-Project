package model;

public class Player extends AliveElement {
	private int score = 0;
	private static final String spritePath = "/sprites/player/";
	private static final String imageFront = "front.png";
	private static final String imageFrontWalking = "frontWalking.gif";
	private static final String imageBack = "back.png";
	private static final String imageBackWalking = "backWalking.gif";
	private static final String imageLeft = "left.png";
	private static final String imageLeftWalking = "leftWalking.gif";
	private static final String imageRight = "right.png";
	private static final String imageRightWalking = "rightWalking.gif";
	
	private static final char sprite_ref = '@';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Alive;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Slippery;
	
	private static final Sprite front = new Sprite(sprite_ref, spritePath, imageFront);
	private static final Sprite frontWalking = new Sprite(sprite_ref, spritePath, imageFrontWalking);
	private static final Sprite back = new Sprite(sprite_ref, spritePath, imageBack);
	private static final Sprite backtWalking = new Sprite(sprite_ref, spritePath, imageBackWalking);
	private static final Sprite left = new Sprite(sprite_ref, spritePath, imageLeft);
	private static final Sprite leftWalking = new Sprite(sprite_ref, spritePath, imageLeftWalking);
	private static final Sprite right = new Sprite(sprite_ref, spritePath, imageRight);
	private static final Sprite rightWalking = new Sprite(sprite_ref, spritePath, imageRightWalking);
	
	public Player(int x, int y, Map map) {
		super(x, y, map, front, traversableByAlive, traversableByFalling);
		this.setScore(0);
		front.loadImage();
		frontWalking.loadImage();
		back.loadImage();
		backtWalking.loadImage();
		left.loadImage();
		leftWalking.loadImage();
		right.loadImage();
		rightWalking.loadImage();
	}
	
	
	
	public void push() {
		
	}
	
	public void pick() {
		
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
