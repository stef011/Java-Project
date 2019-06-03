package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewFrameTest {
	private ViewFrame viewFrame;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.viewFrame = new ViewFrame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectPauseElement() {
		this.viewFrame.selectPauseElement(2);
		Assert.assertTrue(this.viewFrame.getPauseElements().get(2).isSelected());
	}
	
	@Test
	public void testSelectMainMenuElement() {
		this.viewFrame.selectMainMenuElement(1);
		Assert.assertTrue(this.viewFrame.getMainMenuElements().get(1).isSelected());
	}

}
