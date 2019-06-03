package contract;

import java.util.Observable;

import entity.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public interface IModel {

	/**
	 * Gets the Map
	 *
	 * @return The Map entity.
	 */
	Map getMap();

	/**
	 * Load the map
	 * @param name The name of the map.
	 */
	void loadMap(String name);
	
	/**
	 * Load the sprite reference of the element.
	 *
	 * @param id_map
	 *          the map id
	 * @param x
	 * 			the x
	 * @param y
	 *          the y
	 * @return A char (the spriteRef)
	 */
	char loadElementSpriteRef(int id_map, int x, int y);
	
	/**
	 * Sets the game state.
	 *
	 * @param gameState
	 *          the gameState
	 */
	public void setGameState(GameState gameState);
	
	/**
	 * gets the game state.
	 * @return the game state
	 */
	public GameState getGameState();
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
