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

	/** The Image*/
	private Image backgr;
	
	private static final int squareSize = ViewFrame.getSquaresize();
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/**
	 * load the Background image
	 */
	public void loadBackgr(){
		String ImagePath = "./sprites/settings/background.png";
		try {
			this.setBackgr(ImageIO.read(new File("D://Documents/eXia/Prosit/Bloc 5/Projet_UMLJava/Java-Project"+ImagePath)));
		}
		catch (Exception e){
			viewFrame.printMessage("Error: File not found \n"+ ImagePath);
		}
	}
	
	public Image getBackgr() {
		return this.backgr;
	}
	
	public void setBackgr(Image backgr) {
		this.backgr = backgr;
	}
	
	public int xStart() {
		int xStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getX()-viewLength/2;
		if(xStart<=0) {xStart=0;}
		if(xStart>=this.getViewFrame().getModel().getMap().getLength()-viewLength) {xStart=this.getViewFrame().getModel().getMap().getLength()-viewLength;}
		return xStart;
	}
	
	public int yStart() {
		int yStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getY()-viewWidth/2;
		if(yStart<=0) {yStart=0;}
		if(yStart>=this.getViewFrame().getModel().getMap().getWidth()-viewWidth) {yStart=this.getViewFrame().getModel().getMap().getWidth()-viewWidth;}
		return yStart;
	}

	public void paintComponent(Graphics g){
		switch(this.getViewFrame().getModel().getGameState()) {
		case Pause:
			this.pauseView(g);
			break;
		case Playing:
			this.gameView(g);
			break;
		case End:
			this.endView(g);
			break;
		case Menu:
			this.menuView(g);
			break;
		}	
	}
	
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
	
	public void showGameInfo(Graphics2D g2) {
		g2.setFont(new Font("STENCIL", Font.BOLD, 30));
		g2.setColor(new Color(153, 214, 252, 255));
		g2.fillRect(10, 645, this.getViewFrame().getModel().getMap().getPlayer().getScore()*(350/this.getViewFrame().getModel().getMap().getGoal()), 30);
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(10, 645, (350/this.getViewFrame().getModel().getMap().getGoal())*this.getViewFrame().getModel().getMap().getGoal(), 30);
		g2.setColor(new Color(239, 226, 213, 255));
		g2.drawString("DIAMONDS: "+this.getViewFrame().getModel().getMap().getPlayer().getScore()+" / "+this.getViewFrame().getModel().getMap().getGoal(), 20, 670);
	}
	
	public void endView(Graphics g) {
		g.setColor(new Color(100, 100, 100, 200));
		g.fillRect(0, (ViewFrame.getWindowWidth()/2)-90, ViewFrame.getWindowLength(), 115);
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, (ViewFrame.getWindowWidth()/2)-80, ViewFrame.getWindowLength(), 95);
		g.setFont(new Font("STENCIL", Font.BOLD, 100));
		g.setColor(new Color(239, 226, 213, 200));
		g.drawString("Game Over", (ViewFrame.getWindowLength()/2)-300, (ViewFrame.getWindowWidth()/2));

	}
	
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
		
		g.setFont(new Font("STENCIL", Font.BOLD, 100));
		g.setColor(new Color(239, 226, 213, 255));
		g.drawString("PAUSE", (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth("PAUSE")/2), 150);
		
		g.setFont(new Font("STENCIL", Font.BOLD, this.getViewFrame().getResume().getSize()));
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getResume().getAlpha()));
		g.drawString(this.getViewFrame().getResume().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getResume().getContent())/2), 350);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getMainMenu().getAlpha()));
		g.drawString(this.getViewFrame().getMainMenu().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getMainMenu().getContent())/2), 450);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getQuitGame().getAlpha()));
		g.drawString(this.getViewFrame().getQuitGame().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getQuitGame().getContent())/2), 550);
	}
	
	public void menuView(Graphics g) {
		for (int y = this.yStart(); y < this.yStart()+viewWidth; y++){
			for (int x = this.xStart(); x < this.xStart()+viewLength; x++){
				int xAff = x-this.xStart(), yAff = y-this.yStart();
				g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);
			}
		}
		
		int i = 0;
		while(i < this.getViewFrame().getMainMenuElements().size()) {
			if(this.getViewFrame().getMainMenuElements().get(i).isSelected()) {
				this.getViewFrame().getMainMenuElements().get(i).setAlpha(200);
			} else {
				this.getViewFrame().getMainMenuElements().get(i).setAlpha(100);
			}
			i++;
		}
		
		g.setFont(new Font("STENCIL", Font.BOLD, 100));
		g.setColor(new Color(239, 226, 213, 255));
		g.drawString("BOULDER DASH", (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth("BOULDER DASH")/2), 150);
		
		g.setFont(new Font("STENCIL", Font.BOLD, this.getViewFrame().getResume().getSize()));
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getPlay().getAlpha()));
		g.drawString(this.getViewFrame().getPlay().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getPlay().getContent())/2), 300);
		g.setColor(new Color(239, 226, 213, this.getViewFrame().getQuitGame2().getAlpha()));
		g.drawString(this.getViewFrame().getQuitGame2().getContent(), (ViewFrame.getWindowLength()/2)-(g.getFontMetrics(g.getFont()).stringWidth(this.getViewFrame().getQuitGame2().getContent())/2), 500);
	}
	
}
