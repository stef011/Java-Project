package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import sun.awt.im.InputMethodManager;

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


}
