/**
* This class creates tourist groups for our simulation
* @version ver 1.0.0
*/

public class TouristGroup
{
    private int size;
    private String groupSelfieType; 
    private boolean selfieIsTaken;
    private int selfiePaymentGiven;

    public TouristGroup()
    {
        size = 0;
        groupSelfieType = "unknown";
        selfieIsTaken = false;
        selfiePaymentGiven = 0;
    }

    public TouristGroup(int size, String groupSelfieType, boolean selfieIsTaken, int selfiePaymentGiven)
    {
        this.size = size;
        this.groupSelfieType = groupSelfieType;
        this.selfieIsTaken = selfieIsTaken;
        this.selfiePaymentGiven = selfiePaymentGiven;
    }

    /**
    * This method calculates a selfie for a TouristGroup object
    */
    public void calculateSelfie(boolean hasBaby)
    {   
        Random type = new Random(1, 100);
        int random = type.generateRandomNumber();
        Validation validRange = new Validation ();

        Photo photo = new Photo();
        Video video = new Video();
        Sketch sketch = new Sketch();

        if (size > 1)
        {
            if (validRange.checkIntRange(random, 1, 63))
                {
                    groupSelfieType = "photo";
                    photo.calculatePhotoPayment(hasBaby, size);
                    setSelfiePaymentGiven(photo.getPayment());
                    setSelfieIsTaken(true);
                }
            else if (validRange.checkIntRange(random, 64, 100))
                {
                    groupSelfieType = "video";        
                    video.calculateVideoPayment(hasBaby, size);
                    setSelfiePaymentGiven(video.getPayment());
                    setSelfieIsTaken(true);
                }
        }
        else //if group size = 1
        {
            if (validRange.checkIntRange(random, 1, 60))
                {
                    groupSelfieType = "photo";
                    photo.calculatePhotoPayment(hasBaby, size);
                    setSelfiePaymentGiven(photo.getPayment());
                    setSelfieIsTaken(true);
                }
            else if (validRange.checkIntRange(random, 61, 95))
                {
                    groupSelfieType = "video";
                    video.calculateVideoPayment(hasBaby, size);
                    setSelfiePaymentGiven(video.getPayment());
                    setSelfieIsTaken(true);
                }
            else
                {
                    groupSelfieType = "sketch";
                    sketch.calculateSketchPayment(hasBaby);
                    setSelfiePaymentGiven(sketch.getPayment());
                    setSelfieIsTaken(true);
                }
        }
    }

    /**
    * This method calculates the size of a TouristGroup object
    */
    public void calculateTouristGroupSize()
    {   
        Random groupSize = new Random(1, 100);
        int random = groupSize.generateRandomNumber();
        Validation validRange = new Validation ();
 
        if (validRange.checkIntRange(random, 1, 30))
            {
                size = 1;
            }
        else if (validRange.checkIntRange(random, 31, 60))
            {
                size = 2;
            }
        else if (validRange.checkIntRange(random, 61, 70))
            {
                size = 3;
            }
        else if (validRange.checkIntRange(random, 71, 80))
            {
                size = 4;
            }
        else if (validRange.checkIntRange(random, 81, 90))
            {
                size = 5;
            }
        else
            {
                size = 6;
            }
    }

    /**
    * This method displays the state of TouristGroup
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method returns the selfie type of a TouristGroup object
    */
    public String getGroupSelfieType() 
    {
        return groupSelfieType;
    }

    /**
    * This method returns the boolean of whether a selfie has been taken for a TouristGroup object
    */
    public boolean getSelfieIsTaken() 
    {
        return selfieIsTaken;
    }

    /**
    * This method returns the int payment that a TouristGroup gives for a selfie taken
    */
    public int getSelfiePaymentGiven() 
    {
        return selfiePaymentGiven;
    }

    /**
    * This method returns the size of a TouristGroup object
    */
    public int getSize() 
    {
        return size;
    }

    /**
    * This method sets the selfie type of a TouristGroup object
    * @param    groupSelfieType   A String passed in as the selfie type of a TouristGroup
    */
    public void setGroupSelfieType(String groupSelfieType)
    {
        this.groupSelfieType = groupSelfieType;
    }

    /**
    * This method sets the boolean of whether a TouristGroup object has taken a selfie
    * @param    selfieIsTaken   A boolean passed in as status of selfieIsTaken
    */
    public void setSelfieIsTaken(boolean selfieIsTaken)
    {
        this.selfieIsTaken = selfieIsTaken;
    }

    /**
    * This method sets the int payment given by a TouristGroup for a selfie
    * @param    selfiePaymentGiven   An int passed in as the payment given for a selfie
    */
    public void setSelfiePaymentGiven(int selfiePaymentGiven) 
    {
        this.selfiePaymentGiven = selfiePaymentGiven;
    }

    /**
    * This method sets the size of a TouristGroup object
    * @param    size   An int passed in as the size of a TouristGroup object
    */
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
    * This method returns the state of TouristGroup as a String
    */
    public String toString()
    {
        return "\nSize of group: " + size + "\nSelfie type: " + groupSelfieType + "\nHas taken selfie?: " + selfieIsTaken;
    }
}