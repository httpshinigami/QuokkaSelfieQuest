/**
* This class creates a selfie for our simulation
* @version ver 1.0.0
*/

public class Selfie
{
    private int payment;

    public Selfie()
    {
        payment = 0;
    }

    public Selfie(int payment)
    {
        this.payment = payment;
    }

    /**
    * This method displays the state of Selfie
    */
    public void displayToString()
    {
        System.out.println(toString());
    }
    
    /**
    * This method sets the payment of a Selfie
    */
    public int getPayment()
    {
        return payment;
    }

    /**
    * This method sets the payment of Selfie
    *  @param   payment    An int passed in as the payment of a Selfie
    */
    protected void setPayment(int payment)
    {
        this.payment = payment;
    }

    /**
    * This method returns the state of Selfie as a String
    */
    public String toString()
    {
        return "Payment: " + payment;
    }
}