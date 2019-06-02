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

public class AliveElementTest {
	private AliveElement aliveElement;
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
		this.aliveElement = new AliveElement(map, new Position(2, 2));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAlive() {
		Assert.assertTrue(this.aliveElement.isAlive());
	}
	
	@Test
	public void testDie() {
		this.aliveElement.die();
		int x = this.aliveElement.getPosition().getX();
		int y = this.aliveElement.getPosition().getY();
		Assert.assertFalse(this.aliveElement.isAlive());
		Assert.assertTrue(this.map.getOnTheMapXY(x, y) instanceof EmptySpace);
	}
	
	@Test
	public void testSetGetLastMove() {
		this.aliveElement.setLastMove(Direction.Up);
		Assert.assertTrue(this.aliveElement.getLastMove()==Direction.Up);
	}

}
