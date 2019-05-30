package entity.element;

import entity.Entity;
import entity.Map;

public class Element extends Entity {
	private Sprite sprite;
	private Position position;
	private Map map;
	private TraversableByAlive traversableByAlive;
	private TraversableByFalling traversableByFalling;
	
	public Element(Map map, Position position) {
		this.setPosition(position);
		this.setMap(map);
	}
	
	
	public Element() {

	}
	
	public void replaceByEmptySpace() {
		this.getMap().setOnTheMapXY(this.getPosition().getX(), this.getPosition().getY(), ElementFactory.createEmptySpace(this.getMap(), this.getPosition()));
	}


	public Sprite getSprite() {
		return this.sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public Position getPosition() {
		return this.position;
	}
	public void setPosition(Position position) {
		this.position = position;
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
	public Map getMap() {
		return this.map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
}
