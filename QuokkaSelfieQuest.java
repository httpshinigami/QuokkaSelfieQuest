/**
* This class executes the Quokka Selfie Quest simulation
* @version ver 1.0.0
*/

import java.util.ArrayList;

public class QuokkaSelfieQuest
{ 
    private ArrayList<Tourist> touristCountArrayList;
    private ArrayList<ArrayList<TouristGroup>> simulationTouristGroupArrayList;
    private QuokkaGroup quokkaGroup;

    public QuokkaSelfieQuest()
    {
        touristCountArrayList = new ArrayList<>();
        simulationTouristGroupArrayList = new ArrayList<>();
        quokkaGroup = new QuokkaGroup();
    }

    public QuokkaSelfieQuest(ArrayList<Tourist> touristCountArrayList, ArrayList<ArrayList<TouristGroup>> simulationTouristGroupArrayList, QuokkaGroup quokkaGroup)
    {
        this.touristCountArrayList = touristCountArrayList;
        this.simulationTouristGroupArrayList = simulationTouristGroupArrayList;
        this.quokkaGroup = quokkaGroup;
    }
    
    /**
    * This method creates TouristGroup objects equal to the amount of groups of tourists on a particular day
    */
    public void createTouristGroups()
    {
        for (Tourist dailyGroups: touristCountArrayList)
        {
            int groupAmount = dailyGroups.getAmountOfGroups();
            ArrayList<TouristGroup> dailyTouristGroupArrayList = new ArrayList<TouristGroup>();
            for (int i = 0; i < groupAmount; i++)
            {
                TouristGroup touristGroup = new TouristGroup();
                touristGroup.calculateTouristGroupSize(); 
                dailyTouristGroupArrayList.add(touristGroup);
            }
            simulationTouristGroupArrayList.add(dailyTouristGroupArrayList);
        }
    }   

    /**
    * This method displays the state of QuokkaSelfieQuest
    */
    public void displayToString()
    {
        System.out.println(toString());
    }

    /**
    * This method gives us the amount of tourist groups each day over the 30 day simulation
    */
    public void fetchTouristGroups()
    {   
        FileIO tourists = new FileIO();
        touristCountArrayList = tourists.readFile();
    }

    /**
    * This method provides the header of each day of the simulation
    * @param    day   An int passed in as the day of the simulation
    * @param    size   An int passed in as the number of the tourist groups
    */
    public void generateSimulationHeader(int day, int size)
    {   
        System.out.println("\n---------------Day " + day + "---------------");      
        quokkaGroup.determineDailyBirths();
        System.out.println("  Current alive quokkas (incl babies): " + quokkaGroup.countDailyAliveQuokkas());
        quokkaGroup.countDailyTotalFoodSupply();
        System.out.println("- Sorting the quokkas based on their level of food supply");
        quokkaGroup.sortQuokkaArrayList();
        System.out.println("  Number of tourist groups: " + size);
        System.out.println("- Initialising the tourist groups");
        System.out.println("- Quokkas are now offering selfies to the tourist groups");
    }

    /**
    * This method returns quokkaGroup
    */
    public QuokkaGroup getQuokkaGroup() 
    {
        return quokkaGroup;
    }

    /**
    * This method returns simulationTouristGroupArrayList
    */
    public ArrayList<ArrayList<TouristGroup>> getSimulationTouristGroupArrayList() 
    {
        return simulationTouristGroupArrayList;
    }

    /**
    * This method returns touristCountArrayList
    */
    public ArrayList<Tourist> getTouristCountArrayList() 
    {
        return touristCountArrayList;
    }

    /**
    * This is the main method which begins the program execution
    * @param    args    An array of String passed in as command line parameters
    */
    public static void main(String[] args)
    {
        QuokkaSelfieQuest startProgram = new QuokkaSelfieQuest();
        startProgram.simulation();
    }

    /**
    * This method sets simulationTouristGroupArrayList
    * @param    simulationTouristGroupArrayList   An ArrayList<ArrayList<TouristGroup>> passed in as simulationTouristGroupArrayList
    */
    public void setSimulationTouristGroupArrayList(ArrayList<ArrayList<TouristGroup>> simulationTouristGroupArrayList) 
    {
        this.simulationTouristGroupArrayList = simulationTouristGroupArrayList;
    }

    /**
    * This method sets quokkaGroup
    * @param    quokkaGroup   An QuokkaGroup passed in as quokkaGroup
    */
    public void setQuokkaGroup(QuokkaGroup quokkaGroup) 
    {
        this.quokkaGroup = quokkaGroup;
    }

    /**
    * This method sets touristCountArrayList
    * @param    touristCountArrayList   An ArrayList<Tourist> passed in as touristCountArrayList
    */
    public void setTouristCountArrayList(ArrayList<Tourist> touristCountArrayList)
    {
        this.touristCountArrayList = touristCountArrayList;
    }
    
    /**
    * This method gives us the quokkas that will be used in the simulation
    */
    public void setUpQuokkaGroups()
    {
        quokkaGroup.checkNumberOfQuokkas();
        quokkaGroup.createQuokkaArrayList();
        //quokkaGroup.showTheQuokkas();
    }

    /**
    * This method executes the events over the duration of the simulation
    */
    public void simulate()
    {   
        int day = 1; //index for each day
        for (ArrayList<TouristGroup> dailyGroups : simulationTouristGroupArrayList)
        {   
            generateSimulationHeader(day, dailyGroups.size());
            int quok = 0; //index for each quokka
            int length = quokkaGroup.fetchLiveQuokkaAmount() - 1; //amount of alive quokkas we are working with (-1 due to ArrayList indexing)
            for (TouristGroup aGroup : dailyGroups) 
            {
                    //check if the next quokka in arraylist is dead
                    //only alive quokkas should get a chance to offer a selfie
                    if ((!quokkaGroup.fetchASpecificQuokka(quok).getIsAlive()) || (quok == length)) 
                    {
                        quok = 0;
                    }
                    else 
                    {
                        Quokka currentQuokka = quokkaGroup.fetchASpecificQuokka(quok);
                        boolean hasBaby = currentQuokka.getHasBaby();
                        aGroup.calculateSelfie(hasBaby);
                        currentQuokka.setFoodSupply(currentQuokka.getFoodSupply() + aGroup.getSelfiePaymentGiven());
                        quok++;
                    }
            }
            quokkaGroup.deductQuokkaFoodSupply();
            quokkaGroup.putQuokkasToEternalRest();
            quokkaGroup.populateDailySummary();
            day++;
        }
    }

    /**
    * This method calls the methods that are needed to run the entire program
    */
    public void simulation()
    {
        System.out.println("Welcome to the Quokka Selfie Quest Simulation!");
        fetchTouristGroups();
        setUpQuokkaGroups();
        createTouristGroups();
        simulate();
        quokkaGroup.populateSimulationSummary();
        writeToFile();
    }

    /**
    * This method writes to file
    */
    public void writeToFile()
    {   
        String text = "Number of live quokkas: " + quokkaGroup.countDailyAliveQuokkas() + "\nNewborn quokkas: " + quokkaGroup.getQuokkaBirths() 
                        + "\nDead quokkas: " + quokkaGroup.getQuokkaDeathToll() + "\nTotal food supply: " + quokkaGroup.countDailyTotalFoodSupply();
        FileIO write = new FileIO();
        write.writeFile(text);
    }
    
    /**
    * This method returns the state of QuokkaGroup as a String
    */
    public String toString()
    {
        return "\nArray list of tourists: " + touristCountArrayList + "\nArray list of array list of tourist groups: " + simulationTouristGroupArrayList
                + "Quokka group: " + quokkaGroup;
    }
}