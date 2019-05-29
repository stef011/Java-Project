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
	private ViewFrame					viewFrame;

	/** The panel */
	private ViewPanel pane;

	/** The image table for the map */
	private Image[][] images;

	/** The Image*/
	private Image image;


	/** Length and width.*/
	Integer length, width;



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
		viewFrame.getModel().getObservable().addObserver(this);


		length = 40;
		width = 22;
		images = new Image[length][width];

		fillImages();
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

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 *//*
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
	}*/

	/**
	 * Fills the table of images.
	 */
	public void fillImages(){
		setImage();
		for (int y = 0; y<width; y++ ){
			for (int x = 0; x<length; x++){
				images[x][y] = image;
				System.out.println(x + " Bite " + y);

			}
		}
	}

	/**
	 * Set the default image
	 */
	public void setImage(){
		try {
			image = ImageIO.read(new File("./sprites/settings/background.png"));
		}
		catch (Exception e){
			viewFrame.printMessage("Erreur :"+ e.getMessage());
		}
	}

	public void paintComponent(Graphics g){
		for (int y = 0; y<22; y++){
			for (int x = 0; x<40; x++){
				image = images[x][y];
				g.drawImage(image,x*16,y*16,this);
				System.out.println(x + " Print " + y);
			}
		}
	}
}
