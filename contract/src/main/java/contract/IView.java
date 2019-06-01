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

	void performPauseActions();
	
	public int indexOfPauseSelected();
	
	public void selectNextPauseElement(int index);
	
	public int sizeOfPauseElements();
	
	void performMainMenuActions();
	
	public int indexOfMainMenuSelected();
	
	public void selectNextMainMenuElement(int index);
	
	public int sizeOfMainMenuElements();
}
