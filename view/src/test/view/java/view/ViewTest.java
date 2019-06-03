package view.java.view;

import contract.ControllerOrder;
import contract.IModel;
import org.junit.*;
import view.View;

import java.awt.event.KeyEvent;

public class ViewTest {
	private IModel model;
	private View view;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKeyCodeToControllerOrder() {
		ControllerOrder expected = ControllerOrder.Up;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_UP));
		expected = ControllerOrder.Down;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_DOWN));
		expected = ControllerOrder.Left;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_LEFT));
		expected = ControllerOrder.Right;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_RIGHT));
		expected = ControllerOrder.Escape;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_ESCAPE));
		expected = ControllerOrder.Enter;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_ENTER));
		expected = ControllerOrder.Else;
		Assert.assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_K));
	}

}
