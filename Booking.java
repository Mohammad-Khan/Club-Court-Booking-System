import java.util.ArrayList;
/**
 * This class stores details of a booking
 * @author Mohammad Khan
 * @version 03-04-2015
 */

public class Booking
{
    private String startTime;
    private String endTime;
    private String bookingDate;
    private Court myCourt;
    private Member myMember;
    
    /**
     *This Booking Constructor demands no parameters.
     */
    public Booking ()
    {
    }    
    
    /**
     * When trying to create a new booking with booking date, booking start time and booking end time, this constructor comes in hands, 
     * innitiates all the instance variables of Booking class
     * @param String booking String, String start time, String end time
     */
    public Booking (String bookingDate, String startTime, String endTime, Member myMember)
    {
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.myMember = myMember;
    }
    
    /**
     * setMember - sets the member for this booking
     * @param Member to be assigned for this booking
     */
    
    public void setMember (Member aMember)
    {
        myMember = aMember;
    }
    
    /**
     * @return return the member assigned to this booking
     */
    
    public Member getMember ()
    {
        return myMember;
    }
    
    /**
     * setCourt - sets the court for this booking
     * @param court to be assigned for this booking
     */
    
    public void setCourt (Court aCourt)
    {
        myCourt = aCourt;
    }
    
    /**
     * @return return the court assigned to this booking
     */
    
    public Court getCourt ()
    {
        return myCourt;
    }
    
    /**
     * setBookingDate - sets the booking String
     * @param String booking String
     */
    public void setBookingDate (String bookingDate)
    {
        this.bookingDate = bookingDate;
    }
    
    /**
     * @return returns the booking String as String
     */
    public String getBookingDate ()
    {
        return bookingDate;
    }
    
    /**
     * setStartTime - sets the booking String
     * @param String booking String
     */
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    
    /**
     * @return returns the booking start time as String
     */
    public String getStartTime()
    {
        return startTime;
    }
    
    /**
     * setEndTime - sets the booking end time
     * @param String booking end time
     */
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    
    /**
     * @return returns the booking end time as String
     */    
    public String getEndTime()
    {
        return endTime;
    }
    
    
    /**
     * @return returns all the booking details and status as one string
     */ 
    public String getBookingDetails()
    {
        String bookingDetails = toString();
        return bookingDetails;
    }
    
    /**
     * @return returns all the booking details and status as one string
     */ 
    public String toString()
    {
        return ("Booking Date : " + bookingDate + "\nStart Time : " + startTime + "\nEnd Time : " + endTime  + "\nMember : " + myMember);
    }
}
