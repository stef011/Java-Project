package contract;



/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	
	/**
	 * Closes the Frame.
	 *
	 */
	public void closeFrame();
	
	/**
	 * Gets the viewFrame.
	 *
	 * @return viewFrame
	 *          the viewFrame
	 */
	Object getViewFrame();
	
	/**
	 * Performs the action of the menu element.
	 */
	void performMenuActions();

	/**
	 * Selects the Menu Element on top of the Menu Element currently selected.
	 */
	public void selectMenuElementUp();

	/**
	 * Selects the Menu Element on bottom of the Menu Element currently selected.
	 * 
	 */
	public void selectMenuElementDown();
}
