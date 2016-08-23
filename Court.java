import java.util.ArrayList;
/**
 * Stores details of a court
 * @author Mohammad Khan
 * @version 03-04-2015
 */

public class Court
{
    private int courtNumber;
    private ArrayList<Booking> myBookings;
    
    /**
     * This Court Constructor demands no parameters.
     */
    public Court()
    {
        myBookings = new ArrayList<Booking> ();
    }
    
    /**
     * When trying to create a new court with court number, this constructor comes in hands, 
     * innitiates the court number, the instance variable, of Court class
     * @param integer court number
     */
    public Court(int courtNumber)
    {
        this.courtNumber = courtNumber;
        myBookings = new ArrayList<Booking> ();
    }
    
    
    /**
     * setCourtNumber - sets the court number
     * @param integer court number
     */
    public void setCourtNumber(int courtNumber)
    {
        this.courtNumber = courtNumber;
    }
    
    /**
     * getCourtNumber - returns the court number
     * @return integer court number
     */
    public int getCourtNumber ()
    {
        return courtNumber;
    }
    

    /**
     * addBooking - adds the booking made for the sport and records the booking String, booking start time and booking end time
     * @param Booking to be made for this court
     */
    
    public void addBooking (Booking aBooking)
    {
        boolean ifBookingExist = findBooking(aBooking.getBookingDate(), aBooking.getStartTime()); //checking if the booking already exist for the member
        
        if (!ifBookingExist) //if the booking already does not exist
        {
              myBookings.add(aBooking);
        }
    }
    
    
    /**
     * cancelBooking - removes the booking that booking list of court has
     * @param Booking to be cancelled
     */
    public void cancelBooking (Booking aBooking)
    {
        boolean ifBookingExist = findBooking(aBooking.getBookingDate(), aBooking.getStartTime()); //checking if the booking exist that court is trying to remove
        
        if (ifBookingExist) //if the booking already does exist
        {       
            myBookings.remove(aBooking); //remove the booking
        }
    }
    
    
    /**
     * checkAvailailabity - Checks the booking time and date with all the other already made bookings.
     * @param Booking to be checked for availablity
     * @return returns boolean true if the booking is allowed to be made, false otherwise
     */
    public boolean checkCourtAvailability (String bookingDate, String startTime)
    {
        for (Booking b:myBookings) //go thorugh booking list of the member to find if the member has this specific booking
        {
        
            String date = b.getBookingDate(); //get booking String for each booking of the court, unless found or list finished
            String time = b.getStartTime(); //get start time of each booking of the court, unless found or list finished
            
            if(date.equals(bookingDate) && time.equals(startTime)) //check each retrieved booking String and booking start time for each booking of the court agianst the booking date and time of the booking being checked for availaibilty
            {
                return false; //if matching String and start time found, return false, as the booking is not allowed to be made
            }
        } 
        return true; //return true if the booking is not found with matching String and time and is allowed to be made
    }

        
    /**
     * findBooking - Finds the specific booking of the of the court for sport by booking date and booking start time
     * @param String booking date, String startTime
     * @return boolean true if booking found, false otherwise
     */
    
    public boolean findBooking (String bookingDate, String startTime)
    {
        
        for (Booking b:myBookings) //go through booking list of the member to find if the member has this specific booking
        {
        
            String date = b.getBookingDate(); //get booking String for each booking of the court, unless found or list finished
            String time = b.getStartTime(); //get start time of each booking of the court, unless found or list finished
            
            if(date.equals(bookingDate) && time.equals(startTime)) //check each retrieved booking String and booking start time for each booking of the member
            {
                return true; //if matching String and start time found, return true
            }
        } 
        return false; //return null if the booking is not found with matching String and time
    }
    
     /**
     * @return Returns details of the court
     */
    public String toString()
    {
        return ("The court number is : " + courtNumber + "\nTotal bookings for this court are : " + myBookings.size());
    }

}
