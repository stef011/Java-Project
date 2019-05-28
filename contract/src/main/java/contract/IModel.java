package contract;

import java.util.Observable;

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

	IMap getMap();
}
