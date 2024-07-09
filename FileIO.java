/**
* This class reads and writes files
* @version ver 1.0.0
*/

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class FileIO
{  

    public final static String INPUT_FILENAME = "tourist.txt";

    private ArrayList<Tourist> touristGroups;

    public FileIO()
    {
        touristGroups = new ArrayList<>();
    }

    public FileIO(ArrayList<Tourist> touristGroups)
    {
        this.touristGroups = touristGroups;
    }

    /**
    * This method reads a file
    */
    public ArrayList<Tourist> readFile()
    {
        String[] items = {};
        Scanner scanner = null;
        try 
        {
            FileReader reader = new FileReader(INPUT_FILENAME);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) 
            {
                
                String line = scanner.nextLine();
                items = line.split(",");
                int groupSize = 0;
                for(int i = 0; i < items.length; i++)
                {
                    try
                    {
                        groupSize = Integer.parseInt(items[i]);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    if (groupSize > 0)
                    {
                        Tourist tourist = new Tourist(groupSize);
                        touristGroups.add(tourist);
                    }   
                }
            } 
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        finally
        {
            scanner.close();
        }

        return touristGroups;
    }

    /**
    * This method writes to a file
    */
        public void writeFile(String text)
        {
            try {
                FileWriter writer = new FileWriter("populationFinal.txt");
                writer.append(text);
                writer.close();

            } catch (Exception e) {
                System.out.println("Error in writing to file! Exiting...");
            }
        }
    
}