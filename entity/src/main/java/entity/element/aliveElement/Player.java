package entity.element.aliveElement;

import entity.Map;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Player extends AliveElement {

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
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Player;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite front = new Sprite(sprite_ref, spritePath, imageFront);
	private static final Sprite frontWalking = new Sprite(sprite_ref, spritePath, imageFrontWalking);
	private static final Sprite back = new Sprite(sprite_ref, spritePath, imageBack);
	private static final Sprite backWalking = new Sprite(sprite_ref, spritePath, imageBackWalking);
	private static final Sprite left = new Sprite(sprite_ref, spritePath, imageLeft);
	private static final Sprite leftWalking = new Sprite(sprite_ref, spritePath, imageLeftWalking);
	private static final Sprite right = new Sprite(sprite_ref, spritePath, imageRight);
	private static final Sprite rightWalking = new Sprite(sprite_ref, spritePath, imageRightWalking);
	
	public Player(Map map, Position position) {
		super(map, position);
		front.loadImage();
		this.setSprite(front);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
}
