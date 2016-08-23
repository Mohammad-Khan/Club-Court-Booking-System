

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookingTest.
 *
 * @author  Mohammad Khan
 * @version 20/04/2015
 */
public class BookingTest
{
    /**
     * Default constructor for test class BookingTest
     */
    public BookingTest()
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
    public void testBooking()
    {
        Booking booking1 = new Booking("20/04/2015", "15:30", "16:30", new Member ("Adnan Khan", 2));
        booking1.setCourt(new Court(2));
        assertNotNull(booking1.getCourt());
        assertEquals("16:30", booking1.getEndTime());
        assertEquals("20/04/2015", booking1.getBookingDate());
    }
}

