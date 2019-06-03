package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.aliveElement.*;
import entity.element.motionlessElement.*;
import entity.element.motionlessElement.fallingElement.*;

/**
 * The test class for the element factory
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class ElementFactoryTest {
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
	 * tests the method CreateDirt().
	 */
	@Test
	public void testCreateDirt() {
		Assert.assertTrue(ElementFactory.createDirt(this.map, new Position(2, 2)) instanceof Dirt);
	}
	/**
	 * tests the method CreateWall().
	 */
	@Test
	public void testCreateWall() {
		Assert.assertTrue(ElementFactory.createWall(this.map, new Position(2, 2)) instanceof Wall);
	}
	/**
	 * tests the method CreateEmptySpace().
	 */
	@Test
	public void testCreateEmptySpace() {
		Assert.assertTrue(ElementFactory.createEmptySpace(this.map, new Position(2, 2)) instanceof EmptySpace);
	}
	/**
	 * tests the method CreateUnbreakableWall().
	 */
	@Test
	public void testCreateUnbreakableWall() {
		Assert.assertTrue(ElementFactory.createUnbreakableWall(this.map, new Position(2, 2)) instanceof UnbreakableWall);
	}
	/**
	 * tests the method CreateRock().
	 */
	@Test
	public void testCreateRock() {
		Assert.assertTrue(ElementFactory.createRock(this.map, new Position(2, 2)) instanceof Rock);
	}
	/**
	 * tests the method CreateDiamond().
	 */
	@Test
	public void testCreateDiamond() {
		Assert.assertTrue(ElementFactory.createDiamond(this.map, new Position(2, 2)) instanceof Diamond);
	}
	/**
	 * tests the method CreatePlayer().
	 */
	@Test
	public void testCreatePlayer() {
		Assert.assertTrue(ElementFactory.createPlayer(this.map, new Position(2, 2)) instanceof Player);
	}
	/**
	 * tests the method CreateMob().
	 */
	@Test
	public void testCreateMob() {
		Assert.assertTrue(ElementFactory.createMob(this.map, new Position(2, 2)) instanceof Mob);
	}
	/**
	 * tests the method SelectElementFromSpriteRef().
	 */
	@Test
	public void testSelectElementFromSpriteRef() {
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('#', map, new Position(2, 2)) instanceof Wall);
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('X', map, new Position(2, 2)) instanceof Dirt);
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('_', map, new Position(2, 2)) instanceof EmptySpace);
	}


}
