

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MemberTest.
 * In this test class, I added created a member instance first and then took addBooking, addSport, getBooking and findSport to be checked against expected outputs.
 * I added a new booking through addBooking and then checked bookings thorugh getBooking. As there were a booking added the result was expected to be not null.
 * Then I added a new sport "Tennis" to the member sport list. In the next step I checked the non added sport through findSport and expected the output to be null.
 * Then I checked the findSport for "Tennis" and as "Tennis" was added to the member sports list, a not null value was expected.
 *
 * @author  Mohammad Khan
 * @version 20/04/2015
 */
public class MemberTest
{
    /**
     * Default constructor for test class MemberTest
     */
    public MemberTest()
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
    public void testMember()
    {
        Member member1 = new Member("Mohammad Khan", 1);
        member1.addBooking(new Booking ("20/04/2015", "15:30", "16:30", new Member ("Adnan Khan", 2)));
        assertNotNull(member1.getAllBookings());
        member1.addSport(new Sport ("Tennis", 50, 60, 100));
        assertNull(member1.findSport("Football"));
        assertNotNull(member1.findSport("tennis"));
    }
}

