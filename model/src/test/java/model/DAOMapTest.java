package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;

public class DAOMapTest {
	private Connection connection;
	private DAOMap daoMap;
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.daoMap = new DAOMap(connection);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
	public void testFind() {
    	Assert.assertEquals("Cellar", this.daoMap.find("Cellar").getName());
    	fail("Not implemented");
	}
}
