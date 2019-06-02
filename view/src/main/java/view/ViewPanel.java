package view;

import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * The Class ViewPanel.
 *
 * @author Exars 18-23 Strasbourg grp1
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Background image */
	private Image backgr;
	/** The Main Menu Background image */
	private Image mainMenuBackgr;
	
	private static int squareSize = ViewFrame.getSquaresize();
	private static int viewLength = ViewFrame.getViewLength();
	private static int viewWidth = ViewFrame.getViewWidth();

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.loadBackgr();
		this.loadMainMenuBackgr();
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/**
	 * Repaint the Panel when the Observer gets an update.
	 * 
	 * @param Observable arg0, Object arg1
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	/**
	 * Loads the main Menu Background image.
	 */
	public void loadMainMenuBackgr(){
		/**Sets the image path for background. */
		String ImagePath = "/sprites/main_menu_background/main_menu_background.png";
		/**Sets the absolute path for background.*/
		String absolutePath = new File("").getAbsolutePath();
		try {
			this.setMainMenuBackgr(ImageIO.read(new File(absolutePath+ImagePath)));
		}
		catch (Exception e){
			viewFrame.printMessage("Error: File not found \n"+ ImagePath);
		}
	}

	/**
	 * Loads the Background image.
	 */
	public void loadBackgr(){
		String ImagePath = "sprites/settings/background.png";
		try {
			this.setBackgr(ImageIO.read(new File(ImagePath)));
		}
		catch (Exception e){
			viewFrame.printMessage("Error: File not found \n"+ ImagePath);
		}
	}
	
	/**
	 * Gets the Background image.
	 * 
	 * @return backgr
	 */
	public Image getBackgr() {
		return this.backgr;
	}
	
	/**
	 * Sets the Image Background image.
	 * 
	 * @param backgr
	 */
	public void setBackgr(Image backgr) {
		this.backgr = backgr;
	}
	
	/**
	 * Calculates the x on the map where the View musts start generating.
	 * 
	 * @return xStart
	 */
	public int xStart() {
		int xStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getX()-viewLength/2;
		if(xStart<=0) {xStart=0;}
		if(xStart>=this.getViewFrame().getModel().getMap().getLength()-viewLength) {xStart=this.getViewFrame().getModel().getMap().getLength()-viewLength;}
		return xStart;
	}
	
	/**
	 * Calculates the x on the map where the View musts start generating.
	 * 
	 * @return yStart
	 */
	public int yStart() {
		int yStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getY()-viewWidth/2;
		if(yStart<=0) {yStart=0;}
		if(yStart>=this.getViewFrame().getModel().getMap().getWidth()-viewWidth) {yStart=this.getViewFrame().getModel().getMap().getWidth()-viewWidth;}
		return yStart;
	}
	
	/**
	 * Paint the Components of the Panel.
	 * 
	 */
	public void paintComponent(Graphics g){
		switch(this.getViewFrame().getModel().getGameState()) {
		/** Pauses the view g.*/
		case Pause:
			this.pauseView(g);
			break;
		/** Plays the view g.*/
		case Playing:
			this.gameView(g);
			break;
		/** Ends the view g.*/
		case End:
			this.endView(g);
			break;
		/** Shows menu on the view g.*/
		case Menu:
			this.menuView(g);
			break;
		}	
	}
	
	/**
	 * Displays the view of the game.
	 * 
	 * @param g
	 */
	public void gameView(Graphics g) {
		for (int y = this.yStart(); y < this.yStart()+viewWidth; y++){
			for (int x = this.xStart(); x < this.xStart()+viewLength; x++){

				int xAff = x-this.xStart(), yAff = y-this.yStart();
				g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);
				g.drawImage(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y).getSprite().getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);
			}
		}
		this.showGameInfo((Graphics2D) g);
	}
	
	/** 
	 * Shows the in-game info (Diamond counter and the Map currently played)
	 * 
	 * @param g2
	 */
	public void showGameInfo(Graphics2D g2) {
		g2.setFont(new Font("STENCIL", Font.BOLD, 60));
		g2.setColor(new Color(153, 214, 252, 255));
		g2.fillRect(10, ViewFrame.getWindowWidth()-80, this.getViewFrame().getModel().getMap().getPlayer().getScore()*(600/this.getViewFrame().getModel().getMap().getGoal()), 60);
		g2.setStroke(new BasicStroke(6));
		g2.drawRect(10, ViewFrame.getWindowWidth()-80, (600/this.getViewFrame().getModel().getMap().getGoal())*this.getViewFrame().getModel().getMap().getGoal(), 60);
		g2.setColor(new Color(239, 226, 213, 255));
		g2.drawString("DIAMONDS: "+this.getViewFrame().getModel().getMap().getPlayer().getScore()+" / "+this.getViewFrame().getModel().getMap().getGoal(), 20, ViewFrame.getWindowWidth()-30);
		g2.drawString("Map: "+this.getViewFrame().getModel().getMap().getName(), ViewFrame.getWindowLength()-g2.getFontMetrics(g2.getFont()).stringWidth("Map: XXXXXXXXXXX")-30, 70);
	}
	
	/**
	 * Displays the view of the end of the game.
	 * 
	 * @param g
	 */
	public void endView(Graphics g) {
		g.setColor(new Color(100, 100, 100, 200));
		g.fillRect(0, (ViewFrame.getWindowWidth()/2)-140, ViewFrame.getWindowLength(), 280);
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, (ViewFrame.getWindowWidth()/2)-130, ViewFrame.getWindowLength(), 260);
		g.setFont(new Font("STENCIL", Font.BOLD, 240));
		g.setColor(new Color(239, 226, 213, 200));
		g.drawString("Game Over", (ViewFrame.getWindowLength()/2)-g.getFontMetrics(g.getFont()).stringWidth("Game Over")/2, (ViewFrame.getWindowWidth()/2)+80);
	}
	
	/**
	 * Displays the view of the pause.
	 * 
	 * @param g
	 */
	public void pauseView(Graphics g) {
		for (int y = this.yStart(); y < this.yStart()+viewWidth; y++){
			for (int x = this.xStart(); x < this.xStart()+viewLength; x++){
				int xAff = x-this.xStart(), yAff = y-this.yStart();
				g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);
			}
		}
		
		int i = 0;
		while(i < this.getViewFrame().getPauseElements().size()) {
			if(this.getViewFrame().getPauseElements().get(i).isSelected()) {
				this.getViewFrame().getPauseElements().get(i).setAlpha(200);
			} else {
				this.getViewFrame().getPauseElements().get(i).setAlpha(100);
			}
			i++;
		}
		g.setFont(new Font("STENCIL", Font.BOLD, 220));
		g.setColor(new Color(239, 226, 213, 255));
		g.drawString("PAUSE", (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth("PAUSE")/2), 300);
		
		g.setFont(new Font("STENCIL", Font.BOLD, this.getViewFrame().getResume().getSize()));
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getResume().getAlpha()));
		g.drawString(this.getViewFrame().getResume().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getResume().getContent())/2), 550);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getMainMenu().getAlpha()));
		g.drawString(this.getViewFrame().getMainMenu().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getMainMenu().getContent())/2), 750);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getQuitGame().getAlpha()));
		g.drawString(this.getViewFrame().getQuitGame().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getQuitGame().getContent())/2), 950);
	}
	
	/**
	 * Displays the view of the Main Menu.
	 * 
	 * @param g
	 */
	public void menuView(Graphics g) {
		
		//the first drawImage is useless, but the code doesn't work when it's removed, so here it is
		g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), 0, 0, this);
		g.drawImage(this.getMainMenuBackgr().getScaledInstance(ViewFrame.getWindowLength(), ViewFrame.getWindowWidth(), Image.SCALE_DEFAULT), 0, 0, this);
		
		int i = 0;
		while(i < this.getViewFrame().getMainMenuElements().size()) {
			if(this.getViewFrame().getMainMenuElements().get(i).isSelected()) {
				this.getViewFrame().getMainMenuElements().get(i).setAlpha(200);
			} else {
				this.getViewFrame().getMainMenuElements().get(i).setAlpha(100);
			}
			i++;
		}
		
		g.setFont(new Font("STENCIL", Font.BOLD, 220));
		g.setColor(new Color(239, 226, 213, 255));
		g.drawString("BOULDER DASH", (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth("BOULDER DASH")/2), 300);
		g.setFont(new Font("STENCIL", Font.BOLD, 80));
		g.drawString("Strasbourg Exars 18-23 Group 1 Edition", (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth("Strasbourg Exars 18-23 Group 1 Edition")/2), 380);
		
		g.setFont(new Font("STENCIL", Font.BOLD, this.getViewFrame().getResume().getSize()));
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getPlay().getAlpha()));
		g.drawString(this.getViewFrame().getPlay().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getPlay().getContent())/2), 600);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getQuitGame2().getAlpha()));
		g.drawString(this.getViewFrame().getQuitGame2().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getQuitGame2().getContent())/2), 900);
	}
	
	/**
	 * Gets the image of the main menu background.
	 * 
	 * @return this.mainMenuBackgr
	 */
	public Image getMainMenuBackgr() {
		return this.mainMenuBackgr;
	}
	
	/**
	 * Sets the image of the main menu background.
	 * 
	 * @param mainMenuBackgr
	 */
	public void setMainMenuBackgr(Image mainMenuBackgr) {
		this.mainMenuBackgr = mainMenuBackgr;
	}
	
}
