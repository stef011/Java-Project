package entity.element.motionlessElement.fallingElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.Direction;
import entity.element.Element;
import entity.element.ElementFactory;
import entity.element.Position;
import entity.element.motionlessElement.EmptySpace;
/**
 * The test class for the FallingElement class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class FallingElementTest {
	private FallingElement fallingElement;
	private Map map;
	private Element emptySpace;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'#','O','X','#'},
			{'#','^','M','#'},
			{'@','#','#','#'} };
	
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
		this.map = new Map(new Map(3, "Cave", 4, 4, 18), elementSpriteRef);
		this.fallingElement = new FallingElement(this.map, new Position(1, 1));
		this.emptySpace = new EmptySpace(this.map, new Position(1, 2));
		this.map.setOnTheMapXY(1, 1, this.fallingElement);
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
	 * tests the method fall() in case of freefall.
	 */
	@Test
	public void testFreeFall() {
		this.map.setOnTheMapXY(1, 2, this.emptySpace);
		int yExpected = this.fallingElement.getPosition().getY()+1;
		this.fallingElement.fall();
		Assert.assertEquals(yExpected, this.fallingElement.getPosition().getY());
	}

	/**
	 * tests the method CheckIfCanSlide().
	 */
	@Test
	public void testCheckIfCanSlide() {
		this.map.setOnTheMapXY(2, 1, ElementFactory.createEmptySpace(this.map, new Position(2, 1)));
		this.map.setOnTheMapXY(2, 2, ElementFactory.createEmptySpace(this.map, new Position(2, 2)));
		Assert.assertTrue(this.fallingElement.checkIfCanSlide(Direction.Right, Direction.RightDown));
	}

	/**
	 *  tests the method fall() in case of slide.
	 */
	@Test
	public void testSlideFall() {
		int xExpected = this.fallingElement.getPosition().getX()+1;
		this.map.setOnTheMapXY(1, 2, ElementFactory.createRock(this.map, new Position(1, 2)));
		this.map.setOnTheMapXY(2, 1, ElementFactory.createEmptySpace(this.map, new Position(2, 1)));
		this.map.setOnTheMapXY(2, 2, ElementFactory.createEmptySpace(this.map, new Position(2, 2)));
		this.fallingElement.fall();
		Assert.assertEquals(xExpected, this.fallingElement.getPosition().getX());
	}

}
