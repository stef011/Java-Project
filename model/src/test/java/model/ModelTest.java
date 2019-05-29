/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {
    private Model model;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.model = new Model();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMap() {
        Assert.assertEquals("Cellar", this.model.getMap().getName());
    }

    /**
     * Test method for {@link model.Model#loadHelloWorld(java.lang.String)}.
     */
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
}
