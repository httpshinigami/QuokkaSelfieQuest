/**
* This class generates a random number
* @version ver 1.0.0
*/

public class Random
{
    private int minimum;
    private int maximum;

    public Random()
    {
        minimum = 0;
        maximum = 0;
    }

    public Random(int minimum, int maximum)
    {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
    * This method displays the state of Random
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method generates and returns a random number
    */
    public int generateRandomNumber()
    {
        int range = (maximum - minimum) + 1;
        int random = (int)(Math.random() * range + minimum);
        return random;
    }

    /**
    * This method returns the maximum value for the random number generator
    */
    public int getMaximumNumber()
    {
        return maximum;
    }

    /**
    * This method returns the minimum value for the random number generator
    */
    public int getMinimumNumber()
    {
        return minimum;
    }

    /**
    * This method sets the maximum value for the random number generator
    * @param    maximum     An int passed in as the maximum value
    */
    public void setMaximumNumber(int maximum)
    {
        this.maximum = maximum;
    }

    /**
    * This method sets the minimum value for the random number generator
    * @param    minimum     An int passed in as the minimum value
    */
    public void setMinimumNumber(int minimum)
    {
        this.minimum = minimum;
    }

    /**
    * This method returns the state of random as a String
    */
    public String toString()
    {
        return "Maximum: " + maximum + ", Minimum: " + minimum;
    }
}