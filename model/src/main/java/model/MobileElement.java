package model;

public class MobileElement extends Element {

	private int x;
	private int y;
	private Map map;
	
	public MobileElement(int x, int y, Map map, Sprite sprite, TraversableByAlive traversableByAlive, TraversableByFalling traversableByFalling) {
		super(sprite, traversableByAlive, traversableByFalling);
		this.setX(x);
		this.setY(y);
		this.setMap(map);
	}
	
	public void moveUp() {
		this.setY(this.getY()-16);
		this.setHasMoved();
	}
	
	public void moveDown() {
		this.setY(this.getY()+16);
		this.setHasMoved();
	}
	
	public void moveLeft() {
		this.setX(this.getX()-16);
		this.setHasMoved();
	}
	
	public void moveRight() {
		this.setX(this.getX()+16);
		this.setHasMoved();
	}
	
	public void doNothing() {
		this.setHasMoved();
	}
	
	public void setHasMoved() {
		this.getMap().setMobileElementUpdated();
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
