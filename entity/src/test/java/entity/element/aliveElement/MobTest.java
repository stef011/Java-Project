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
import entity.element.Position;
import entity.element.motionlessElement.fallingElement.Diamond;
/**
 * The test class for the Mob class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class MobTest {
	private Mob mob;
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
		this.mob = new Mob(this.map, new Position(2, 2));
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
	 * tests the method testCheckOnLeft().
	 */
	@Test
	public void testCheckOnLeft() {
		Direction expected = Direction.Right;
		assertEquals(expected, this.mob.checkOnLeft(Direction.Down));
	}
	
	/**
	 * tests the method testBlow().
	 */
	@Test
	public void testBlow() {
		this.mob.blow();
		Assert.assertTrue(this.map.getOnTheMapXY(this.mob.getPosition().getX(), this.mob.getPosition().getY()) instanceof Diamond);
	}
	
	/**
	 * tests the method testDie().
	 */
	@Test
	public void testDie() {
		this.mob.die();
		Assert.assertFalse(this.mob.isAlive());
		Assert.assertTrue(this.map.getOnTheMapXY(this.mob.getPosition().getX(), this.mob.getPosition().getY()) instanceof Diamond);
	}

}
