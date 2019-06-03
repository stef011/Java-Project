package view.java.view.menuElement;

import contract.MenuActions;
import org.junit.*;
import view.menuElement.MenuElement;
import view.menuElement.QuitGame;

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
