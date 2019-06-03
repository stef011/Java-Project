package view.menuElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MenuElementTest {
	MenuElement menuElement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.menuElement = new MenuElement("MenuElement", 40, 200);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetGetContent() {
		String expected = "NewMenuElement";
		this.menuElement.setContent("NewMenuElement");
		Assert.assertEquals(expected, this.menuElement.getContent());
	}
	
	@Test
	public void testSetGetSize() {
		int expected = 32;
		this.menuElement.setSize(32);
		Assert.assertEquals(expected, this.menuElement.getSize());
	}
	
	@Test
	public void testSetGetAlpha() {
		int expected = 32;
		this.menuElement.setAlpha(32);
		Assert.assertEquals(expected, this.menuElement.getAlpha());
	}

}
