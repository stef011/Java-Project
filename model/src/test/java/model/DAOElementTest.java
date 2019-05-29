package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DAOElementTest {
	private DAOElement daoElement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.daoElement = new DAOElement(DBConnection.getInstance().getConnection());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindElementByXY() {
		char expected = '#';
		Assert.assertEquals(expected, this.daoElement.find(1, 0, 1));
	}

}
