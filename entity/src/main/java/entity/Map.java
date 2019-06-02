package entity;

import java.util.ArrayList;

import entity.element.Element;
import entity.element.Position;
import entity.element.aliveElement.AliveElement;
import entity.element.aliveElement.Mob;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.ElementFactory;

/**
 * <h1>The map Class</h1>
 * Contains all the elements.
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Map extends Entity {
	/**
	 * The mapId
	 */
	private int id;
	/**
	 * The name of the map
	 */
	private String name;
	/**
	 * The length of the map, to manage different sizes of map.
	 */
	private int length;
	/**
	 * The width of the map to manage different sizes of map.
	 */
	private int width;
	/**
	 * The number of Diamonds the player need to pick.
	 */
	private int goal;
	/**
	 * The table of elements on the map.
	 */
	private Element onTheMap[][];
	/**
	 * The player
	 */
	private Player player;
	/**
	 * The ArrayList of falling elements.
	 */
	private ArrayList<FallingElement> fallingElements = new ArrayList<FallingElement>();
	/**
	 * The ArrayList of mobs
	 */
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	public Map() {
		
	}

	/**
	 * Instantiates a new map.
	 * @param id The id of the map {@see #id}
	 * @param name The name of the map {@see #name}
	 * @param length The length.
	 * @param width The width.
	 * @param goal The goal {@see #goal}
	 */
	public Map(int id, String name, int length, int width, int goal) {
		this.setId(id);
		this.setName(name);
		this.setLength(length);
		this.setWidth(width);
		this.setGoal(goal);
	}

	/**
	 * Instantiates a new map.
	 * @param map The map
	 * @param elementSpriteRef The table of elements in the map.
	 */
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
					this.setPlayer(ElementFactory.createPlayer(this, new Position(x, y)));
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

	/**
	 * Gets the id of the map
	 * @return The mapId
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the Id of the map.
	 * @param id The id of the map.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the map
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the map
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the length of the map
	 * @return The length.
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Sets the length of the map
	 * @param length The length.
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Gets the width of the map.
	 * @return The width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the Width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the goal
	 * @return The goal
	 */
	public int getGoal() {
		return this.goal;
	}

	/**
	 * Sets the goal
	 * @param goal The goal
	 */
	public void setGoal(int goal) {
		this.goal = goal;
	}

	/**
	 * Get the table of elements on the map.
	 * @param x The x {@link Position}
	 * @param y The y {@link Position}
	 * @return The Table of elements on the map.
	 */
	public Element getOnTheMapXY(int x, int y) {
		return onTheMap[x][y];
	}

	/**
	 * Sets the table of elements.
	 * @param x The x {@link Position}
	 * @param y The y {@link Position}
	 * @param element The {@link Element}
	 */
	public void setOnTheMapXY(int x, int y, Element element) {
		this.onTheMap[x][y] = element;
	}

	/**
	 * Gets the player object
	 * @return player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Sets the player object
	 * @param player The player.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Get the arrayList of fallingElements.
	 * @return The arrayList of the falling elements
	 */
	public ArrayList<FallingElement> getFallingElements() {
		return this.fallingElements;
	}

	/**
	 * Get the mobs on the map
	 * @return The arrayList of the mobs on the map.
	 */
	public ArrayList<Mob> getMobs() {
		return this.mobs;
	}

	/**
	 * Gets the alive elements on the map
	 * @param x {@link Position}
	 * @param y {@link Position}
	 * @return A table of alive elements on the map.
	 */
	public AliveElement getAliveOnTheMapXY(int x, int y) {
		return (AliveElement) onTheMap[x][y];
	}

}
