package model;

import entity.element.Element;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	public void testFind() {
		char expected = '#';
		Assert.assertEquals(expected, this.daoElement.find(1, 0, 1));
	}

	@Test
	public void testCreate() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.create(entity);

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testDelete() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.delete(entity);

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testFind1() {
		// Setup
		final int id_map = 1;
		final int x = 0;
		final int y = 0;
		final char expectedResult = '#';

		// Run the test
		final char result = daoElement.find(id_map, x, y);

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testFind2() {
		// Setup
		final int id = 0;
		final Element expectedResult = null;

		// Run the test
		final Element result = daoElement.find(id);

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testUpdate() {
		// Setup
		final Element entity = null;

		// Run the test
		final boolean result = daoElement.update(entity);

		// Verify the results
		assertTrue(result);
	}
}
