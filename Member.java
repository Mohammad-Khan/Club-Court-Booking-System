import java.util.ArrayList;
/**
 * This class stores details of a member of the club
 * @author Mohammad Khan
 * @version 03-04-2015
 */
public class Member
{
    private String memberName;
    private int memberNumber;
    private ArrayList<Sport> mySports;
    private boolean isFinancial;
    private ArrayList<Booking> myBookings;
    
    /**
     *This Member Constructor demands for no parameters and innitiates the instance variables, to be used when no member name is required to pass here
     */
    public Member()
    {
        mySports = new ArrayList<Sport>();
        myBookings = new ArrayList<Booking>();
    }
    
    
    /**
     * When trying to create a new member with member name and automatically passed member number, this constructor comes in hands, 
     * innitiates all the instance variables of Member class
     * @param Member Name, Member Number
     */
    public Member(String memberName, int memberNumber)
    {
            this.memberName = memberName;
            this.memberNumber = memberNumber;
            mySports = new ArrayList<Sport>();
            myBookings = new ArrayList<Booking>();
    }
    
    
    /**
     * setMemberName - sets the Member name to provided parameter after checking some conditions
     * @param Member Name as String
     */
    public void setMemberName (String memberName)
    {
        boolean isAlphabetsOnly = isAlpha (memberName);
        if (isAlphabetsOnly)
        {
            this.memberName = memberName;
        }
    }
    
    
    /**
     * @returns returns a string with member name
     */
    public String getMemberName()
    {
        return memberName;
    }
    
    
    /**
     * setMemberNumber - sets the Member number as provided parameter
     * @param Member number as integer
     */
    public void setMemberNumber(int memberNumber)
    {
        this.memberNumber = memberNumber;
    }
    
    
    /**
     * @return returns member number as int
    */
    public int getMemberNumber ()
    {
        return memberNumber;
    }
    
    /**
     * setIsFinancial - sets the Member status if the member is financial or otherwise, takes a parameter to decide it
     * @param boolean isFinancial
     */
    
    public void setIsFinancial(boolean isFinancial)
    {
        this.isFinancial = isFinancial;
    }
    
    /**
    * @return returns member status for being financial or otherwise, as boolean true or false
    */
    public boolean getIsFinancial()
    {
        return isFinancial;
    }
    

    
    /**
     * addSport - Adds new sport to the list of sports that member has
     * @param A sport to be added
     */
    
    public void addSport(Sport aSport)
    {
        Sport checkSport = findSport(aSport.getSportName()); //check if the member already has the sport on member's sports list
        
        if (checkSport == null) //if the sport does not already exist
        {
            mySports.add(aSport); //add new sport to the sport list of Member
        } 
        
    } 
    
    /**
     * @return All the sports the member is registered in
     */
    public ArrayList<Sport> getMemberSports ()
    {
        return mySports;
    }
   
    
    /**
     * removeSport - Removes sport from the list of member sports
     * @param Sport to be removed from member's sports list
    */
    
    public void removeSport(Sport aSport)
    {
        Sport checkSport = findSport(aSport.getSportName()); //check if the member sports list has the sport to be removed
        if (checkSport != null) //if the sport was found in the list of member sports 
        {
            mySports.remove(aSport); //removing sport
        } 

    }
    
    
    /**
     * addBooking - adds the booking made by the member and records the booking Stringm booking start time and booking end time
     * @param A booking to be added
    */
    public void addBooking (Booking aBooking)
    {
        boolean ifAlreadyExist = isOkToBook(aBooking.getBookingDate(), aBooking.getStartTime()); //checking if the booking already exist for the member
        
        if (!ifAlreadyExist) //if the booking already does not exist
        {
            myBookings.add(aBooking);
        }
    }
    
    /**
     * removeBooking - removes the booking that member wants to remove by providing booking String and booking start time
     * @param String booking String, String start time
     */
    public void deleteBooking (Booking aBooking)
    {
        boolean ifBookingExist = isOkToBook(aBooking.getBookingDate(), aBooking.getStartTime()); //checking if the booking exist that member is trying to remove
        
        if (ifBookingExist) //if the booking already does exist
        {       
            myBookings.remove(aBooking); //remove the booking returned by the findBooking
        }
    }
    
     /**
     * Finds the specific booking of the member by matching booking String and booking start time
     * @param String booking String, String startTime
     * @return returns boolean true if booking exist, false otherwise
     */
    
    public boolean isOkToBook (String bookingDate, String startTime)
    {
        if (isFinancial)
        {
            for (Booking b:myBookings) //go through booking list of the member to find if the member has this specific booking
            {
                String String = b.getBookingDate(); //get booking String for each booking of the member, unless found or list finished
                String time = b.getStartTime(); //get start time of each booking of the member, unless found or list finished
                
                if(String.equals(bookingDate) && time.equals(startTime)) //check each retrieved booking String and booking start time for each booking of the member
                {
                    return true; //if matching booking date and start time found, return the booking
                }
            } 
        }
        return false; //return false if the booking is not found with matching String and time
    }
    
    /**
     * @return Arraylist of all the bookings for the member
     */
    public ArrayList<Booking> getAllBookings()
    {
        return myBookings;
    }
    
    /**
     * listAllBookings - Creates a list of member's booking
     * @return List of Member's bookings
     */
    public ListGenerator listAllBookings()
    {
       ListGenerator listB = new ListGenerator(); //creating new list
       
       if (myBookings.size() > 0) // if the member has any bookings, then generate a list with membership number and member name
       {
            listB.addLine("Booking Number", "Booking Date", "Start Time", "End Time");
            for (Booking b:myBookings) 
            {
                String bookingNumber = "" + myBookings.indexOf(b); //getting booking number from booking list and then changing it to a string, as the list can only hold strings
                String bookingDate = "" + b.getBookingDate();
                String startTime = "" + b.getStartTime();
                String endTime = "" + b.getEndTime();
                listB.addLine(bookingNumber, bookingDate, startTime, endTime); //adding records of member's booking to the list
            } 
       } else
       {
            listB.addLine(memberName + " have no bookings made"); //if there exist no bookings for this member
       }     
       return listB;
    }
        
        
    
    /**
     * findSport - Find sport from the list of sports that member's sports list have
     * @param sportName
     * @return sport if found in the list of member's sports, otherwise return null
     */
    
    public Sport findSport (String sportName)
    {
        sportName = sportName.trim(); //remove any white spaces that could be mistyped while entering sport name
        
        for (Sport s:mySports) //go trhough the collection of club sports
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
     * isAlpha - To check if the strings passed to it has nothing but alphabets
     * @param takes a string as input i.e. member name or sport name etc
     * @return boolean true, if the string passed has nothing but alphabets
     */
    private boolean isAlpha(String strToCheck) 
    {
        return strToCheck.matches("[a-zA-Z]+");
    }
    
    /**
     * @return Returns details of the member
     */
    public String toString()
    {
        return ("The member name is : " + memberName + "\nThe member number is : " + memberNumber + "The member is registered for " + mySports.size() + " sports"
                + "\nThe member has made : " + myBookings.size() + "\nThe member is financial : " + isFinancial);
    }
        
}
