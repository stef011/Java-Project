package entity;

import entity.element.Element;
import entity.element.Position;
import entity.element.ElementFactory;


public class Map extends Entity {
	
	private int id;
	private String name;
	private int length;
	private int width;
	private int goal;
	private Element onTheMap[][];
	
	public Map() {
		
	}
	
	public Map(int id, String name, int length, int width, int goal) {
		this.setId(id);
		this.setName(name);
		this.setLength(length);
		this.setWidth(width);
		this.setGoal(goal);
	}
	
	public Map(Map map, char elementSpriteRef[][]) {
		this.setId(map.getId());
		this.setName(map.getName());
		this.setLength(map.getLength());
		this.setWidth(map.getWidth());
		this.setGoal(map.getGoal());
		
		onTheMap = new Element[this.getLength()][this.getWidth()];
		for(int y=0; y<this.getWidth(); y++) {
			for(int x=0; x<this.getLength(); x++) {
				this.setOnTheMapXY(x, y, ElementFactory.selectElementFromSpriteRef(elementSpriteRef[x][y], this, new Position(x, y)));
			}
		}
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getGoal() {
		return this.goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public Element getOnTheMapXY(int x, int y) {
		return onTheMap[x][y];
	}

	public void setOnTheMapXY(int x, int y, Element element) {
		this.onTheMap[x][y] = element;
	}

}
