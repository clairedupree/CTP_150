//Import java scanner & decimal format libraries
import java.util.Scanner;
import java.text.DecimalFormat;


/** 
   CTP 150-400 Lab 1, Assignment 1:
   
   This program is a restaurant tab-splitter and currency converter.
   The program requests user input for amounts of a restaurant tab in USD
   and the number of people splitting the tab, and calculates the total 
   amount owed by each person, in both US Dollars (USD) and Mexican Pesos.
   
   @author Claire Dupree 2/18/22
*/
public class TabSplitter
{


   /**
      Current conversion rate for USD to Pesos, as of 2/18/22.
   */
   static final double PESO_CONVERSION = 20.58;


   /**
      The main() method calls the intro() method, collects end-user 
      input and sends that input to the calcTotal() method.
   */
   public static void main(String[] args)
   {
      //Declare local variables
      double subtotal, tax, tip, total = 0.0;
      int numPeople = 0;
           
            
      //Create Scanner object
      Scanner keyboard = new Scanner(System.in);
      
      
      //Call method to introduce program
      intro();
      
      
      //Request user input for tab subtotal
      System.out.print("Please enter the tab subtotal: $");
      subtotal = keyboard.nextDouble();
      
      
      //Request user input for tab tax
      System.out.print("What percentage of tax was applied?" + 
                       "(.06 for 6%): ");
      //Calculate tax amount in USD, based on subtotal
      tax = (subtotal * keyboard.nextDouble());
                 
                 
      //Request user input for tab tip
      System.out.print("What percent tip would you like to leave? " + 
                       "(.20 for 20%): ");
      //Calculate tip amount in USD, based on subtotal *including tax* 
      tip = ((subtotal + tax) * keyboard.nextDouble());


      //Request user input for number of people splitting tab
      System.out.print("How many people are splitting the tab?: ");
      numPeople = keyboard.nextInt();
      
      
      //Call method to calculate and display totals
      calcTotal(subtotal, tax, tip, numPeople);    
              
   } //End main
   
   
   
   
   /**
      The intro() method displays a visually-appealing header and 
      introduces the purpose of the program to the end-user.
   */
   public static void intro()
   {
      System.out.println("\t\t-- WELCOME TO THE TAB SPLITTER --");
      System.out.println();
      System.out.println("This program will calculate the total of your tab,"); 
      System.out.println("in US Dollars and Pesos, and split it per person.");
      System.out.println("(No more arguing about who owes who money!)");
      System.out.println();
   } //End intro()
   
   
   
   
   /**
      The calcTotal() method recieves end-user input data from the main() method, 
      calculates a total in USD, converts that total to Pesos, and displays 
      itemized calculation data in a table.
      
      @param subtotal Tab subtotal amount in USD.
      @param tax Tab tax amount in USD.
      @param tip Tab tip amount in USD.
      @param numPeople The number of people splitting the tab.
   */
   public static void calcTotal(double subtotal, double tax, double tip, 
                                int numPeople)
   {      
      //Declare local variables
      double total = (subtotal + tax + tip);
      double totalPerPerson = (total / numPeople);
      
      //Initialize decimal formatter object
      DecimalFormat decimal = new DecimalFormat("#0.00");
      
      //Display final calculations to end-user in USD and Pesos
      System.out.println();
      System.out.println("Subtotal:" + "\t\t\t\t\t" + "$" + 
                          decimal.format(subtotal));
      System.out.println("Tax:" + "\t\t\t\t\t\t\t" + "$" + 
                          decimal.format(tax));
      System.out.println("Tip:" + "\t\t\t\t\t\t\t" + "$" + 
                          decimal.format(tip));
      System.out.println("----------------------------------");
      System.out.println("Total (USD):" + "\t\t\t\t" + "$" + 
                          decimal.format(total));
      System.out.println("Total (Pesos):" + "\t\t\t\t" + "$" + 
                          decimal.format((total * PESO_CONVERSION)));
      System.out.println("----------------------------------");
      System.out.println("Per person (USD):" + "\t\t\t" + "$" + 
                          decimal.format(totalPerPerson));
      System.out.println("Per person (Pesos):" + "\t\t" + "$" + 
                          decimal.format((totalPerPerson * PESO_CONVERSION)));
   
   } //End calcTotal()
          
      
} //End TabSplitter