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

public class ElementTest {
	private Element element;
	private Map map;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'#','O','X','#'},
			{'#','^','M','#'},
			{'@','#','#','#'} };
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(new Map(3, "Cave", 4, 4, 18), elementSpriteRef);
		this.element = new Element(this.map, new Position(2, 1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplaceByEmptySpace() {
		this.element.replaceByEmptySpace();
		Assert.assertTrue(this.map.getOnTheMapXY(this.element.getPosition().getX(), this.element.getPosition().getY()) instanceof EmptySpace);
	}
	
	@Test
	public void testReplaceByDiamond() {
		this.element.replaceByDiamond();
		Assert.assertTrue(this.map.getOnTheMapXY(this.element.getPosition().getX(), this.element.getPosition().getY()) instanceof Diamond);
	}
	
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
	
	@Test
	public void testLookAtNextBlock() {
		int xExpected = this.element.getPosition().getX()-1;
		Assert.assertEquals(xExpected, this.element.lookAtNextBlock(Direction.Left).getPosition().getX());
	}
	
	@Test
	public void testgetAliveElementOnBottom() {
		Assert.assertTrue(this.element.getAliveElementOnBottom() instanceof AliveElement);
	}
	
	@Test
	public void testCheckAlivePermeability() {
		Assert.assertEquals(TraversableByAlive.Pushable, this.element.checkAlivePermeability(Direction.Left));
	}
	
	@Test
	public void testCheckFallingPermeability() {
		Assert.assertEquals(TraversableByFalling.Slippery, this.element.checkFallingPermeability(Direction.Left));
	}
	
	@Test
	public void testMoveUp() {
		int yExpected = this.element.getPosition().getY()-1;
		this.element.moveUp();
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	
	@Test
	public void testMoveDown() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.moveDown();
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	
	@Test
	public void testMoveLeft() {
		int xExpected = this.element.getPosition().getX()-1;
		this.element.moveLeft();
		Assert.assertEquals(xExpected, this.element.getPosition().getX());
	}
	
	@Test
	public void testMoveRight() {
		int xExpected = this.element.getPosition().getX()+1;
		this.element.moveRight();
		Assert.assertEquals(xExpected, this.element.getPosition().getX());
	}
	
	@Test
	public void testMoveDir() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.move(Direction.Down);
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}
	
	@Test
	public void testMoveStr() {
		int yExpected = this.element.getPosition().getY()+1;
		this.element.move("Down");
		Assert.assertEquals(yExpected, this.element.getPosition().getY());
	}

}
