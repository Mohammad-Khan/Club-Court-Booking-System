 import java.util.ArrayList;
/**
 * This class stores details of a club
 * @author Mohammad Khan
 * @version 03-04-2015
 */
public class Club
{
    private String clubName;
    private ArrayList <Member> ourMembers;
    private ArrayList <Sport> ourSports;
    
    
    
    public Club()
    {
    }
    
    /**
     * The Club constructor demands only the name for the club, and initiates the instance vairiables
     * @param Club Name
     */
    
    public Club (String clubName)
    {

            clubName = clubName.trim(); //removing any mistyped whitespaces
            this.clubName = clubName;
            ourMembers = new ArrayList<Member>();
            ourSports = new ArrayList<Sport>();
        
    }
    
    /**
     * setClubName - sets the club name to provided parameter and returns true if club name succesfully assigned after checking some conditions
     * @param Club Name as String
     * @return boolean true if club name set successfully
     */
    
    public boolean setClubName (String clubName)
    {
        clubName = clubName.trim(); //removing any mistyped whitespaces
        boolean ifAlphabetsOnly = isAlpha(clubName); //checking if the club name is only alphabets
        
        if (ifAlphabetsOnly) //set club name if the parameter passed contains only alphabets, and return true
        {        
            this.clubName = clubName;
            return true;
        }
        return false; //if the string do not have only alphabets
    }
    
    /**
     * getClubName - is reponsible for returning club name as a string
     * @return Club name as a String
     */
    public String getClubName ()
    {
        return clubName;
    }
    
    /**
     * addMember - add a new member to the club's member collection and assigns a membership number
     * @param A member to be added
     */
    public void addMember(Member aMember)
    {  
         Member checkMember = findMember(aMember.getMemberName()); //Checking if this member has already been registered
         if (checkMember == null) //if not registered already, add a new member to the club
         {
              ourMembers.add(aMember);  
         }
        
    }
    
    
    /**
     * removeMember - Removes a member from club's member collection
     * @param Member to be removed
     */
    public void removeMember(Member aMember)
    {
            Member checkMember = findMember(aMember.getMemberName()); //checking if the member exist in club's member list
            if (checkMember != null) //if exist, remove it from the members list of the club and return true
            {
                ourMembers.remove(aMember);  
            }
    }
    
    
    /**
     * findMember - Finds a member from club's member collection to confirm the existence of the membership
     * @param Member Name
     * @return Member, if found. Otherwise returns null
     */
    public Member findMember (String memberName)
    {
        memberName = memberName.trim(); //removing any mistyped whitespaces
        for (Member m:ourMembers) //go through the members arraylist and find member with the same name as provided
        {
             String test = m.getMemberName();
             if(test.equalsIgnoreCase(memberName)) // if found return member, comparing member names without considering case
             {
                  return m;
             }
        }
        return null; // returns null, if the member name provided is not alphabets only or if the member with matching name could not be found
    }
    
    
    /**
     * @return ArrayList of all the members in the club
     */
    public ArrayList <Member> getAllMembers ()
    {
        return ourMembers;
    }
    
    
    /**
     * ListGenerator - Creates a list of members in the club along with their membership number
     * @return List of Members
     */
    public ListGenerator listAllMembers()
    {
       ListGenerator listM = new ListGenerator(); //creating new list
       
       if (ourMembers.size() > 0) // if the club has any members, then generate a list with membership number and member name
       {
            listM.addLine("Member Number", "Member Name");
            for (Member m:ourMembers) 
            {
                String memberNumber = "" + m.getMemberNumber(); //getting member number from member and then changing it to a string, as the list can only hold strings
                listM.addLine(memberNumber, m.getMemberName()); //adding records of members to the list
            } 
       } else
       {
            listM.addLine(clubName + " have no members registered yet"); //if there exist no members at all in the club
       }      
       return listM;
        
    }
    
    /**
     * addSport - Adds new sport to the list of sports that club offers
     * @param A sport to be added
     */
    
    public void addSport(Sport aSport)
    {
         ourSports.add(aSport); //add new sport to the sport list of club       
    }
    
    
    /**
     * removeSport - Removes sport from the list of sports that club offers
     * @param Sport to be removed
     */
    
    public void removeSport(Sport aSport)
    {
        Sport checkSport = findSport(aSport.getSportName()); //check if the club sports list has the sport to be removed
        if (checkSport != null) //if the sport was found in the list of club sports 
        {
            ourSports.remove(aSport); //removing sport
        } 
    }
    
    /**
     * findSport - Find sport from the list of sports that club offers
     * @param sportName
     * @return Sport if found, else return null
     */
    
    public Sport findSport (String sportName)
    {
        sportName = sportName.trim(); //remove any white spaces that could be mistyped while entering sport name
        
        for (Sport s:ourSports) //go through the collection of club sports
        {
            String test = s.getSportName(); 
            if(test.equalsIgnoreCase(sportName)) //check all the sports in the list against the provided, and ignore the string case
            {
                return s; //if found return the sports
            }
        } 
        return null; //if not found return null
    }
    
    
    /**
     * checkBookingClash checks if there is already a booking for the one trying to be made
     * @return boolean true if there is a clash, false otherwise
     */
    public boolean checkBookingClash (Booking aBooking, String sport)
    {

        boolean sportCheck = sportAllowed(aBooking, sport); // Checking if the sport is allowed for the member to book for
        if (sportCheck)
        {
            for (Member m:ourMembers)
            {
                ArrayList<Booking> myBookings = m.getAllBookings();
                for (Booking b:myBookings) //go through the bookings of the member
                {
                    String testDate = b.getBookingDate(); 
                    String testStartTime = b.getStartTime();
                    if(testDate.equals(aBooking.getBookingDate()) && testStartTime.equals(aBooking.getStartTime())) //check all the bookings of each member
                    {
                        return true; //if a clash is found
                    }
                } 
            }
        }
        return false;
        
    }
    
    /**
     * sportAllowed checks if the member who is trying to make the booking is allowed for the sport he is trying to make the booking for
     * @param Booking trying to be made, sport the booking is being made for
     * @return returns true if the sport is allowed, false otherwise
     */
    private boolean sportAllowed(Booking aBooking, String sport)
    {
        Member member = aBooking.getMember();
        ArrayList<Sport> sportsAllowed = member.getMemberSports();
        for (Sport s:sportsAllowed)
        {
            if (sport.equals(s.getSportName()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * @return ArrayList of all the sports played in club
     */
    
    public ArrayList<Sport> getAllSport ()
    {
        return ourSports;
    }
    
    /**
     * listAllSports - Go through the list of sports that club offers and generate a list to return
     * @return List of sports offered by the club
     */
    
    public ListGenerator listAllSports()
    {
       ListGenerator listS = new ListGenerator(); //creating a new list
       
       if (ourSports.size() > 0) //checking if the club has at least one sport to offer
       {
            listS.addLine("List of Sports at Swinburne Sports Club"); //adding list header
            for (Sport s:ourSports) //going through all the sports in the club's sports list
            {
                listS.addLine(s.getSportName()); //adding sports to the list, one by one
            } 
       } else
       {
            listS.addLine(clubName + " do not have any sports yet"); //if there are no sport at the club's sports list
       }
       return listS; //return list of sports
        
    }    
    
    /**
     * isAlpha - To check if the strings passed to it has nothing but alphabets
     * @param takes a string as input i.e. member name or sport name etc
     * @return boolean true, if the string passed has nothing but alphabets
     */
    
    private boolean isAlpha(String strToCheck) 
    {
        return strToCheck.matches("[a-zA-Z]+");
    }
    /**
     * @return Returns details of the club
     */
    public String toString()
    {
        return ("The club name is : " + clubName + "\nThe club has " + ourMembers.size() + " members" + "The club offers " + ourSports.size() + " sports");
    }
}
