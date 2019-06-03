package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public interface IController {

	/**
	 * Play.
	 */
	public void play();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
	
	/**
	 * Performs The menu request
	 *
	 * @param menuActions
	 *          the action performed by the menu element.
	 */
	public void performMenuRequest(MenuActions menuActions);
}
