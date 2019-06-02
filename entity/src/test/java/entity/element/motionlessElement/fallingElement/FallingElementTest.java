package entity.element.motionlessElement.fallingElement;

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
import entity.element.ElementFactory;
import entity.element.Position;
import entity.element.motionlessElement.EmptySpace;

public class FallingElementTest {
	private FallingElement fallingElement;
	private Map map;
	private Element emptySpace;
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
		this.fallingElement = new FallingElement(this.map, new Position(1, 1));
		this.emptySpace = new EmptySpace(this.map, new Position(1, 2));
		this.map.setOnTheMapXY(1, 1, this.fallingElement);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFreeFall() {
		this.map.setOnTheMapXY(1, 2, this.emptySpace);
		int yExpected = this.fallingElement.getPosition().getY()+1;
		this.fallingElement.fall();
		Assert.assertEquals(yExpected, this.fallingElement.getPosition().getY());
	}
	
	@Test
	public void testCheckIfCanSlide() {
		this.map.setOnTheMapXY(2, 1, ElementFactory.createEmptySpace(this.map, new Position(2, 1)));
		this.map.setOnTheMapXY(2, 2, ElementFactory.createEmptySpace(this.map, new Position(2, 2)));
		Assert.assertTrue(this.fallingElement.checkIfCanSlide(Direction.Right, Direction.RightDown));
	}
	
	@Test
	public void testSlideFall() {
		int xExpected = this.fallingElement.getPosition().getX()+1;
		this.map.setOnTheMapXY(1, 2, ElementFactory.createRock(this.map, new Position(1, 2)));
		this.map.setOnTheMapXY(2, 1, ElementFactory.createEmptySpace(this.map, new Position(2, 1)));
		this.map.setOnTheMapXY(2, 2, ElementFactory.createEmptySpace(this.map, new Position(2, 2)));
		this.fallingElement.fall();
		Assert.assertEquals(xExpected, this.fallingElement.getPosition().getX());
	}

}
