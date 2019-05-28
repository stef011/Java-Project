package model;

public class AliveElement extends MobileElement {
	private boolean alive;
	
	public AliveElement(int x, int y, Map map, Sprite sprite, TraversableByAlive traversableByAlive, TraversableByFalling traversableByFalling) {
		super(x, y, map, sprite, traversableByAlive, traversableByFalling);
		this.setAlive(true);
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void die() {
		this.setAlive(false);
	}
}
