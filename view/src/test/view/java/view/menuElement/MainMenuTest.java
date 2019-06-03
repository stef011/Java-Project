package view.java.view.menuElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.MenuActions;
import view.menuElement.MainMenu;
import view.menuElement.MenuElement;

public class MainMenuTest {
	MenuElement mainMenu;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mainMenu = new MainMenu("Main Menu", 30, 100);
		this.mainMenu.setSelected(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMenuRequest() {
		MenuActions expected = MenuActions.Mainmenu;
		Assert.assertEquals(expected, this.mainMenu.MenuRequest());
	}

}
