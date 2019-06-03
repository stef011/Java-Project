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
	/** the window length. */
	private static int windowLength = 1920;
	/** the window width. */
	private static int windowWidth = 1080;
	/** the view length. */
	private static int viewLength = 16;
	/** the view width. */
	private static int viewWidth = 9;
	/** the square size. */
	private static int squareSize = windowLength/viewLength;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	/** Sets "resume" as a new Resume(). */
	private MenuElement resume = new Resume("RESUME", windowWidth/8, 100);
	/** Sets "mainMenu" as a new MainMenu(). */
	private MenuElement mainMenu = new MainMenu("MAIN MENU", windowWidth/8, 100);
	/** Sets "quitGame" as a new QuitGame(). */
	private MenuElement quitGame = new QuitGame("QUIT GAME", windowWidth/8, 100);
	/** Sets the "ArrayList&lt;MenuElement&gt; pauseElements" as a new ArrayList&lt;MenuElement&gt;(). */
	private ArrayList<MenuElement> pauseElements = new ArrayList<MenuElement>();
	/** Sets the "play" in MenuElement as a new Play(). */
	private MenuElement play = new Play("PLAY", windowWidth/8, 100);
	/** Sets the "quitGame2" in MenuElement as a new QuitGame2(). */
	private MenuElement quitGame2 = new QuitGame("QUIT GAME", windowWidth/8, 100);
	/** Sets the "ArrayList&lt;MenuElement&gt; mainMenuElements" as a new ArrayList&lt;MenuElement&gt;.*/
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
	 */
	public ViewFrame() {
		getPauseElements().add(getResume());
		getPauseElements().add(getMainMenu());
		getPauseElements().add(getQuitGame());
		
		getResume().setSelected(true);
		
		getMainMenuElements().add(getPlay());
		getMainMenuElements().add(getQuitGame2());
		
		getPlay().setSelected(true);
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
		this.setResizable(false);
		this.setTitle("Boulderdash - grp 1 edition");
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(getWindowLength(), getWindowWidth());
		this.setLocationRelativeTo(null);
		this.requestFocus();
		this.setUndecorated(true);
		
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
	 /**
	  * Selects the Pause menu Element according to the index
	  * @param index The index
	  */
	public void selectPauseElement(int index) {
		int i = 0;
		while(i < this.getPauseElements().size()) {
			this.getPauseElements().get(i).setSelected(false);
			i++;
		}
		this.getPauseElements().get(index).setSelected(true);
	}
	/**
	  * Selects the Main menu Element according to the index
	  * @param index The index
	  */
	public void selectMainMenuElement(int index) {
		int i = 0;
		while(i < this.getMainMenuElements().size()) {
			this.getMainMenuElements().get(i).setSelected(false);
			i++;
		}
		this.getMainMenuElements().get(index).setSelected(true);
	}
	
	/**
	 * Gets the size of the squares.
	 * @return squareSize
	 */
	public static int getSquaresize() {
		return squareSize;
	}
	
	/**
	 * Gets the width of the view.
	 * @return viewWidth
	 */
	public static int getViewWidth() {
		return ViewFrame.viewWidth;
	}
	
	/**
	 * Sets the width of the view.
	 * @param viewWidth The width of the view
	 */
	public static void setViewWidth(int viewWidth) {
		ViewFrame.viewWidth = viewWidth;
	}
	
	/**
	 * Gets the length of the view.
	 * @return viewLength
	 */
	public static int getViewLength() {
		return ViewFrame.viewLength;
	}
	
	/**
	 * Sets the length of the view.
	 * @param viewLength The length of the view
	 */
	public static void setViewLength(int viewLength) {
		ViewFrame.viewLength = viewLength;
	}
	
	/**
	 * Gets the length of the window.
	 * @return windowLength
	 */
	public static int getWindowLength() {
		return ViewFrame.windowLength;
	}
	
	/**
	 * Sets the length of the window.
	 * @param windowLength The Length of the Window
	 */
	public static void setWindowLength(int windowLength) {
		ViewFrame.windowLength = windowLength;
	}
	
	/**
	 * Gets the width of the window.
	 * @return windowWidth
	 */
	public static int getWindowWidth() {
		return ViewFrame.windowWidth;
	}
	
	/**
	 * Sets the width of the window.
	 * @param windowWidth The Width of the window
	 */
	public static void setWindowWidth(int windowWidth) {
		ViewFrame.windowWidth = windowWidth;
	}
	
	/**
	 * Gets the ArrayList of the elements of the Pause menu.
	 * @return pauseElements
	 */
	public ArrayList<MenuElement> getPauseElements() {
		return this.pauseElements;
	}
	
	/**
	 * Sets the ArrayList of the elements of the Pause menu.
	 * @param pauseElements The pause element
	 */
	public void setPauseElements(ArrayList<MenuElement> pauseElements) {
		this.pauseElements = pauseElements;
	}
	
	/**
	 * Gets the ArrayList of the elements of the Main menu.
	 * @return mainMenuElements
	 */
	public ArrayList<MenuElement> getMainMenuElements() {
		return this.mainMenuElements;
	}
	
	/**
	 * Sets the ArrayList of the elements of the Main menu.
	 * @param mainMenuElements The main menu Element
	 */
	public void setMainMenuElements(ArrayList<MenuElement> mainMenuElements) {
		this.mainMenuElements = mainMenuElements;
	}
	
	/**
	 * Gets the Menu element Resume.
	 * @return resume
	 */
	public MenuElement getResume() {
		return this.resume;
	}
	
	/**
	 * Sets the Menu element Resume.
	 * @param resume Resume
	 */
	public void setResume(MenuElement resume) {
		this.resume = resume;
	}

	/**
	 * Gets the Menu element QuitGame.
	 * @return quitGame
	 */
	public MenuElement getQuitGame() {
		return this.quitGame;
	}

	/**
	 * Sets the Menu element QuitGame.
	 * @param quitGame Quit the game
	 */
	public void setQuitGame(MenuElement quitGame) {
		this.quitGame = quitGame;
	}

	/**
	 * Gets the Menu element MainMenu.
	 * @return mainMenu
	 */
	public MenuElement getMainMenu() {
		return this.mainMenu;
	}

	/**
	 * Sets the Menu element MainMenu.
	 * @param mainMenu The mainMenu
	 */
	public void setMainMenu(MenuElement mainMenu) {
		this.mainMenu = mainMenu;
	}

	/**
	 * Gets the Menu element Play.
	 * @return play
	 */
	public MenuElement getPlay() {
		return this.play;
	}

	/**
	 * Sets the Menu element Play.
	 * @param play Play
	 */
	public void setPlay(MenuElement play) {
		this.play = play;
	}

	/**
	 * Gets the Menu element QuitGame2.
	 * @return quitGame2
	 */
	public MenuElement getQuitGame2() {
		return this.quitGame2;
	}


}
