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
	
	public void closeFrame();

	Object getViewFrame();

	void performMenuActions();

	public void selectMenuElementUp();
	
	public void selectMenuElementDown();
}
