import java.util.ArrayList;
/**
 * This class stores details of sport
 * @author Mohammad Khan
 * @version 03-04-2015
 */
public class Sport
{
    private String sportName;
    private double usageFee;
    private double insuranceFee;
    private double affiliationFee;
    private ArrayList<Court> myCourts;
    
    /**
     *This Sport Constructor demands no parameters.
     */
    public Sport ()
    {
        myCourts = new ArrayList<Court>();
    }
    
    /**
     * When trying to create a new sport object with sport name, sport usage fee, sport insurance fee and sport affiliation fee, this constructor comes in hands, 
     * innitiates all the instance variables sport object
     * @param String sport name, double sport usage fee, double sport insurance fee, double sport affiliation fee
     */
    public Sport (String sportName, double usageFee, double insuranceFee, double affiliationFee)
    {
        this.sportName = sportName;
        this.usageFee = usageFee;
        this.insuranceFee = insuranceFee;
        this.affiliationFee = affiliationFee;
        myCourts = new ArrayList<Court>();
    }
    
    /**
     * setSportName - sets the sport name
     * @param String sport name
     */
    public void setSportName (String sportName)
    {
        this.sportName = sportName;
    }
    
    /**
     * getSportName - returns the sport name
     * @return String sport name
     */
    public String getSportName()
    {
        return sportName;
    }
    
    /**
     * setUsageFee - sets the sport usage fee
     * @param double sport usage fee
     */
    public void setUsageFee(double usageFee)
    {
        this.usageFee = usageFee;
    }
    
    /**
     * getUsageFee - returns the sport usage fee
     * @return double sport usage fee
     */
    public double getUsageFee()
    {
        return usageFee;
    }
    
    /**
     * setInsuranceFee - sets the sport Insurance fee
     * @param double sport insurance fee
     */
    public void setInsuranceFee(double insuranceFee)
    {
        this.insuranceFee = insuranceFee;
    }
    
    /**
     * getInsuranceFee - returns the sport Insurance fee
     * @return double sport insurance fee
     */
    public double getInsuranceFee()
    {
        return insuranceFee;
    }
    
    /**
     * setAffiliationFee - sets the sport affiliation fee
     * @param double sport affiliation fee
     */
    public void setAffiliationFee(double affiliationFee)
    {
        this.affiliationFee = affiliationFee;
    }
    
    /**
     * getAffiliationFee - returns the sport affiliation fee
     * @return double sport affiliation fee
     */
    public double getAffiliationFee()
    {
        return affiliationFee;
    }
    
    /**
     * add court takes a court and adds it to the list of courts that this sport can be played in
     * @param Court to be added to the list of courts for a particular sport
     */
    public void addCourt (Court aCourt)
    {
        myCourts.add(aCourt);
    }
    
    /**
     * @return returns ArrayList of courts
     */
    public ArrayList<Court> getCourt ()
    {
        return myCourts;
    }
        
    /**
     * getAllCourts - Creates a list of courts that this sport is played in
     * @return List of courts
     */
    public ListGenerator getAllCourts()
    {
       ListGenerator listC = new ListGenerator(); //creating new list
       
       if (myCourts.size() > 0) // if the sport has any courts to be played in
       {
            listC.addLine("Court Number");
            for (Court c:myCourts) 
            {
                String courts = "" + c.getCourtNumber();
                listC.addLine(courts); //adding court numbers
            } 
       } else
       {
            listC.addLine(sportName + " have no courts yet"); //if there exist no courts for this sport
       }      
       return listC;
    }
    
    /**
     * @return returns all the sport details and status as one string
     */ 
    public String getSportDetails()
    {
        String sportDetails = toString();
        return sportDetails;
    }
    
    /**
     * @return Returns details of the sport
     */
    public String toString()
    {
        return ("The sport name is : " + sportName + "\nThe usage fee for " + sportName + " is : " + usageFee + "\nThe insurance fee for " + sportName 
                + " is : " + insuranceFee + "\nThe affiliation fee for " + sportName + " is : " + affiliationFee);
    }
}
