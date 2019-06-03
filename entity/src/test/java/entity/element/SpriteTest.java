package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * The test class for the Sprite class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class SpriteTest {
	Sprite sprite;
	
	/** 
	 * This will set up once before any of the test methods in the class.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** 
	 * This will set up once all of the test methods in the class are done.
	 * It is used to release the allocathon that the BeforeClass method allocates. It runs even if the BeforeClass method throws an exception.
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets up the method before each Test method.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('X', "/sprites/settings/", "dirt.png");
	}

	/**
	 * Sets up after each Test method.
	 * It is used to release the allocathon that the Before method allocates. It runs even if the Before method throws an exception.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests the method testSetImageName().
	 */
	@Test
	public void testSetImageName() {
		String expected = "dirt.png";
		this.sprite.setImageName(expected);
		Assert.assertEquals(expected, this.sprite.getImageName());
	}
	
	/**
	 * tests the method testSetSpritePath().
	 */
	@Test
	public void testSetSpritePath() {
		String expected = "/sprites/settings/";
		this.sprite.setSpritePath(expected);
		Assert.assertEquals(expected, this.sprite.getSpritePath());
	}
	
	/**
	 * tests the method testSetSprite_ref().
	 */
	@Test
	public void testSetSprite_ref() {
		char expected = 'X';
		this.sprite.setSprite_ref(expected);
		Assert.assertEquals(expected, this.sprite.getSprite_ref());
	}
	
	/**
	 * tests the method testLoadImage().
	 */
	@Test
	public void testLoadImage() {
		this.sprite.loadImage();
		Assert.assertNotNull(this.sprite.getImage());
	}

}
