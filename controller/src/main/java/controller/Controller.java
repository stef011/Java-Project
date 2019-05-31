package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

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
     * Control.
	 * @throws InterruptedException 
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void play() throws InterruptedException {
		while(this.getModel().getMap().getPlayer().isAlive() && this.getModel().getMap().getPlayer().getScore()<this.getModel().getMap().getGoal()) {
			Thread.sleep(200);
			int i = 0;
			while(i < this.getModel().getMap().getFallingElements().size()) {
				this.getModel().getMap().getFallingElements().get(i).fall();
				i++;
			}
			int j = 0;
			while(j < this.getModel().getMap().getMobs().size()) {
				this.getModel().getMap().getMobs().get(j).activate();
				j++;
			}
		}
		this.getView().printMessage("Game Over");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}
	
	private IView getView() {
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
	
	private IModel getModel() {
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
				this.getModel().getMap().getPlayer().move("Up");
				break;
			case Down:
				this.getModel().getMap().getPlayer().move("Down");
				break;
			case Left:
				this.getModel().getMap().getPlayer().move("Left");
				break;
			case Right:
				this.getModel().getMap().getPlayer().move("Right");
				break;
			case Else:
				System.out.println("Not a valid key!");
				break;
			default:
				break;
		}
	}

	@Override
	public void control() {
		// TODO Auto-generated method stub
		
	}

}
