package entity;

public class Map extends Entity {
	private int id;
	private String name;
	private int length;
	private int width;
	private int goal;
	private Element elements[][];
	
	public Map() {
		
	}
	
	public Map(int id, String name, int length, int width, int goal) {
		this.setId(id);
		this.setName(name);
		this.setLength(length);
		this.setWidth(width);
		this.setGoal(goal);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
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
}
