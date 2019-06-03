package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewPanelTest {
	private ViewPanel viewPanel;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.viewPanel = new ViewPanel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadMainMenuBackgr() {
		this.viewPanel.loadMainMenuBackgr();
		Assert.assertNotNull(this.viewPanel.getMainMenuBackgr());
	}
	
	@Test
	public void testLoadBackgr() {
		this.viewPanel.loadBackgr();
		Assert.assertNotNull(this.viewPanel.getBackgr());
	}

}
