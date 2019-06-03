/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import contract.GameState;
import entity.Map;
import org.junit.*;


public class ModelTest {
    private Model model;
    private Map mapForTest;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.model = new Model("Cellar");
        mapForTest = new Map();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMap() {
        Assert.assertEquals("Cellar", this.model.getMap().getName());
    }
    
    @Test
    public void testSetMap() {
    	this.model.setMap(this.mapForTest);
    	Assert.assertEquals(this.mapForTest, this.model.getMap());
    }


    @Test
    public void testGetMapInformation() {
    	this.model.loadMap("Cellar");
        Assert.assertEquals(1, this.model.getMap().getId());
        this.model.loadMap("Catacombs");
        Assert.assertEquals(22, this.model.getMap().getWidth());
        this.model.loadMap("Cave");
        Assert.assertEquals(40, this.model.getMap().getLength());
        this.model.loadMap("The unknown");
        Assert.assertEquals(1, this.model.getMap().getGoal());
        this.model.loadMap("China Goal");
        Assert.assertEquals("China Goal", this.model.getMap().getName());
        this.model.loadMap("Map test");
        Assert.assertEquals(6, this.model.getMap().getId());
    }
    
    @Test
    public void testLoadElementSpriteRef() {
    	char expected = '#';
		Assert.assertEquals(expected, this.model.loadElementSpriteRef(1, 0, 1));
    }
    
    @Test
    public void testGetGameState() {
    	Assert.assertEquals(null, this.model.getGameState());
    }
    
    @Test
    public void testSetGameState() {
    	this.model.setGameState(GameState.Playing);
    	Assert.assertEquals(GameState.Playing, this.model.getGameState());
    }


}
