package entity.element.aliveElement;

import entity.element.Direction;
import entity.Map;
import entity.element.Element;
import entity.element.Position;

public class AliveElement extends Element {
	
	private boolean alive;
	
	public AliveElement(Map map, Position position) {
		super(map, position);
		this.setAlive(true);
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
	}
	
	@Override
	public void moveRight() {
		super.moveRight();
	}

	@Override
	public void move(Direction direction) {
		super.move(direction);
	}
	
	public void die() {
		this.setAlive(false);
		this.replaceByEmptySpace();
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
