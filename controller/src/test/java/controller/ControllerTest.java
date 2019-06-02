package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.GameState;
import contract.IController;
import contract.IModel;
import contract.IView;

public class ControllerTest {
	private Controller controller;
	private IView view;
	private IModel model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		controller = new Controller(view, model);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
