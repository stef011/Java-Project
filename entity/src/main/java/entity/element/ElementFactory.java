package entity.element;

import entity.Map;

import entity.element.aliveElement.Mob;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.Dirt;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.UnbreakableWall;
import entity.element.motionlessElement.Wall;
import entity.element.motionlessElement.fallingElement.Diamond;
import entity.element.motionlessElement.fallingElement.Rock;

/**
 * <h1>The element factory</h1>
 * Creates the elements in the map.
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public abstract class ElementFactory {
	/**
	 * Creates a dirt Block
	 * @param map The map
	 * @param position The position of the dirt
	 * @return The {@link Dirt} {@link Element}.
	 */
	public static Element createDirt(Map map, Position position) {
		return new Dirt(map, position);
	}

	/**
	 * Creates a Wall
	 * @param map The map
	 * @param position The position of the wall
	 * @return The {@link Wall} {@link Element}
	 */
	public static Element createWall(Map map, Position position) {
		return new Wall(map, position);
	}

	/**
	 * Creates an empty space.
	 * @param map The map
	 * @param position The position of the empty space
	 * @return The {@link EmptySpace} {@link Element}
 	 */
	public static Element createEmptySpace(Map map, Position position) {
		return new EmptySpace(map, position);
	}

	/**
	 * Creates a diamond
	 * @param map The map.
	 * @param position The position of the diamond.
	 * @return The {@link Diamond} {@link Element}
	 */
	public static Diamond createDiamond(Map map, Position position) {
		return new Diamond(map, position);
	}

	/**
	 * Creates a Rock
	 * @param map The map
	 * @param position The position of the Rock
	 * @return The {@link Rock} {@link Element}
	 */
	public static Rock createRock(Map map, Position position) {
		return new Rock(map, position);
	}

	/**
	 * Creates a player Element
	 * @param map The map
	 * @param position The position of the Player.
	 * @return The {@link Player} {@link Element}
	 */
	public static Player createPlayer(Map map, Position position) {
		return new Player(map, position);
	}

	/**
	 * Creates a Mob.
	 * @param map The map.
	 * @param position The position of the Mob.
	 * @return The {@link Mob} {@link Element}
	 */
	public static Mob createMob(Map map, Position position) {
		return new Mob(map, position);
	}

	/**
	 * Creates an Unbreakable Wall
	 * @param map The map.
	 * @param position The position.
	 * @return The {@link UnbreakableWall} {@link Element}
	 */
	public static Element createUnbreakableWall(Map map, Position position) {
		return new UnbreakableWall(map, position);
	}

	/**
	 * Creates an element by a Sprite reference and call the appropriate method of the {@link ElementFactory} Class.
	 * @param sprite_ref The sprite reference.
	 * @param map The map.
	 * @param position The position.
	 * @return The {@link Element}
	 */
	public static Element selectElementFromSpriteRef(char sprite_ref, Map map, Position position) {
		switch(sprite_ref) {
			case '#':
				return createWall(map, position);
			case 'X':
				return createDirt(map, position);
			default:
				return createEmptySpace(map, position);
		}
	}
}
