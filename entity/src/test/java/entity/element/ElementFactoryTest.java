package entity.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.aliveElement.*;
import entity.element.motionlessElement.*;
import entity.element.motionlessElement.fallingElement.*;

public class ElementFactoryTest {
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDirt() {
		Assert.assertTrue(ElementFactory.createDirt(this.map, new Position(2, 2)) instanceof Dirt);
	}
	
	@Test
	public void testCreateWall() {
		Assert.assertTrue(ElementFactory.createWall(this.map, new Position(2, 2)) instanceof Wall);
	}
	
	@Test
	public void testCreateEmptySpace() {
		Assert.assertTrue(ElementFactory.createEmptySpace(this.map, new Position(2, 2)) instanceof EmptySpace);
	}
	
	@Test
	public void testCreateUnbreakableWall() {
		Assert.assertTrue(ElementFactory.createUnbreakableWall(this.map, new Position(2, 2)) instanceof UnbreakableWall);
	}
	
	@Test
	public void testCreateRock() {
		Assert.assertTrue(ElementFactory.createRock(this.map, new Position(2, 2)) instanceof Rock);
	}
	
	@Test
	public void testCreateDiamond() {
		Assert.assertTrue(ElementFactory.createDiamond(this.map, new Position(2, 2)) instanceof Diamond);
	}
	
	@Test
	public void testCreatePlayer() {
		Assert.assertTrue(ElementFactory.createPlayer(this.map, new Position(2, 2)) instanceof Player);
	}
	
	@Test
	public void testCreateMob() {
		Assert.assertTrue(ElementFactory.createMob(this.map, new Position(2, 2)) instanceof Mob);
	}
	
	@Test
	public void testSelectElementFromSpriteRef() {
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('#', map, new Position(2, 2)) instanceof Wall);
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('X', map, new Position(2, 2)) instanceof Dirt);
		Assert.assertTrue(ElementFactory.selectElementFromSpriteRef('_', map, new Position(2, 2)) instanceof EmptySpace);
	}
	
	
}
