package entity.element.aliveElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.element.Direction;

public class MobTest {
	
	private Mob mob;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mob = new Mob();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckOnLeft() {
		Direction expected = Direction.Right;
		assertEquals(expected, this.mob.checkOnLeft(Direction.Down));
	}

}
