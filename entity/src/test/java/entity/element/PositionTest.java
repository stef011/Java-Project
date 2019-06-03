package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * The test class for the Position class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class PositionTest {
	Position position;
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
		this.position = new Position(1, 1);
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

	@Test
	public void testPosition() {
		this.position = new Position(2, 3);
		Assert.assertEquals(2, this.position.getX());
		Assert.assertEquals(3, this.position.getY());
	}

	/**
	 * tests the method testSetX().
	 */
	@Test
	public void testSetX() {
		this.position.setX(0);
		Assert.assertEquals(0, this.position.getX());
	}

	/**
	 * tests the method testSetY().
	 */
	@Test
	public void testSetY() {
		this.position.setY(0);
		Assert.assertEquals(0, this.position.getY());
	}

}
