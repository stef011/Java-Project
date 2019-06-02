package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.element.Element;
import entity.element.Position;
import entity.element.aliveElement.Player;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.motionlessElement.fallingElement.Rock;

public class MapTest {
	private Map map;
	private FallingElement rock;
	private Map map2;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'#','X','O','#'},
			{'#','^','X','#'},
			{'@','#','#','#'} };

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(3, "Cave", 4, 4, 18);
		this.map2 = new Map(this.map, this.elementSpriteRef);
		this.rock = new Rock(this.map2, new Position(3, 4));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMap() {
		this.map = new Map(3, "Cave", 40, 22, 18);
		Assert.assertEquals(3, this.map.getId());
		Assert.assertEquals("Cave", this.map.getName());
		Assert.assertEquals(40, this.map.getLength());
		Assert.assertEquals(22, this.map.getWidth());
		Assert.assertEquals(18, this.map.getGoal());
	}
	
	@Test
	public void testGetId() {
		int expected = 3;
		Assert.assertEquals(expected, this.map2.getId());
	}
	
	@Test
	public void testSetId() {
		this.map2.setId(6);
		Assert.assertEquals(6, this.map2.getId());
	}
	
	@Test
	public void testGetName() {
		String expected = "Cave";
		Assert.assertEquals(expected, this.map2.getName());
	}
	
	@Test
	public void testSetName() {
		this.map2.setName("xyz");
		Assert.assertEquals("xyz", this.map2.getName());
	}
	
	@Test
	public void testGetLength() {
		int expected = 4;
		Assert.assertEquals(expected, this.map2.getLength());
	}
	
	@Test
	public void testSetLength() {
		this.map2.setLength(72);
		Assert.assertEquals(72, this.map2.getLength());
	}
	
	@Test
	public void testGetWidth() {
		int expected = 4;
		Assert.assertEquals(expected, this.map2.getWidth());
	}
	
	@Test
	public void testSetWidth() {
		this.map2.setWidth(420);
		Assert.assertEquals(420, this.map2.getWidth());
	}
	
	@Test
	public void testGetGoal() {
		int expected = 18;
		Assert.assertEquals(expected, this.map2.getGoal());
	}
	
	@Test
	public void testSetGoal() {
		this.map2.setGoal(69);
		Assert.assertEquals(69, this.map2.getGoal());
	}
	
	@Test
	public void testGetOnTheMapXY() {
		Assert.assertTrue(this.map2.getOnTheMapXY(2, 2) instanceof Element);
	}
	
	@Test
	public void testSetOnTheMapXY() {
		this.map2.setOnTheMapXY(2, 3, this.rock);
		Assert.assertTrue(this.map2.getOnTheMapXY(2, 3) instanceof FallingElement);
	}
	
	@Test
	public void testGetSetPlayer() {
		int xExpected = 0;
		this.map2.setPlayer(new Player(this.map2, new Position(0, 3)));
		Assert.assertEquals(xExpected, this.map2.getPlayer().getPosition().getX());
	}
}
