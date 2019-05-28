package model;

import java.util.Observable;

public class Map extends Observable implements Entity {
	
	private int id;
	private String name;
	private int length;
	private int width;
	private int goal;
	private Element[][] onTheMap;
	
	
	
	public Map(int id, String name, int length, int width, int goal) {
		this.setId(id);
		this.setName(name);
		this.setLength(length);
		this.setWidth(width);
		this.setGoal(goal);
		this.onTheMap = new Element[this.getLength()][this.getWidth()];
		
	}
	public Map() {
		
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMobileElementUpdated() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public Observable getObservable() {
		return this;
	}
	
	public void setOnTheMap(Element element, int x, int y) {
		this.onTheMap[x][y] = element;
	}
	
	public Element getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}
	
	
}
