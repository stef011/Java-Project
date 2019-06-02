package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;


public class DAOMapTest {
	private DAOMap daoMap;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.daoMap = new DAOMap(DBConnection.getInstance().getConnection());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() {
		Map test = this.daoMap.find("Cave");
		Assert.assertEquals(3, test.getId());
		Assert.assertEquals("Cave", test.getName());
		Assert.assertEquals(40, test.getLength());
		Assert.assertEquals(22, test.getWidth());
		Assert.assertEquals(18, test.getGoal());
	}

}
