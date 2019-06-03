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
import entity.element.motionlessElement.EmptySpace;
/**
 * The test class for the AliveElement class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */

public class AliveElementTest {
	private AliveElement aliveElement;
	private Map map;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'#','O','X','#'},
			{'#','^','M','#'},
			{'@','#','#','#'} };

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
		this.aliveElement = new AliveElement(map, new Position(2, 2));
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
	 * tests the method testIsAlive().
	 */
	@Test
	public void testIsAlive() {
		Assert.assertTrue(this.aliveElement.isAlive());
	}
	
	/**
	 * tests the method testDie().
	 */
	@Test
	public void testDie() {
		this.aliveElement.die();
		int x = this.aliveElement.getPosition().getX();
		int y = this.aliveElement.getPosition().getY();
		Assert.assertFalse(this.aliveElement.isAlive());
		Assert.assertTrue(this.map.getOnTheMapXY(x, y) instanceof EmptySpace);
	}
	
	/**
	 * tests the method testSetGetLastMove().
	 */
	@Test
	public void testSetGetLastMove() {
		this.aliveElement.setLastMove(Direction.Up);
		Assert.assertTrue(this.aliveElement.getLastMove()==Direction.Up);
	}

}
