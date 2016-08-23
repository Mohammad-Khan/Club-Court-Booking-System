import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 * In this test, I have checked that if the members and sports can be properly added to the club and then can be found as well.
 * The first line recorded is the object created of the Club class and then as there are no members in the newly
 * creates object, I checked a name i.e. "Mohammad Khan" and expected the output to be null. Then after, I added
 * 2 new members to the club by the name of "Mohammad Khan" and "Adnan Khan" respectively. I, then checked the 
 * findMember method by expecting a not null output by inserting "Mohammad Khan" and "Adnan Khan" respectively.
 * Then I checked a random name, which was never added to the club, and expected the output to be null.
 * Then I added "Tennis" to the sports list of club and then I checked the if "Cricket" is available in the club.
 * As Cricket was never added, I expected the output to be null. Then I checked through findSport of the club that
 * wether "Tennis" is available. As "Tennis" was added to the club, a not null value was expected.
 *
 * @author  Mohammad Khan
 * @version 20/04/2015
 */
public class ClubTest
{
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
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
    public void testClub()
    {
        Club club3 = new Club("Swinburne Sports");
        assertNull(club3.findMember("Mohammad Khan"));
        club3.addMember(new Member ("Mohammad Khan", 1));
        club3.addMember(new Member ("Adnan Khan", 3));
        assertNotNull(club3.findMember("adnan khan"));
        assertNotNull(club3.findMember("mohammad khan"));
        assertNull(club3.findMember("John"));
        club3.addSport(new Sport ("Tennis", 50, 60, 100));
        assertNull(club3.findSport("Cricket"));
        assertNotNull(club3.findSport("tennis"));
    }
}

