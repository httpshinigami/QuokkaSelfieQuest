/**
* This class creates a sketch for our simulation
* @version ver 1.0.0
*/

public class Sketch extends Selfie //need get and set method
{
    public Sketch()
    {
        super();
    }

    public Sketch(int payment)
    {
        super(payment);
    }

    /**
    * This method calculates the payment for a sketch
    */
    public void calculateSketchPayment(boolean hasBaby)
    {   
        Random sketch = new Random(1, 100);
        int random = sketch.generateRandomNumber();
        Validation validRange = new Validation ();
 
        if (validRange.checkIntRange(random, 1, 50))
            {
                //System.out.println("  Pose duration: 5 minutes");
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
            }
        else
            {
                //System.out.println("  Pose duration: 10 minutes");
                if (hasBaby)
                {
                    super.setPayment(20);
                    //System.out.println("  Payment: " + super.getPayment());
                }
                else
                {
                    super.setPayment(10);
                    //System.out.println("  Payment: " + super.getPayment());
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
    * This method returns the payment of a Sketch object
    */   
     public int getPayment()
     {
        return super.getPayment();
     }

    /**
    * This method sets the payment of a Sketch object
    *  @param   payment    An int passed in as the payment of a Sketch
    */
    public void setPayment(int payment)
    {
        super.setPayment(payment);
    }

    /**
    * This method returns the state of Sketch as a String
    */
    public String toString()
    {
        return super.toString();
    } 
}