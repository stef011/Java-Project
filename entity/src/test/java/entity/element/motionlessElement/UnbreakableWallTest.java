package entity.element.motionlessElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.element.Element;
import entity.element.Position;
import entity.element.motionlessElement.fallingElement.Diamond;

public class UnbreakableWallTest {
	private Element unbreakableWall;
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
		this.unbreakableWall = new UnbreakableWall(this.map, new Position(0, 0));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplaceByDiamond() {
		this.unbreakableWall.replaceByDiamond();
		Assert.assertTrue(this.map.getOnTheMapXY(this.unbreakableWall.getPosition().getX(), this.unbreakableWall.getPosition().getY()) instanceof UnbreakableWall);
	}

}
