/**
* This class creates quokkas for our simulation
* @version ver 1.0.0
*/

public class Quokka
{
    private String id;
    private boolean hasBaby;
    private int foodSupply;
    private boolean isAlive;
    private int consecutiveDaysStarved;
    private int numberOfDaysStarved;

    public Quokka()
    {
        id = "Qnnn";
        hasBaby = false;
        foodSupply = 0;
        isAlive = true;
        consecutiveDaysStarved = 0;
        numberOfDaysStarved = 0;
    }

    public Quokka(String id, boolean hasBaby, int foodSupply)
    {   
        //this.id = id;
        Validation valid = new Validation();
        if (valid.stringCheckEmpty(id))
            {
                if(valid.stringCheckLengthRange(id, 4, 4))
                    this.id = id;
                else
                    throw new IllegalArgumentException("ID should be formatted as Qnnn");
            }
        else
            throw new IllegalArgumentException("ID must not be empty");  

        //this.foodSupply = foodSupply;
        if(valid.checkIntRange(foodSupply, 0, 9999))
            this.foodSupply = foodSupply;
        else
            throw new IllegalArgumentException("Food supply cannot be negative");

        this.hasBaby = hasBaby;
        isAlive = true;
        consecutiveDaysStarved = 0;
        numberOfDaysStarved = 0;      
    }
   
    /**
    * This method displays the state of Quokka
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method returns the int of how many consecutive days a quokka has starved
    */
    public int getConsecutiveDaysStarved()
    {
        return consecutiveDaysStarved;
    }

    /**
    * This method returns the food supply of a quokka
    */
    public int getFoodSupply()
    {
        return foodSupply;
    }

    /**
    * This method returns the id of a quokka
    */
    public String getId()
    {
        return id;
    }

    /**
    * This method returns the boolean of whether a quokka is alive
    */
    public boolean getIsAlive()
    {
        return isAlive;
    }

    /**
    * This method returns the boolean of whether a quokka has a baby
    */
    public boolean getHasBaby()
    {
        return hasBaby;
    }

    /**
    * This method returns the number of days that a quokka has starved for
    */
    public int getNumberOfDaysStarved()
    {
        return numberOfDaysStarved;
    }

    /**
    * This method sets the int of how many consecutive days a quokka has starved
    * @param    consecutiveDaysStarved   An int passed in as the consecutive days a quokka has starved
    */
    public void setConsecutiveDaysStarved(int consecutiveDaysStarved)
    {
        Validation valid = new Validation();
        if (valid.checkIntRange(consecutiveDaysStarved, 0, 2))
            this.consecutiveDaysStarved = consecutiveDaysStarved;
        else
            throw new IllegalArgumentException("Value must be between 0 and 2");        
    }

    /**
    * This method sets the food supply of a Quokka object
    * @param    foodSupply   An int passed in as the food supply of a quokka
    */
    public void setFoodSupply(int foodSupply)
    {
        Validation valid = new Validation();
        if (valid.checkIntRange(foodSupply, 0, 9999))
            this.foodSupply = foodSupply;
        else
            throw new IllegalArgumentException("Value must not be negative");
    }

    /**
    * This method sets the id of a Quokka object
    * @param    id   A String passed in as the id of a Quokka which needs to be between 1 to 999
    */
    public void setId(String id)
    {   
        Validation valid = new Validation();
        if (valid.stringCheckLengthRange(id, 4, 4))
            this.id = id;
        else 
            throw new IllegalArgumentException("ID should be formatted as Qnnn");
    }

    /**
    * This method sets the boolean of whether a Quokka object is alive
    * @param    isAlive   A boolean passed in as status of isAlive
    */
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    /**
    * This method sets the boolean of whether a Quokka object has a baby
    * @param    hasBaby   A boolean passed in as status of hasBaby
    */
    public void setHasBaby(boolean hasBaby)
    {   
        if(isAlive)
            this.hasBaby = hasBaby;         
        else 
            this.hasBaby = false;
    }

    /**
    * This method sets the number of days that a Quokka object has starved
    * @param    numberOfDaysStarved   An int passed in as the number of days a Quokka has starved
    */    
    public void setNumberOfDaysStarved(int numberOfDaysStarved)
    {
        Validation valid = new Validation();
        if (valid.checkIntRange(numberOfDaysStarved, 0, 5))
            this.numberOfDaysStarved = numberOfDaysStarved;
        else
            throw new IllegalArgumentException("Value must be between 0 and 5");
    }

    /**
    * This method returns the state of Quokka as a String
    */
    public String toString()
    {
        return "\nID: " + id + "\nHas a baby?: " + hasBaby + "\nFood supply: " + foodSupply 
                + "\nIs alive:? " + isAlive + "\nConsecutive days starved: " + consecutiveDaysStarved + "\nNumber of days starved: " + numberOfDaysStarved;
    }
}