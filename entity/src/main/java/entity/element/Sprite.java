package entity.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1> The Sprite Class</h1>
 * @author Exars 18-23 Strasbourg grp1
 * @version 1.0
 */
public class Sprite {
	/**
	 * The image
	 */
	private Image image;
	/**
	 * The name of the image
	 */
	private String imageName;
	/**
	 * Path to the sprite
	 */
	private String spritePath;
	/**
	 * Reference of the sprite
	 */
	private char sprite_ref;

	/**
	 * The Constructor
	 * @param sprite_ref The ref of the sprite
	 * @param spritePath The Path of the sprite
	 * @param imageName The Image Name
	 */
	public Sprite(char sprite_ref, String spritePath, String imageName) {
		this.setSprite_ref(sprite_ref);
		this.setImageName(imageName);
		this.setSpritePath(spritePath);
	}

	/**
	 * Gets the image.
	 * @return The {@link #image}
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Sets the image.
	 * @param image The image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Loads the image from the Sprites folder.
	 */
	public void loadImage() {
		String absolutePath = new File("").getAbsolutePath();
		try {
			this.setImage(ImageIO.read(new File(absolutePath+this.getSpritePath()+this.getImageName())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the Image name
	 * @return The {@link #imageName}
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * Sets the image name
	 * @param imageName The Image Name.
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Gets the path to the sprite
	 * @return The path to the sprite.
	 */
	public String getSpritePath() {
		return this.spritePath;
	}

	/**
	 * Sets the path to the sprite
	 * @param spritePath The path to the sprite
	 */
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}

	/**
	 * Gets the sprite reference.
	 * @return The {@link #sprite_ref}
	 */
	public char getSprite_ref() {
		return this.sprite_ref;
	}

	/**
	 * Sets the Sprite reference.
	 * @param sprite_ref The sprite reference.
	 */
	public void setSprite_ref(char sprite_ref) {
		this.sprite_ref = sprite_ref;
	}
	
}
