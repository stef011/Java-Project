package controller;

import contract.ControllerOrder;
import contract.GameState;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.MenuActions;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Play the game.
	 * @throws InterruptedException 
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#play()
	 */
	public void play() {
		this.getModel().setGameState(GameState.Menu);
		while(this.getModel().getGameState()==GameState.Menu) {	
		}
		
		this.getModel().setGameState(GameState.Playing);
		while(this.getModel().getMap().getPlayer().isAlive() && this.getModel().getMap().getPlayer().getScore()<this.getModel().getMap().getGoal()) {

			try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
			int i = 0;
			while(i < this.getModel().getMap().getFallingElements().size()) {
				this.getModel().getMap().getFallingElements().get(i).fall();
				i++;
			}
			int j = 0;
			while(j < this.getModel().getMap().getMobs().size()) {
				this.getModel().getMap().getMobs().get(j).moveMobs();
				j++;
			}
			while(this.getModel().getGameState()==GameState.Pause) {	
			}
		}
		this.getModel().setGameState(GameState.End);
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		System.exit(0);
		this.getView().closeFrame();
	}

	/**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
	private void setView(final IView view) {
		this.view = view;
	}
	
	public IView getView() {
		return this.view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public IModel getModel() {
		return this.model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Up:
				this.movePlayer("Up");
				this.selectNextMenuElement();
				break;
			case Down:
				this.movePlayer("Down");
				this.selectPreviousMenuElement();
				break;
			case Left:
				this.movePlayer("Left");
				break;
			case Right:
				this.movePlayer("Right");
				break;
			case Escape:
				switch(this.getModel().getGameState()) {
				case Playing:
					this.getModel().setGameState(GameState.Pause);
					break;
				case End:
					this.getModel().setGameState(GameState.Menu);
					break;
				case Pause:
					this.getModel().setGameState(GameState.Playing);
					break;
				default:
					break;
				}
				break;
			case Enter:
				switch(this.getModel().getGameState()) {
				case Pause:
				case Menu:
					this.getView().performMenuActions();
					break;
				default:
					break;
				}
				break;
			default:
				break;
		}
	}
	
	/**
	 * Moves the player to the direction given in parameter.
	 * @param direction
	 * 			The direction where the player have to move
	 */
	public void movePlayer(String direction) {
		if(this.getModel().getGameState()==GameState.Playing) {
			this.getModel().getMap().getPlayer().move(direction);
		}
	}
	
	/**
	 * Selects the next Menu Element.
	 */
	public void selectNextMenuElement() {
		if(this.getModel().getGameState()==GameState.Pause || this.getModel().getGameState()==GameState.Menu) {
			this.getView().selectMenuElementUp();
		}
	}
	
	/**
	 * Selects the previous Menu Element.
	 */
	public void selectPreviousMenuElement() {
		if(this.getModel().getGameState()==GameState.Pause || this.getModel().getGameState()==GameState.Menu) {
			this.getView().selectMenuElementDown();
		}
	}

	/**
	 * Performing the menu requests
	 * @param menuActions
	 * 			Actions of the menu.
	 */
	public void performMenuRequest(MenuActions menuActions){
		if(this.getModel().getGameState() == GameState.Menu || this.getModel().getGameState() == GameState.Pause) {
			switch(menuActions) {
			case Quitgame:
				this.getModel().getMap().getPlayer().die();
				System.exit(0);
				this.getView().closeFrame();
				break;
			case Resume:
				this.getModel().setGameState(GameState.Playing);
				break;
			case Mainmenu:
				this.getModel().setGameState(GameState.Menu);
				break;
			case Play:
				this.getModel().setGameState(GameState.Playing);
			default:
				break;
			}
		}
	}
}
