package entity.element.aliveElement;

import entity.Map;
import entity.element.Element;
import entity.element.Position;

public class AliveElement extends Element {
	
	public AliveElement(Map map, Position position) {
		super(map, position);
	}
	
	public void moveUp() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveDown() {
		this.replaceByEmptySpace();
		this.getPosition().setY(this.getPosition().getY()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveLeft() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()-1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
	
	public void moveRight() {
		this.replaceByEmptySpace();
		this.getPosition().setX(this.getPosition().getX()+1);
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), this);
	}
}
