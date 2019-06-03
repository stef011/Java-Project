package entity;

import entity.element.Element;
import entity.element.Position;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.motionlessElement.fallingElement.Rock;
import org.junit.*;

/**
 * The test class for the Map Elements
 * 
 * @author Exars 18-23 Strasbourg grp1
 *
 */
public class MapTest {
	private Map map;
	private FallingElement rock;
	private Map map2;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'#','X','O','#'},
			{'#','^','X','#'},
			{'@','#','#','#'} };


	/** 
	 * This will set up once before any of the test methods in the class.
	 * 
	 * @throws Exception Every Exception Every Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	/** 
	 * This will set up once all of the test methods in the class are done.
	 * It is used to release the allocathon that the BeforeClass method allocates. It runs even if the BeforeClass method throws an exception.
	 * 
	 * @throws Exception Every Exception Every Exception
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
		this.map = new Map(3, "Cave", 4, 4, 18);
		this.map2 = new Map(this.map, this.elementSpriteRef);
		this.rock = new Rock(this.map2, new Position(3, 4));
	}
	

	/**
	 * Sets up after each Test method.
	 * It is used to release the allocathon that the Before method allocates. It runs even if the Before method throws an execption.
	 * 
	 * @throws Exception Every Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * tests the method Map().
	 */
	@Test
	public void testMap() {
		this.map = new Map(3, "Cave", 40, 22, 18);
		Assert.assertEquals(3, this.map.getId());
		Assert.assertEquals("Cave", this.map.getName());
		Assert.assertEquals(40, this.map.getLength());
		Assert.assertEquals(22, this.map.getWidth());
		Assert.assertEquals(18, this.map.getGoal());
	}

	/**
	 * tests the method GetId().
	 */
	@Test
	public void testGetId() {
		int expected = 3;
		Assert.assertEquals(expected, this.map2.getId());
	}

	/**
	 * tests the method SetId().
	 */
	@Test
	public void testSetId() {
		this.map2.setId(6);
		Assert.assertEquals(6, this.map2.getId());
	}

	/**
	 * tests the method GetName().
	 */
	@Test
	public void testGetName() {
		String expected = "Cave";
		Assert.assertEquals(expected, this.map2.getName());
	}

	/**
	 * tests the method SetName().
	 */
	@Test
	public void testSetName() {
		this.map2.setName("xyz");
		Assert.assertEquals("xyz", this.map2.getName());
	}

	/**
	 * tests the method GetLength().
	 */
	@Test
	public void testGetLength() {
		int expected = 4;
		Assert.assertEquals(expected, this.map2.getLength());
	}

	/**
	 * tests the method SetLength().
	 */
	@Test
	public void testSetLength() {
		this.map2.setLength(72);
		Assert.assertEquals(72, this.map2.getLength());
	}

	/**
	 * tests the method GetWidth().
	 */
	@Test
	public void testGetWidth() {
		int expected = 4;
		Assert.assertEquals(expected, this.map2.getWidth());
	}

	/**
	 * tests the method SetWidth().
	 */
	@Test
	public void testSetWidth() {
		this.map2.setWidth(420);
		Assert.assertEquals(420, this.map2.getWidth());
	}

	/**
	 * tests the method GetGoal().
	 */
	@Test
	public void testGetGoal() {
		int expected = 18;
		Assert.assertEquals(expected, this.map2.getGoal());
	}

	/**
	 * tests the method SetGoal().
	 */
	@Test
	public void testSetGoal() {
		this.map2.setGoal(69);
		Assert.assertEquals(69, this.map2.getGoal());
	}

	/**
	 * tests the method GetOnTheMapXY().
	 */
	@Test
	public void testGetOnTheMapXY() {
		Assert.assertTrue(this.map2.getOnTheMapXY(2, 2) instanceof Element);
	}

	/**
	 * tests the method SetOnTheMapXY().
	 */
	@Test
	public void testSetOnTheMapXY() {
		this.map2.setOnTheMapXY(2, 3, this.rock);
		Assert.assertTrue(this.map2.getOnTheMapXY(2, 3) instanceof FallingElement);
	}

	/**
	 * tests the method GetSetPlayer().
	 */
	@Test
	public void testGetSetPlayer() {
		int xExpected = 0;
		this.map2.setPlayer(new Player(this.map2, new Position(0, 3)));
		Assert.assertEquals(xExpected, this.map2.getPlayer().getPosition().getX());
	}
}
