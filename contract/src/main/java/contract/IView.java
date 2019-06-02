package contract;



/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
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
