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
		String ImagePath = "/sprites/settings/background.png";
		try {
			//Path p = Paths.get(".");
			//this.setBackgr(ImageIO.read(new File(p.toAbsolutePath()+ImagePath)));
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

	public void paintComponent(Graphics g){
		int xStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getX()-viewLength/2;
		int yStart = this.getViewFrame().getModel().getMap().getPlayer().getPosition().getY()-viewWidth/2;
		int xFinish = xStart + viewLength;
		int yFinish = yStart + viewWidth;
		
		System.out.println("xStart: "+xStart+" | yStart: "+yStart);
		System.out.println("xFinish: "+xFinish+" | yFinish: "+yFinish);
		for (int y = yStart; y<yFinish; y++){
			for (int x = xStart; x<xFinish; x++){
		
		//for (int y = 0; y<viewFrame.getModel().getMap().getWidth(); y++){
		//	for (int x = 0; x<viewFrame.getModel().getMap().getLength(); x++){
				int xAff = x-xStart, yAff = y-yStart;
				g.drawImage(this.getBackgr().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);
				g.drawImage(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y).getSprite().getImage().getScaledInstance(squareSize, squareSize, Image.SCALE_DEFAULT), xAff*squareSize, yAff*squareSize, this);

			}
		}
	
	}
}
