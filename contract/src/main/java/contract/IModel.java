package contract;

import java.util.Observable;

import entity.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	Map getMap();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(String name);
	
	/**
	 * Load the sprite reference of the element.
	 *
	 * @param id_map
	 *          the map id
	 * @param x
	 *          the x
	 * @param y
	 *          the y
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
