/**
* This class creates a photo for our simulation
* @version ver 1.0.0
*/

public class Photo extends Selfie
{
    public Photo()
    {
        super();

    }

    public Photo(int payment)
    {
        super(payment);
    }

    /**
    * This method calculates the payment for a video
    */
    public void calculatePhotoPayment(boolean hasBaby, int size)
    {   
        if (size > 1)
        {
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
        
        else
        {
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
    }

    @Override
    /**
    * This method displays the state of Photo
    */
    public void displayToString()
    {
        super.displayToString();
    }

    /**
    * This method returns the payment of a Photo object
    */   
     public int getPayment()
     {
        return super.getPayment();
     }   

    /**
    * This method sets the payment of a Photo object
    *  @param   payment    An int passed in as the payment of a Photo
    */
    public void setPayment(int payment)
    {
        super.setPayment(payment);
    }

    /**
    * This method returns the state of Photo as a String
    */
    public String toString()
    {
        return super.toString();
    } 
}