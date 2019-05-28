package contract;

import java.util.Observable;

import model.Map;

/**
 * The Interface IModel.
 *
 * @author Etienne CARRE
 */
public interface IModel {

	/**
	 * Gets the map.
	 * 
	 * @return the map entity
	 */
	Map getMap();

	/**
	 * Load the map information.
	 *
	 * @param name
	 *          the name
	 */
	void loadMap(String name);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
