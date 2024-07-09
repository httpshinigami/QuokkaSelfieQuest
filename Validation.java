/**
* This class provides validations
* @version ver 1.0.0
*/

public class Validation
{
    public Validation()
    {
        
    }

    /**
    * This method validates the whether a value is within range
    * @param    value   An int passed in the method to be validated
    * @param    min     An int passed in the method to set the minimum value
    * @param    max     An int passed in the method to set the maximum value
    */
    public boolean checkIntRange(int value, int min, int max)
    {
        boolean inRange = false;
        if ((value >= min) && (value <= max))
            return true;
        return inRange;
    }

    /**
    * This method validates whether a String is numeric
    * @param    value   A String passed in the method to be validated
    */
    public boolean checkNumeric(String value)
    {
        int i = 0;
        while(i < value.length())
        {
            if((value.charAt(i) < '0') || (value.charAt(i) > '9'))
                return false;
            i++;
        }
        return true;
    }

    /**
    * This method validates whether a String is empty
    * @param    value   A String passed in the method to be validated
    */
    public boolean stringCheckEmpty(String value)
    {          
        boolean isNull = false;
        if (!value.trim().isEmpty())
            return true;
        return isNull;
    }  

    /**
    * This method validates the length range of a String
    * @param    value   A String passed in the method to be validated
    * @param    min     An int passed in the method to set the minimum length
    * @param    max     An int passed in the method to set the maximum length
    */
    public boolean stringCheckLengthRange(String value, int min, int max)
    {
        boolean withinRange = false;
        if((value.length() >= min) && (value.length() <= max))
            withinRange = true;
        return withinRange;
    }
}