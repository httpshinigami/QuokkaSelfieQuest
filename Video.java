/**
* This class creates a video for our simulation
* @version ver 1.0.0
*/

public class Video extends Selfie 
{
    public Video()
    {
        super();
    }

    public Video(int payment)
    {
        super(payment);
    }

    /**
    * This method calculates the payment for a video
    */
    public void calculateVideoPayment(boolean hasBaby, int size)
    {   
        Random video = new Random(1, 60);
        int random = video.generateRandomNumber();
        Validation validRange = new Validation ();


        if (size > 1)
        {
            if (validRange.checkIntRange(random, 1, 20))
                {
                    //System.out.println("  Video duration: 20 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(4);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(2);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                }
            else if (validRange.checkIntRange(random, 21, 40))
                {
                    //System.out.println("  Video duration: 40 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(8);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(4);
                        //System.out.println("  Payment: " + super.getPayment());
                    }                    
                }
            else
                {
                    //System.out.println("  Video duration: 60 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(12);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(6);
                        //System.out.println("  Payment: " + super.getPayment());
                    }                    
                    //System.out.println("  Video duration: 60 seconds");
                }
        }
        else
        {
            if (validRange.checkIntRange(random, 1, 20))
                {
                    //System.out.println("  Video duration: 20 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(2);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(1);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                }
            else if (validRange.checkIntRange(random, 21, 40))
                {
                    //System.out.println("  Video duration: 40 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(4);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(2);
                        ///System.out.println("  Payment: " + super.getPayment());
                    }                    
                }
            else
                {
                    //System.out.println("  Video duration: 60 seconds");
                    if (hasBaby)
                    {
                        super.setPayment(6);
                        //System.out.println("  Payment: " + super.getPayment());
                    }
                    else
                    {
                        super.setPayment(3);
                        //System.out.println("  Payment: " + super.getPayment());
                    }                    
                    //System.out.println("  Video duration: 60 seconds");
                }
        }
    }

    @Override
    /**
    * This method displays the state of Sketch
    */
    public void displayToString()
    {
        super.displayToString();
    }

    /**
    * This method returns the payment of a Video object
    */   
     public int getPayment()
     {
        return super.getPayment();
     }

    /**
    * This method sets the payment of a Video object
    *  @param   payment    An int passed in as the payment of a Video
    */
    public void setPayment(int payment)
    {
        super.setPayment(payment);
    }

    /**
    * This method returns the state of Video as a String
    */
    public String toString()
    {
        return super.toString();
    } 
}