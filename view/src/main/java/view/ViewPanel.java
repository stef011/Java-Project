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
		try {
			this.setBackgr(ImageIO.read(new File("D://Documents/eXia/Prosit/Bloc 5/Projet_UMLJava/Java-Project/sprites/settings/background.png")));
		}
		catch (Exception e){
			viewFrame.printMessage("Erreur :"+ e.getMessage());
		}
	}
	
	public Image getBackgr() {
		return this.backgr;
	}
	
	public void setBackgr(Image backgr) {
		this.backgr = backgr;
	}

	public void paintComponent(Graphics g){
		for (int y = 0; y<viewFrame.getModel().getMap().getWidth(); y++){
			for (int x = 0; x<viewFrame.getModel().getMap().getLength(); x++){
				g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), x*squareSize, y*squareSize, this);
				g.drawImage(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y).getSprite().getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), x*squareSize, y*squareSize, this);
			}
		}
	
	}
}
