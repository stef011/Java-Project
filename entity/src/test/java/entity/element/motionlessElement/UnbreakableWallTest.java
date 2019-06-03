package entity.element.motionlessElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.Element;
import entity.element.Position;
import entity.element.motionlessElement.fallingElement.Diamond;
/**
 * The test class for the UnbreakableWall class.
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class UnbreakableWallTest {
	private Element unbreakableWall;
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
		this.unbreakableWall = new UnbreakableWall(this.map, new Position(0, 0));
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
	 * tests the method {@link entity.element.motionlessElement.UnbreakableWall#replaceByDiamond()}.
	 */
	@Test
	public void testReplaceByDiamond() {
		this.unbreakableWall.replaceByDiamond();
		Assert.assertTrue(this.map.getOnTheMapXY(this.unbreakableWall.getPosition().getX(), this.unbreakableWall.getPosition().getY()) instanceof UnbreakableWall);
	}

}
