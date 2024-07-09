/**
* This class tests the Quokka class
* @version ver 1.0.0
*/   


// public class Test
// {
//     public Test()
//     {
        
//     }
  
//     /**
//     * This is the main method tests the Quokka class
//     * @param    args    An array of String passed in as command line parameters
//     */


//     public static void main(String[] args)
//     {
//         System.out.println("Create a Quokka object with the default constructor");
//         Quokka quok1 = new Quokka();
//         quok1.displayToString();

//         System.out.println("Create a Quokka object with the non-default constructor with valid field values");
//         Quokka quok2 = new Quokka("Q001", false, 2);
//         quok2.displayToString();
    
        
//         System.out.println("Create a Quokka object with the non-default constructor with invalid field values");
//         Quokka quok3 = new Quokka("Q01", false, 3);
//         quok3.displayToString();
        
        
        
//         System.out.println("Create a Quokka object with the non-default constructor with invalid field values");
//         Quokka quok4 = new Quokka("Q001", true, -2);
//         quok4.displayToString();
        
        
//         System.out.println("Get id of a Quokka object");
//         System.out.println(quok2.getId());

//         System.out.println("Get food supply of a Quokka object");
//         System.out.println(quok2.getFoodSupply());

//         System.out.println("Get alive status of a Quokka object");
//         System.out.println(quok2.getIsAlive());
    
//         System.out.println("Get consecutive days starved of a Quokka object");
//         System.out.println(quok2.getConsecutiveDaysStarved());

//         System.out.println("Get number of days starved of a Quokka object");
//         System.out.println(quok2.getNumberOfDaysStarved());
        
//         System.out.println("Set id of a Quokka object with valid field values");
//         quok2.setId("Q005");  
//         System.out.println(quok2.getId());   
        
//         System.out.println("Set id of a Quokka object with Invalid field values");
//         quok2.setId("Q5");  
//         System.out.println(quok2.getId());  
           
//         System.out.println("Set has baby with valid fields");
//         quok2.setHasBaby(true);  
//         System.out.println(quok2.getHasBaby());   
        
//         System.out.println("Set has baby with invalid fields");
//         quok2.setIsAlive(false);
//         quok2.setHasBaby(true);  
//         System.out.println(quok2.getHasBaby());  

//         System.out.println("Set food supply with valid fields");
//         quok2.setFoodSupply(15);  
//         System.out.println(quok2.getFoodSupply());   
        
//         System.out.println("Set food supply with invalid fields");
//         quok2.setFoodSupply(-1);  
//         System.out.println(quok2.getFoodSupply());  

//         System.out.println("Set consecutive days starved with valid fields");
//         quok2.setConsecutiveDaysStarved(2);  
//         System.out.println(quok2.getConsecutiveDaysStarved());   
        
//         System.out.println("Set consecutive days starved with invalid fields");
//         quok2.setConsecutiveDaysStarved(8);  
//         System.out.println(quok2.getConsecutiveDaysStarved());  

//         System.out.println("Set number of days starved with valid fields");
//         quok2.setNumberOfDaysStarved(3);  
//         System.out.println(quok2.getNumberOfDaysStarved());   
        
//         System.out.println("Set number of days starved with invalid fields");
//         quok2.setNumberOfDaysStarved(7);  
//         System.out.println(quok2.getNumberOfDaysStarved());   

//     }
// }