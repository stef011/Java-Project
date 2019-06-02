package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositionTest {
	Position position;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.position = new Position(1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPosition() {
		this.position = new Position(2, 3);
		Assert.assertEquals(2, this.position.getX());
		Assert.assertEquals(3, this.position.getY());
	}
	
	@Test
	public void testSetX() {
		this.position.setX(0);
		Assert.assertEquals(0, this.position.getX());
	}
	
	@Test
	public void testSetY() {
		this.position.setY(0);
		Assert.assertEquals(0, this.position.getY());
	}

}
