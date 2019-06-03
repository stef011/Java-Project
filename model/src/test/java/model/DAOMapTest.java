package model;

import entity.Map;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
