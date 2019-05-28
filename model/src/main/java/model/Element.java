package model;

public class Element implements Entity {
	private Sprite sprite;
	private TraversableByAlive traversableByAlive;
	private TraversableByFalling traversableByFalling;

	public Element(Sprite sprite, TraversableByAlive traversableByAlive, TraversableByFalling traversableByFalling) {
		this.setSprite(sprite);
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
		
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public TraversableByAlive getTraversableByAlive() {
		return this.traversableByAlive;
	}

	public void setTraversableByAlive(TraversableByAlive traversableByAlive) {
		this.traversableByAlive = traversableByAlive;
	}

	public TraversableByFalling getTraversableByFalling() {
		return this.traversableByFalling;
	}

	public void setTraversableByFalling(TraversableByFalling traversableByFalling) {
		this.traversableByFalling = traversableByFalling;
	}
	
	public void remove() {
		// Not implemented
	}
	
	public void replaceByDiamond() {
		// Not implemented
	}

}
