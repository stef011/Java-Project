package view;


import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;


/**
 * The Class View.
 *
 * @author Exars 18-23 Strasbourg grp1
 */
public final class View implements IView, Runnable {


	/** The frame. */
	private final ViewFrame viewFrame;

	/** The model. */
	private IModel model;
	
	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		this.setModel(model);
		SwingUtilities.invokeLater(this);
	}
	
	/**
	 * Instantiates a new view.
	 *
	 */
	public View() {
		this.viewFrame = new ViewFrame();
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.Up;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.Down;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.Right;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.Left;
			case KeyEvent.VK_ESCAPE:
				return ControllerOrder.Escape;
			case KeyEvent.VK_ENTER:
				return ControllerOrder.Enter;
			default:
				return ControllerOrder.Else;
		}
	}

	/**
	 * Prints message.
	 * 
	 * @param message
	 * 			The message
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/**
	 * Makes the Frame visible.
	 *
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	
	/**
	 * Gets the ViewFrame.
	 * @return viewFrame
	 */
	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}
	
	/**
	 * Closes the Frame.
	 */
	public void closeFrame(){
        this.viewFrame.dispose();
    }
	
	/**
	 * Selects the Pause Element according to the index.
	 * @param index
	 * 			The index
	 */
	public void selectNextPauseElement(int index) {
		this.getViewFrame().selectPauseElement(index);
	}
	
	/**
	 * Returns the index of the Pause element currently selected.
	 * @return index
	 */
	public int indexOfPauseSelected() {
		int i = 0;
		while(i < this.getViewFrame().getPauseElements().size()) {
			if(this.getViewFrame().getPauseElements().get(i).isSelected()) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	/**
	 * Gets the size of the ArrayList of the Elements in the Pause menu.
	 * @return size
	 */
	public int sizeOfPauseElements() {
		return this.getViewFrame().getPauseElements().size();
	}
	
	/**
	 * Performs the Action specified for each Pause menu Element selected.
	 * 
	 */
	public void performPauseActions() {
		int i = 0;
		while(i < this.getViewFrame().getPauseElements().size()) {
			this.getViewFrame().getController().performMenuRequest(this.getViewFrame().getPauseElements().get(i).MenuRequest());
			i++;
		}
	}
	
	/**
	 * Selects the Main Menu Element according to the index.
	 * @param index
	 * 			The index
	 */
	public void selectNextMainMenuElement(int index) {
		this.getViewFrame().selectMainMenuElement(index);
	}
	
	/**
	 * Returns the index of the Main menu element currently selected.
	 * 
	 * @return index
	 */
	public int indexOfMainMenuSelected() {
		int i = 0;
		while(i < this.getViewFrame().getMainMenuElements().size()) {
			if(this.getViewFrame().getMainMenuElements().get(i).isSelected()) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	/**
	 * Gets the size of the ArrayList of the Elements in the Main menu.
	 * @return size
	 */
	public int sizeOfMainMenuElements() {
		return this.getViewFrame().getMainMenuElements().size();
	}
	/**
	 * Performs the Action specified for each Main menu Element selected.
	 * 
	 */
	public void performMainMenuActions() {
		int i = 0;
		while(i < this.getViewFrame().getMainMenuElements().size()) {
			this.getViewFrame().getController().performMenuRequest(this.getViewFrame().getMainMenuElements().get(i).MenuRequest());
			i++;
		}
	}
	
	/**
	 * Selects the Menu Element on top of the Menu Element currently selected.
	 */
	public void selectMenuElementUp() {
		switch(this.getModel().getGameState()) {
		case Pause:
			if(this.indexOfPauseSelected()==0) {
				this.selectNextPauseElement(this.sizeOfPauseElements()-1);
			} else {
				this.selectNextPauseElement(this.indexOfPauseSelected()-1);
			}
			break;
		case Menu:
			if(this.indexOfMainMenuSelected()==0) {
				this.selectNextMainMenuElement(this.sizeOfMainMenuElements()-1);
			} else {
				this.selectNextMainMenuElement(this.indexOfMainMenuSelected()-1);
			}
			break;
		default:
			break;
		}
	}
	/**
	 * Selects the Menu Element on bottom of the Menu Element currently selected.
	 * 
	 */
	public void selectMenuElementDown() {
		switch(this.getModel().getGameState()) {
		case Pause:
			if(this.indexOfPauseSelected()==this.sizeOfPauseElements()-1) {
				this.selectNextPauseElement(0);
			} else {
				this.selectNextPauseElement(this.indexOfPauseSelected()+1);
			}
			break;
		case Menu:
			if(this.indexOfMainMenuSelected()==this.sizeOfMainMenuElements()-1) {
				this.selectNextMainMenuElement(0);
			} else {
				this.selectNextMainMenuElement(this.indexOfMainMenuSelected()+1);
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * Performs the Action of the menus, depending on the current GameState.
	 */
	public void performMenuActions() {
		switch(this.getModel().getGameState()) {
		case Pause:
			this.performPauseActions();
			break;
		case Menu:
			this.performMainMenuActions();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Gets the Model.
	 * @return model
	 */
	public IModel getModel() {
		return this.model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	public void setModel(IModel model) {
		this.model=model;
	}

}
