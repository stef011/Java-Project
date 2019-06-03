package view.menuElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.MenuActions;

public class PlayTest {
	MenuElement play;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.play = new Play("Play", 30, 100);
		this.play.setSelected(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMenuRequest() {
		MenuActions expected = MenuActions.Play;
		Assert.assertEquals(expected, this.play.MenuRequest());
	}

}
