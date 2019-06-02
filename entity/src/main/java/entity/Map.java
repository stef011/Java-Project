package entity;

import java.util.ArrayList;

import entity.element.Element;
import entity.element.Position;
import entity.element.aliveElement.AliveElement;
import entity.element.aliveElement.Mob;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.ElementFactory;


public class Map extends Entity {
	
	private int id;
	private String name;
	private int length;
	private int width;
	private int goal;
	private Element onTheMap[][];
	private Player player;
	private ArrayList<FallingElement> fallingElements = new ArrayList<FallingElement>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
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
				if(x==0 || y==0 || x==this.getLength()-1 || y==this.getWidth()-1) {
					this.setOnTheMapXY(x, y, ElementFactory.createUnbreakableWall(this, new Position(x, y)));
				
				} else if(elementSpriteRef[x][y] == '@') {
					player = ElementFactory.createPlayer(this, new Position(x, y));
					this.setOnTheMapXY(x, y, this.getPlayer());
					
				} else if(elementSpriteRef[x][y] == 'O') {
					FallingElement fallingElement = ElementFactory.createRock(this, new Position(x, y));
					fallingElements.add(fallingElement);
					this.setOnTheMapXY(x, y, fallingElements.get(fallingElements.lastIndexOf(fallingElement)));
					
				} else if(elementSpriteRef[x][y] == '^') {
					FallingElement fallingElement = ElementFactory.createDiamond(this, new Position(x, y));
					fallingElements.add(fallingElement);
					this.setOnTheMapXY(x, y, fallingElements.get(fallingElements.lastIndexOf(fallingElement)));
					
				} else if(elementSpriteRef[x][y] == 'M') {
					Mob mob = ElementFactory.createMob(this, new Position(x, y));
					mobs.add(mob);
					this.setOnTheMapXY(x, y, mobs.get(mobs.lastIndexOf(mob)));
					
				} else {
					this.setOnTheMapXY(x, y, ElementFactory.selectElementFromSpriteRef(elementSpriteRef[x][y], this, new Position(x, y)));
				}
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

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<FallingElement> getFallingElements() {
		return this.fallingElements;
	}

	public void setFallingElements(ArrayList<FallingElement> fallingElements) {
		this.fallingElements = fallingElements;
	}

	public ArrayList<Mob> getMobs() {
		return this.mobs;
	}

	public void setMobs(ArrayList<Mob> mobs) {
		this.mobs = mobs;
	}
	
	public AliveElement getAliveOnTheMapXY(int x, int y) {
		return (AliveElement) onTheMap[x][y];
	}

}
