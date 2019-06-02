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

public class MobTest {
	private Mob mob;
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
		this.mob = new Mob(this.map, new Position(2, 2));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckOnLeft() {
		Direction expected = Direction.Right;
		assertEquals(expected, this.mob.checkOnLeft(Direction.Down));
	}
	
	@Test
	public void testBlow() {
		this.mob.blow();
		Assert.assertTrue(this.map.getOnTheMapXY(this.mob.getPosition().getX(), this.mob.getPosition().getY()) instanceof Diamond);
	}
	
	@Test
	public void testDie() {
		this.mob.die();
		Assert.assertFalse(this.mob.isAlive());
		Assert.assertTrue(this.map.getOnTheMapXY(this.mob.getPosition().getX(), this.mob.getPosition().getY()) instanceof Diamond);
	}

}
