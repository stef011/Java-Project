package entity.element.aliveElement;

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
import entity.element.Position;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.fallingElement.Diamond;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.motionlessElement.fallingElement.Rock;
/**
 * The test class for the Player class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class PlayerTest {
	private Player player;
	private FallingElement rock;
	private FallingElement diamond;
	private Element emptySpace;
	private Map map;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'^','@','O','_'},
			{'#','^','X','#'},
			{'#','#','#','#'} };
	
	/** 
	 * This will set up once before any of the test methods in the class.
	 * 
	 * @throws Exception Every Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/** 
	 * This will set up once all of the test methods in the class are done.
	 * It is used to release the allocathon that the BeforeClass method allocates. It runs even if the BeforeClass method throws an exception.
	 * 
	 * @throws Exception Every Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets up the method before each Test method.
	 * 
	 * @throws Exception Every Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.map = new Map(new Map(3, "Cave", 4, 4, 18), elementSpriteRef);
		this.player = new Player(this.map, new Position(1, 1));
		this.rock = new Rock(this.map, new Position(2, 1));
		this.diamond = new Diamond(this.map, new Position(0, 1));
		this.emptySpace = new EmptySpace(this.map, new Position(2, 1));
		this.map.setOnTheMapXY(1, 1, this.player);
		this.map.setOnTheMapXY(2, 1, this.rock);
		this.map.setOnTheMapXY(3, 1, this.emptySpace);
	}

	/**
	 * Sets up after each Test method.
	 * It is used to release the allocathon that the Before method allocates. It runs even if the Before method throws an exception.
	 * 
	 * @throws Exception Every Exception
	 */

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests the method testPush().
	 */
	@Test
	public void testPush() {
		int xExpected = this.rock.getPosition().getX()+1;
		int xpExpected = this.player.getPosition().getX()+1;
		this.player.push(Direction.Right);
		Assert.assertEquals(xExpected, this.rock.getPosition().getX());
		Assert.assertEquals(xpExpected, this.player.getPosition().getX());
	}

	/**
	 * tests the method testPick().
	 */
	@Test
	public void testPick() {
		int expected = 1;
		int xExpected = this.player.getPosition().getX()-1;
		this.player.pick(Direction.Left);
		Assert.assertEquals(expected, this.player.getScore());
		Assert.assertEquals(xExpected, this.player.getPosition().getX());
	}

}
