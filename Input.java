/**
* This class accepts input from user
* @version ver 1.0.0
*/

import java.util.Scanner;

public class Input
{
    public Input()
    {
        
    }

    /**
    * This method accepts an int input from user
    * @param    displayMessage   A String which tells the user what kind of input is required
    */
    public int acceptIntInput(String displayMessage)
    {   
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        
        int input = console.nextInt();
        return input;
    }

    /**
    * This method accepts String input from user
    * @param    displayMessage   A String which tells the user what kind of input is required
    */
    public String acceptStringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String input = console.nextLine();
        return input;
    }

}