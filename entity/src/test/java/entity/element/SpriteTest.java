package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {
	Sprite sprite;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('X', "/sprites/settings/", "dirt.png");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetImageName() {
		String expected = "dirt.png";
		this.sprite.setImageName(expected);
		Assert.assertEquals(expected, this.sprite.getImageName());
	}
	
	@Test
	public void testSetSpritePath() {
		String expected = "/sprites/settings/";
		this.sprite.setSpritePath(expected);
		Assert.assertEquals(expected, this.sprite.getSpritePath());
	}
	
	@Test
	public void testSetSprite_ref() {
		char expected = 'X';
		this.sprite.setSprite_ref(expected);
		Assert.assertEquals(expected, this.sprite.getSprite_ref());
	}
	
	@Test
	public void testLoadImage() {
		this.sprite.loadImage();
		Assert.assertNotNull(this.sprite.getImage());
	}

}
