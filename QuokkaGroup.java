/**
* This class creates the quokkas for our simulation
* @version ver 1.0.0
*/

import java.util.ArrayList; 

public class QuokkaGroup
{
    private int quokkaNumber;
    private ArrayList<Quokka> quokkaArrayList;
    private int quokkaDeathToll;
    private int quokkaBirths;

    public QuokkaGroup()
    {
        quokkaNumber = 0;
        quokkaArrayList = new ArrayList<Quokka>();
        quokkaDeathToll = 0;
        quokkaBirths = 0;
    }

    public QuokkaGroup(int quokkaNumber, ArrayList<Quokka> quokkaArrayList, int quokkaDeathToll, int quokkaBirths)
    {
        this.quokkaNumber = quokkaNumber;
        this.quokkaArrayList = quokkaArrayList;
        this.quokkaDeathToll = quokkaDeathToll;
        this.quokkaBirths = quokkaBirths;
    }

    /**
    * This method returns the quokka ArrayList
    */
    public ArrayList<Quokka> getQuokkaArrayList() 
    {
        return quokkaArrayList;
    }      

    /**
    * This method checks the number of quokkas that we have in the simulation
    */
    public void checkNumberOfQuokkas()
    {
        boolean flag = false;
        do
        {
            Input inputQuokkas = new Input();
            String quokkaNumberTemp = inputQuokkas.acceptStringInput("\nHow many quokkas?");
            Validation validQuokkas = new Validation();

            if (validQuokkas.checkNumeric(quokkaNumberTemp))
            {
                quokkaNumber = Integer.parseInt(quokkaNumberTemp);
                if (validQuokkas.checkIntRange(quokkaNumber, 1, 999))
                    flag = true;
                else
                    System.out.println("Invalid input: please enter a number from 1 to 999");
            }
            else 
                System.out.println("Invalid input: please enter a number from 1 to 999");
        } while (!flag);
    }

    /**
    * This method counts the total alive quokkas on a day
    */
    public int countDailyAliveQuokkas()
    {  
        int aliveQuokkas = 0;
        for (Quokka alive : quokkaArrayList)
        {   
            if (alive.getIsAlive())
            {
                if(alive.getHasBaby())
                {
                    aliveQuokkas = aliveQuokkas + 2;
                }
                else
                {
                    aliveQuokkas++;
                }       
            }
        }
        return aliveQuokkas;
    }
    
    /**
    * This method returns the daily total food supply
    */
    public int countDailyTotalFoodSupply()
    {  
        int foodSupply = 0;
        for (Quokka food : quokkaArrayList)
        {
            foodSupply += food.getFoodSupply();
        }
        return foodSupply;
    }

    /**
    * This method creates Quokka objects stored in an ArrayList
    */
    public void createQuokkaArrayList()
    {   
        String id = "Q";
        for (int i = 0; i < quokkaNumber; i++)
        {   
            String qnnn = "00" + Integer.toString(i + 1); //i + 1 because quokka id starts from 1 and not 0
            //previous statement equates quokkka 20 to 0020, 
            //below statement takes substring of index 1 to index 4, giving us Q020
            id = "Q" + qnnn.substring(qnnn.length() - 3, qnnn.length());
            boolean hasBaby = determineHasBabyStatus();
            int foodSupply = hasBaby ? 3 : 2;
            Quokka quokka = new Quokka(id, hasBaby, foodSupply);
            quokkaArrayList.add(quokka);
        }
    }

    /**
    * This method deducts the quokka food supply at the end of each day
    */
    public void deductQuokkaFoodSupply()
    {   
        for (Quokka deductFood : quokkaArrayList)
        {
            if(deductFood.getIsAlive())
            {
                if(deductFood.getHasBaby())
                {
                    if(deductFood.getFoodSupply() >= 3)
                    {
                        deductFood.setFoodSupply(deductFood.getFoodSupply() - 3);
                        deductFood.setConsecutiveDaysStarved(0);
                    }
                    else
                    {
                        deductFood.setNumberOfDaysStarved(deductFood.getNumberOfDaysStarved() + 1);
                        deductFood.setConsecutiveDaysStarved(deductFood.getConsecutiveDaysStarved() + 1);
                    }
                }
                else    
                {
                    if(deductFood.getFoodSupply() >= 2)
                    {
                        deductFood.setFoodSupply(deductFood.getFoodSupply() - 2);
                        deductFood.setConsecutiveDaysStarved(0);
                    }
                    else
                    {
                        deductFood.setNumberOfDaysStarved(deductFood.getNumberOfDaysStarved() + 1);
                        deductFood.setConsecutiveDaysStarved(deductFood.getConsecutiveDaysStarved() + 1);
                    }

                }
            }
        }
    }

    /**
    * This method determines the hasBaby status of a quokka
    */
    public void determineDailyBirths()
    {  
        int newBabies = 0;
        for (Quokka birth : quokkaArrayList)
        {
            if (!birth.getHasBaby())
            {
                Random giveBirth = new Random(1, 100);
                int random = giveBirth.generateRandomNumber(); 
                Validation validRange = new Validation ();

                if (validRange.checkIntRange(random, 1, 5))
                {
                    birth.setHasBaby(true);
                    newBabies++;
                    quokkaBirths++;
                }
            }
        }
        System.out.println("  New Babies: " + newBabies);
    }

    /**
    * This method determines the hasBaby status of a quokka
    */
    public boolean determineHasBabyStatus()
    {   
        Random haveBaby = new Random(1, 100);
        int random = haveBaby.generateRandomNumber();
        Validation validRange = new Validation ();
 
        if (validRange.checkIntRange(random, 1, 20))
            return true;    
        else
            return false;
    }

    /**
    * This method displays the state of QuokkaGroup
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method fetches the amount of quokkas that are alive
    */
    public int fetchLiveQuokkaAmount()
    {
        int count = 0;
        for (Quokka quokkie : quokkaArrayList)
        {
            if (quokkie.getIsAlive())
                count++; 
        }
        return count;
    }

    /**
    * This method fetches a specific quokka
    * @param    index   An int passed in as the index of quokkaArrayList
    */
    public Quokka fetchASpecificQuokka(int index)
    {   
        return quokkaArrayList.get(index);
    }
    /**
    * This method returns the quokka births
    */
    public int getQuokkaBirths() 
    {
        return quokkaBirths;
    } 

    /**
    * This method returns the quokka death toll
    */
    public int getQuokkaDeathToll() 
    {
        return quokkaDeathToll;
    } 

    /**
    * This method returns the number of quokkas of a QuokkaGroup object
    */
    public int getQuokkaNumber() 
    {
        return quokkaNumber;
    } 
    
    /**
    * This method populates the summary for each day
    */
    public void populateDailySummary()
    {
        int deaths = 0;
        int food = 0;

        for (Quokka summary : quokkaArrayList)
        {   
            //number of deaths
            if(summary.getIsAlive() == false)
            {
                deaths++;
            }

            //total food supply      
            if(summary.getIsAlive())
            {
                food = food + summary.getFoodSupply();
            }                 
        }
        System.out.println("\nDaily Summary" + "\n===================");
        System.out.println("Number of live quokkas: " + (countDailyAliveQuokkas()));
        System.out.println("Number of deaths: " + deaths);
        System.out.println("Number of births: " + quokkaBirths);
        System.out.println("Total food supply: " + food);
    }

    /**
    * This method populates the summary for the entire simulation
    */
    public void populateSimulationSummary()
    { 
        double quokkaNumberDouble = quokkaNumber; //define as double to get decimals in the output
        
        //QSQSF
        double quokkaDeathTollDouble = getQuokkaDeathToll();
        System.out.println("\n========Quokka Selfie Quest Success Factor:");
                        //(1 -  (total_quokka_deaths / total_quokkas_at_start)) * 100
        double QSQSF = ((1 - (quokkaDeathTollDouble / quokkaNumberDouble)) * 100); 
        System.out.println(String.format("%,.2f", QSQSF) + "%");       

        //QPSF
        System.out.println("\n========Quokka Population Sustainability Factor:");
                        //(total_quokkas_at_end - total_quokkas_at_start) / total_quokkas_at_start
        double QPSF = ((countDailyAliveQuokkas() - quokkaNumberDouble) / quokkaNumberDouble);
        System.out.println(String.format("%,.2f", QPSF));
    }   

    /**
    * This method lets quokkas die if they have not eaten adequately
    */
    public void putQuokkasToEternalRest()
    {
        for (Quokka rest : quokkaArrayList)
        {
            if(rest.getIsAlive())
            {
                if(rest.getConsecutiveDaysStarved() == 2)
                {
                    rest.setIsAlive(false);
                    rest.setHasBaby(false);
                    quokkaDeathToll++;
                }
                else if (rest.getNumberOfDaysStarved() == 5)
                {
                    rest.setIsAlive(false);
                    rest.setHasBaby(false);
                    quokkaDeathToll++;
                }
            }
        }
    }

    /**
    * This method sets the quokka ArrayList
    * @param    quokkaArrayList   An ArrayList<Quokka> passed in as quokkaArrayList
    */
    public void setQuokkaArrayList(ArrayList<Quokka> quokkaArrayList)
    {
        this.quokkaArrayList = quokkaArrayList;
    }

    /**
    * This method sets the quokka births
    * @param    quokkaBirths   An int passed in as the quokka births
    */
    public void setQuokkaBirths(int quokkaBirths)
    {
        this.quokkaBirths = quokkaBirths;
    }
    
    /**
    * This method sets the quokka death toll
    * @param    quokkaDeathToll   An int passed in as the quokka death roll
    */
    public void setQuokkaDeathToll(int quokkaDeathToll)
    {
        this.quokkaDeathToll = quokkaDeathToll;
    }

    /**
    * This method sets the number of quokkas for a QuokkaGroup object
    * @param    quokkaNumber   An int passed in as the number of quokkas of QuokkaGroup
    */
    public void setQuokkaNumber(int quokkaNumber)
    {
        this.quokkaNumber = quokkaNumber;
    } 

    /**
    * This method displays each Quokka object in the quokkaArrayList
    */
    public void showTheQuokkas()
    {
        for (Quokka quokkie : quokkaArrayList)
        {
            quokkie.displayToString(); 
        }
    }

    /**
    * This method sorts the Quokka objects in the quokkaArrayList based on food supply
    */
    public void sortQuokkaArrayList()
    {   
        int length = quokkaArrayList.size();
        for (int i = 0; i < length - 1; i++)
        {
            for (int compare = 0; compare < length - 1 - i; compare++)
            {
                //get the amount of food for the quokka at the current index
                int currentFood = quokkaArrayList.get(compare).getFoodSupply();
                //get the amount of food for the quokka at the index after the current index
                int nextFood = quokkaArrayList.get(compare + 1).getFoodSupply();

                if (!quokkaArrayList.get(compare).getIsAlive()) 
                {
                    Quokka tempCurrent = quokkaArrayList.get(compare);
                    // swaps the current Quokka with the next Quokka in the ArrayList
                    quokkaArrayList.set(compare, quokkaArrayList.get(compare + 1)); //e.g. set index 1 to index 2
                    quokkaArrayList.set(compare + 1, tempCurrent); //e.g. set index 2 to index 1
                    //have to set current index to tempCurrent because it was gone when index 2 replaced it
                } 
                else if (currentFood > nextFood) 
                {
                    Quokka tempCurrent = quokkaArrayList.get(compare);
                    // swaps the current Quokka with the next Quokka in the ArrayList
                    quokkaArrayList.set(compare, quokkaArrayList.get(compare + 1));
                    quokkaArrayList.set(compare + 1, tempCurrent);
                }
            }    
        }   
    }
    
    /**
    * This method returns the state of QuokkaGroup as a String
    */
    public String toString()
    {
        return "\nNumber of quokkas: " + quokkaNumber + "\nArray list of quokkas: " + quokkaArrayList;
    }
}