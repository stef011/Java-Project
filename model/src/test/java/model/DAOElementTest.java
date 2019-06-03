package model;

import entity.element.Element;
import org.junit.*;

import static org.junit.Assert.*;

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

	/**
	 * Test of {@link DAOElement#find(int)}
	 */
	@Test
	public void testFind() {
		char expected = '#';
		Assert.assertEquals(expected, this.daoElement.find(1, 0, 1));
	}

	/**
	 * Test of {@link DAOElement#create(Element)}
	 */
	@Test
	public void testCreate() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.create(entity);

		// Verify the results
		assertTrue(result);
	}

	/**
	 * Test of {@link DAOElement#delete(Element)}
	 */
	@Test
	public void testDelete() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.delete(entity);

		// Verify the results
		assertFalse(result);
	}

	/**
	 * Test of {@link DAOElement#update(Element)}
	 */
	@Test
	public void testUpdate() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.update(entity);

		// Verify the results
		assertFalse(result);
	}
}
