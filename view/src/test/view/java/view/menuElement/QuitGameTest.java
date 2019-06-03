package view.menuElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.MenuActions;

public class QuitGameTest {
	MenuElement quitGame;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.quitGame = new QuitGame("Quit Game", 30, 100);
		this.quitGame.setSelected(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMenuRequest() {
		MenuActions expected = MenuActions.Quitgame;
		Assert.assertEquals(expected, this.quitGame.MenuRequest());
	}

}
