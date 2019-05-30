package entity.element;

import entity.Map;
import entity.element.aliveElement.Mob;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.Dirt;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.Wall;
import entity.element.motionlessElement.fallingElement.Diamond;
import entity.element.motionlessElement.fallingElement.Rock;

public abstract class ElementFactory {
	
	public static Element createDirt(Map map, Position position) {
		return new Dirt(map, position);
	}
	
	public static Element createWall(Map map, Position position) {
		return new Wall(map, position);
	}
	
	public static Element createEmptySpace(Map map, Position position) {
		return new EmptySpace(map, position);
	}
	
	public static Diamond createDiamond(Map map, Position position) {
		return new Diamond(map, position);
	}
	
	public static Rock createRock(Map map, Position position) {
		return new Rock(map, position);
	}
	
	public static Player createPlayer(Map map, Position position) {
		return new Player(map, position);
	}
	
	public static Element createMob(Map map, Position position) {
		return new Mob(map, position);
	}
	
	public static Element selectElementFromSpriteRef(char sprite_ref, Map map, Position position) {
		switch(sprite_ref) {
			case '#':
				return createWall(map, position);
			case '@':
				return createPlayer(map, position);
			case 'M':
				return createMob(map, position);
			case 'O':
				return createRock(map, position);
			case 'X':
				return createDirt(map, position);
			case '^':
				return createDiamond(map, position);
			default:
				return createEmptySpace(map, position);
		}
	}
}
