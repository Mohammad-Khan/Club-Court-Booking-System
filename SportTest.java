

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The SportTest Class.
 *
 * @author  Mohammad Khan
 * @version 20/04/2015
 */
public class SportTest
{
    /**
     * Default constructor for test class SportTest
     */
    public SportTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSport()
    {
        Sport sport2 = new Sport("Tennis", 50, 60, 100);
        sport2.addCourt(new Court (2));
        assertNotNull(sport2.getCourt());
        assertEquals("Tennis", sport2.getSportName());
    }
}

