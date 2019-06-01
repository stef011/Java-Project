package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import view.menuElement.MainMenu;
import view.menuElement.MenuElement;
import view.menuElement.Play;
import view.menuElement.QuitGame;
import view.menuElement.Resume;

/**
 * The Class ViewFrame.
 *
 * @author Exars 18-23 Strasbourg grp1
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;

	/** The controller. */
	private IController controller;
	
	private static int windowLength = 1280;
	private static int windowWidth = 720;
	private static int viewLength = 16;
	private static int viewWidth = 9;
	private static int squareSize = getWindowLength()/viewLength;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	
	private MenuElement resume = new Resume("RESUME", 80, 100);
	private MenuElement mainMenu = new MainMenu("MAIN MENU", 80, 100);
	private MenuElement quitGame = new QuitGame("QUIT GAME", 80, 100);
	private ArrayList<MenuElement> pauseElements = new ArrayList<MenuElement>();
	
	private MenuElement play = new Play("PLAY", 80, 100);
	private MenuElement quitGame2 = new QuitGame("QUIT GAME", 80, 100);
	private ArrayList<MenuElement> mainMenuElements = new ArrayList<MenuElement>();
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
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

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setTitle("Boulderdash - grp 1 edition");
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(getWindowLength(), getWindowWidth());
		this.setLocationRelativeTo(null);
		
		getPauseElements().add(getResume());
		getPauseElements().add(getMainMenu());
		getPauseElements().add(getQuitGame());
		
		getResume().setSelected(true);
		
		getMainMenuElements().add(getPlay());
		getMainMenuElements().add(getQuitGame2());
		
		getPlay().setSelected(true);
	}
	
	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
	
	public void selectPauseElement(int index) {
		int i = 0;
		while(i < this.getPauseElements().size()) {
			this.getPauseElements().get(i).setSelected(false);
			i++;
		}
		this.getPauseElements().get(index).setSelected(true);
	}
	
	public void selectMainMenuElement(int index) {
		int i = 0;
		while(i < this.getMainMenuElements().size()) {
			this.getMainMenuElements().get(i).setSelected(false);
			i++;
		}
		this.getMainMenuElements().get(index).setSelected(true);
	}

	public static int getSquaresize() {
		return squareSize;
	}

	public static int getViewWidth() {
		return ViewFrame.viewWidth;
	}

	public static void setViewWidth(int viewWidth) {
		ViewFrame.viewWidth = viewWidth;
	}
	
	public static int getViewLength() {
		return ViewFrame.viewLength;
	}

	public static void setViewLength(int viewLength) {
		ViewFrame.viewLength = viewLength;
	}

	public static int getWindowLength() {
		return ViewFrame.windowLength;
	}

	public static void setWindowLength(int windowLength) {
		ViewFrame.windowLength = windowLength;
	}

	public static int getWindowWidth() {
		return ViewFrame.windowWidth;
	}

	public static void setWindowWidth(int windowWidth) {
		ViewFrame.windowWidth = windowWidth;
	}

	public ArrayList<MenuElement> getPauseElements() {
		return this.pauseElements;
	}

	public void setPauseElements(ArrayList<MenuElement> pauseElements) {
		this.pauseElements = pauseElements;
	}
	
	public ArrayList<MenuElement> getMainMenuElements() {
		return this.mainMenuElements;
	}

	public void setMainMenuElements(ArrayList<MenuElement> mainMenuElements) {
		this.mainMenuElements = mainMenuElements;
	}

	public MenuElement getResume() {
		return this.resume;
	}

	public void setResume(MenuElement resume) {
		this.resume = resume;
	}

	public MenuElement getQuitGame() {
		return this.quitGame;
	}

	public void setQuitGame(MenuElement quitGame) {
		this.quitGame = quitGame;
	}

	public MenuElement getMainMenu() {
		return this.mainMenu;
	}

	public void setMainMenu(MenuElement mainMenu) {
		this.mainMenu = mainMenu;
	}

	public MenuElement getPlay() {
		return this.play;
	}

	public void setPlay(MenuElement play) {
		this.play = play;
	}

	public MenuElement getQuitGame2() {
		return this.quitGame2;
	}

	public void setQuitGame2(MenuElement quitGame2) {
		this.quitGame2 = quitGame2;
	}
}
