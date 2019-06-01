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

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
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
	
	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}
	
	public void closeFrame(){
        this.viewFrame.dispose();
    }
	
	
	
	public void selectNextPauseElement(int index) {
		this.getViewFrame().selectPauseElement(index);
	}
	
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
	
	public int sizeOfPauseElements() {
		return this.getViewFrame().getPauseElements().size();
	}

	public void performPauseActions() {
		int i = 0;
		while(i < this.getViewFrame().getPauseElements().size()) {
			this.getViewFrame().getController().performMenuRequest(this.getViewFrame().getPauseElements().get(i).MenuRequest());
			i++;
		}
	}
	
	public void selectNextMainMenuElement(int index) {
		this.getViewFrame().selectMainMenuElement(index);
	}
	
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
	
	public int sizeOfMainMenuElements() {
		return this.getViewFrame().getMainMenuElements().size();
	}
	
	public void performMainMenuActions() {
		int i = 0;
		while(i < this.getViewFrame().getMainMenuElements().size()) {
			this.getViewFrame().getController().performMenuRequest(this.getViewFrame().getMainMenuElements().get(i).MenuRequest());
			i++;
		}
	}
	
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
	
	public IModel getModel() {
		return this.model;
	}
	
	public void setModel(IModel model) {
		this.model=model;
	}

}
