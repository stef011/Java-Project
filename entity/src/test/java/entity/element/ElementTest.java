package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.fallingElement.Diamond;

public class ElementTest {
	private Element element;
	private Map map;
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
		this.map = new Map(new Map(3, "Cave", 4, 4, 18), elementSpriteRef);
		this.element = new Element(this.map, new Position(2, 2));
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
		
	}

}
