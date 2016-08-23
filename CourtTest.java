

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * In this TestCourt class, I have first created the court object and then checked for a court availabitlity for a particular date and time. 
 * As there were no bookings yet, the checkAvailalabilty should return true as it is available. After that I added a booking to the court and then checkedAvailability
 * for the same date and time. The expected result is false, as the there is already a booking for same date and time.
 *
 * @author  Mohammad Khan
 * @version 20/04/2015
 */
public class CourtTest
{
    /**
     * Default constructor for test class CourtTest
     */
    public CourtTest()
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
    public void testCourt()
    {
        Court court1 = new Court(2);
        assertEquals(true, court1.checkCourtAvailability("23/04/2015", "15:30"));
        court1.addBooking(new Booking("23/04/2015", "15:30", "16:30", new Member ("Adnan Khan", 2)));
        assertEquals(false, court1.checkCourtAvailability("23/04/2015", "15:30"));
        assertEquals(true, court1.findBooking("23/04/2015", "15:30"));
    }
}

