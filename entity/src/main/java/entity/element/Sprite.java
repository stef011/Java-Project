package entity.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private Image image;
	private String imageName;
	private String spritePath;
	private char sprite_ref;
	
	public Sprite(char sprite_ref, String spritePath, String imageName) {
		this.setSprite_ref(sprite_ref);
		this.setImageName(imageName);
		this.setSpritePath(spritePath);
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	// "D://Documents/eXia/Prosit/Bloc 5/Projet_UMLJava/Java-Project"
	
	public void loadImage() {
		try {
			this.setImage(ImageIO.read(new File("D://Documents/eXia/Prosit/Bloc 5/Projet_UMLJava/Java-Project"+this.getSpritePath()+this.getImageName())));
		} catch (IOException e) {
			System.out.println("Error on loading file: "+this.getSpritePath()+this.getImageName());
			e.printStackTrace();
		}
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getSpritePath() {
		return this.spritePath;
	}

	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}

	public char getSprite_ref() {
		return this.sprite_ref;
	}

	public void setSprite_ref(char sprite_ref) {
		this.sprite_ref = sprite_ref;
	}
	
}
