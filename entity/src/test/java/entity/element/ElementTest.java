package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.aliveElement.AliveElement;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.fallingElement.Diamond;
/**
 * The test class for the element class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class ElementTest {
	private Element element;
	private Map map;
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
		this.element = new Element(this.map, new Position(2, 1));
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
	 * tests the method testReplaceByEmptySpace().
	 */
	@Test
	public void testReplaceByEmptySpace() {
		this.element.replaceByEmptySpace();
		Assert.assertTrue(this.map.getOnTheMapXY(this.element.getPosition().getX(), this.element.getPosition().getY()) instanceof EmptySpace);
	}
	/**
	 * tests the method testReplaceByDiamond().
	 */
	@Test
	public void testReplaceByDiamond() {
		this.element.replaceByDiamond();
		Assert.assertTrue(this.map.getOnTheMapXY(this.element.getPosition().getX(), this.element.getPosition().getY()) instanceof Diamond);
	}
	/**
	 * tests the method testStringToDirection().
	 */
	@Test
	public void testStringToDirection() {
		Direction expected = Direction.Left;
		Assert.assertEquals(expected, this.element.stringToDirection("Left"));
		expected = Direction.Right;
		Assert.assertEquals(expected, this.element.stringToDirection("Right"));
		expected = Direction.Up;
		Assert.assertEquals(expected, this.element.stringToDirection("Up"));
		expected = Direction.Down;
		Assert.assertEquals(expected, this.element.stringToDirection("Down"));
	}
	/**
	 * tests the method testLookAtNextBlockt().
	 */
	@Test
	public void testLookAtNextBlock() {
		int xExpected = this.element.getPosition().getX()-1;
		Assert.assertEquals(xExpected, this.element.lookAtNextBlock(Direction.Left).getPosition().getX());
	}
	/**
	 * tests the method testgetAliveElementOnBottom().
	 */
	@Test
	public void testgetAliveElementOnBottom() {
		Assert.assertTrue(this.element.getAliveElementOnBottom() instanceof AliveElement);
	}
	/**
	 * tests the method testCheckAlivePermeability().
	 */
	@Test
	public void testCheckAlivePermeability() {
		Assert.assertEquals(TraversableByAlive.Pushable, this.element.checkAlivePermeability(Direction.Left));
	}
	/**
	 * tests the method testCheckFallingPermeability().
	 */
	@Test
	public void testCheckFallingPermeability() {
		Assert.assertEquals(TraversableByFalling.Slippery, this.element.checkFallingPermeability(Direction.Left));
	}
	/**
	 * tests the method testMoveUp().
	 */
	@Test
	public void testMoveUp() {
		int yExpected = this.element.getPosition().getY()-1;
		this.element.moveUp();
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	/**
	 * tests the method testMoveDown().
	 */
	@Test
	public void testMoveDown() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.moveDown();
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	/**
	 * tests the method testMoveLeft().
	 */
	@Test
	public void testMoveLeft() {
		int xExpected = this.element.getPosition().getX()-1;
		this.element.moveLeft();
		Assert.assertEquals(xExpected, this.element.getPosition().getX());
	}
	/**
	 * tests the method testMoveRight().
	 */
	@Test
	public void testMoveRight() {
		int xExpected = this.element.getPosition().getX()+1;
		this.element.moveRight();
		Assert.assertEquals(xExpected, this.element.getPosition().getX());
	}
	/**
	 * tests the method testMoveDir().
	 */
	@Test
	public void testMoveDir() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.move(Direction.Down);
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	/**
	 * tests the method testMoveStr().
	 */
	@Test
	public void testMoveStr() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.move("Down");
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}

}
