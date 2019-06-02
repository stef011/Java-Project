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
import entity.element.Element;
import entity.element.Position;
import entity.element.motionlessElement.EmptySpace;
import entity.element.motionlessElement.fallingElement.Diamond;
import entity.element.motionlessElement.fallingElement.FallingElement;
import entity.element.motionlessElement.fallingElement.Rock;

public class PlayerTest {
	private Player player;
	private FallingElement rock;
	private FallingElement diamond;
	private Element emptySpace;
	private Map map;
	private char elementSpriteRef[][]={
			{'#','#','#','#'},
			{'^','@','O','_'},
			{'#','^','X','#'},
			{'#','#','#','#'} };
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(new Map(3, "Cave", 4, 4, 18), elementSpriteRef);
		this.player = new Player(this.map, new Position(1, 1));
		this.rock = new Rock(this.map, new Position(2, 1));
		this.diamond = new Diamond(this.map, new Position(0, 1));
		this.emptySpace = new EmptySpace(this.map, new Position(2, 1));
		this.map.setOnTheMapXY(1, 1, this.player);
		this.map.setOnTheMapXY(2, 1, this.rock);
		this.map.setOnTheMapXY(3, 1, this.emptySpace);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		int xExpected = this.rock.getPosition().getX()+1;
		int xpExpected = this.player.getPosition().getX()+1;
		this.player.push(Direction.Right);
		Assert.assertEquals(xExpected, this.rock.getPosition().getX());
		Assert.assertEquals(xpExpected, this.player.getPosition().getX());
	}
	
	@Test
	public void testPick() {
		int expected = 1;
		int xExpected = this.player.getPosition().getX()-1;
		this.player.pick(Direction.Left);
		Assert.assertEquals(expected, this.player.getScore());
		Assert.assertEquals(xExpected, this.player.getPosition().getX());
	}

}
