/**
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
package main;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Exars 18-23 Strasbourg grp1
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws InterruptedException Throws the exception if the main is interrupted
     */
    public static void main(final String[] args) throws InterruptedException {
    	
    	/*
    	 You can enter the name of the map you want to play as a parameter of the model.
    	 Maps available:
    	 "Cellar"
    	 "Catacombs"
    	 "Cave"
    	 "The Unknown"
    	 "China Goal"
    	 */

		/**
		 * The model
		 */
		final Model model = new Model("Cave");
		/**
		 * The view
		 */
        final View view = new View(model);
		/**
		 * The controller.
		 */
		final Controller controller = new Controller(view, model);
		/**
		 * Sets the controller
		 */
        view.setController(controller);

		/**
		 * Plays the game
		 */
        controller.play();
    }
}
