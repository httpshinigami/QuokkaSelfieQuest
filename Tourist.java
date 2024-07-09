/**
* This class creates the amount of tourist groups for a given day
* @version ver 1.0.0
*/

public class Tourist
{
    private int amountOfGroups;

    public Tourist()
    {
        amountOfGroups = 0;
    }

    public Tourist(int amountOfGroups) 
    {
        this.amountOfGroups = amountOfGroups;
    }

    /**
    * This method displays the state of Tourist
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method returns the amount of tourist groups
    */
    public int getAmountOfGroups() 
    {
        return amountOfGroups;
    }

    /**
    * This method sets the amount of tourist groups
    * @param    amountOfGroups   An int passed in as the amount of tourist groups
    */
    public void setAmountOfGroups(int amountOfGroups)
    {
        this.amountOfGroups = amountOfGroups;
    }

    /**
    * This method returns the state of Tourist as a String
    */
    public String toString()
    {
        return "\nAmount of tourist groups: " + amountOfGroups;
    }
}