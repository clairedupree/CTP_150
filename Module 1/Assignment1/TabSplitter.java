/** 
*  This is a program which...
*  @author Claire Dupree 02/18/22
*
*/

/*
Write a program that determines each person’s share of an equally split tab. 
Using descriptive prompts, 

-the program should request the tab total, 
-the percentage tip to add, the tax on the tab, 
-and the number of people splitting the tab. 

-The program should calculate and display the total with tip, tax
- and the total for each person using a descriptive display.  

* You may assume that only numeric input will be supplied by the user.  
-Convert the final total to Pesos.  

* Use a constant for the conversion amount.  
* Please format your output to 2 decimal places. 

1 United States Dollar equals
20.58 Mexican Peso
*/

//TODO: Assess program organization, draw flowchart, decide if methods are necessary, which methods?


//Import java scanner & decimal format libraries
import java.util.Scanner;
import java.text.DecimalFormat;


public class TabSplitter
{
   //Declare global constants
   static final double PESO_CONVERSION = 20.58;

   public static void main(String[] args)
   {
      //Declare local variables
      double subtotal, tax, tip, total = 0.0;
      int numPeople = 0;
            
      //Create Scanner object
      Scanner keyboard = new Scanner(System.in);
      
      // Call program introduction method
      intro();
      
      //Request user input for tab total
      System.out.print("Please enter the tab subtotal: $");
      subtotal = keyboard.nextDouble();
      
      //Request user input for tab tax
      System.out.print("What is the tax percentage? (format as .00): ");
      tax = (subtotal * keyboard.nextDouble());
                 
      //Request user input for tab tip
      System.out.print("What percent tip would you like to leave? (format as .00): ");
      tip = ((subtotal + tax) * keyboard.nextDouble());

      //Request user input for number of people splitting tab
      System.out.print("How many people are splitting the tab?: ");
      numPeople = keyboard.nextInt();
      
      //-The program should calculate and display the total with tip, tax
      //- and the total for each person using a descriptive display.  
      calcTotal(subtotal, tax, tip, numPeople);
             
   } //end main
   
   //TODO: javadoc comment describing m,odule, use apporproate tags
   public static void intro()
   {
      System.out.println("\t\t-- WELCOME TO THE TAB SPLITTER --");
      System.out.println();
      System.out.println("This program will calculate the total of your tab,"); 
      System.out.println("in US Dollars and Pesos, and split it per person.");
      System.out.println("(No more arguing about who owes who money!)");
      System.out.println();
   }
   
   
   public static void calcTotal(double subtotal, double tax, double tip, int numPeople)
   {
      //Calculate subtotal
      //TODO: create and implement decimal formatting object
      double total = (subtotal + tax + tip);
      double totalPerPerson = (total / numPeople);
      
      System.out.println();
      System.out.println("Subtotal:" + "\t\t\t\t" + "$" + subtotal);
      System.out.println("Tax:" + "\t\t\t\t\t\t" + "$" + tax);
      System.out.println("Tip:" + "\t\t\t\t\t\t" + "$" + tip);
      System.out.println("-----------------------------");
      System.out.println("Total (USD):" + "\t\t\t" + "$" + total);
      System.out.println("Total (Pesos):" + "\t\t\t" + "$" + (total * PESO_CONVERSION));
      System.out.println("-----------------------------");
      System.out.println("Per person (USD):" + "\t\t" + "$" + totalPerPerson);
      System.out.println("Per person (Pesos):" + "\t" + "$" + (totalPerPerson * PESO_CONVERSION));
      
      
   } //End calcTotal
      
   /*
   public static double getTabTotal()
   {
      Scanner keyboard = new Scanner(System.in);

      System.out.print("Please enter the tab total: ");
      double tabTotal = keyboard.nextDouble();
      return tabTotal;
      
   } //end getTotal
   */
   
} //end TabSplitter class

