// Import java libraries
import java.util.Scanner;
// import java.text.DecimalFormat;

/**
   CTP150-400 | Module 2 | Lab 2
   
   This is a shipping calculator. The program will request user input for 
   an item's price and weight, validate weight is within an acceptable range, 
   calculate the cost of shipping based on weight, calculate the total cost 
   including shipping, and display the results to the end-user.   
   
   @author Claire Dupree
   @since 02/27/22
*/

public class ShippingCalculator
{
   public static void main(String[] args)
   {
      // Declare local variables
      double weight = 0.0;
      double price = 0.0;
      double shipping = 0.0;
      
      // Create Scanner object
      Scanner keyboard = new Scanner(System.in);
      
      // Call method to introduce program
      intro();
      
      // Get item price from user
      System.out.print("Enter item's base price in USD: $");
      price = keyboard.nextDouble();
      
      // Call method to get weight from user
      weight = getWeight();
      
      // Call method to calculate shipping cost
      shipping = calcShipping(weight);
      
      // Call method to calculate and display total costs
      displayTotal(price, shipping);
      
   } // End main()
   
   
   
   /**
      Prints a visually-appealing header and introduces program to end-user.
   */
   
   public static void intro()
   {
      System.out.println("\t\t== SHIPPING CALCULATOR ==");
      System.out.println("Calculate shipping costs in US dollars");
      System.out.println("\t\tbased on an item's weight.");
      System.out.println();
      
   } // End intro()
   
   
   
   /**
      Requests user input for item weight. Includes error checking for
      weights less than 0 lbs or greater than 20 lbs. Ends program if invalid.
      
      @return weight The item's weight in lbs.
   */
   
   public static double getWeight()
   {
      // Declare local variables
      double input = 0.0;
      double weight = 0.0;
      
      // Create Scanner object
      Scanner keyboard = new Scanner(System.in);
      
      // Create decimal formatter object
      // Designed for pounds
      // DecimalFormat lbs = new DecimalFormat("#0.00" + " lbs");
      
      // Get weight input
      System.out.print("Enter item's weight in lbs: ");
      input = keyboard.nextDouble(); 
      System.out.println();
      
      // Error checking weight
      if (input < 0 || input > 20.0) // is not valid
      {  
         if (input > 20)
         {
            // Error message
            //System.out.println("You entered: " + lbs.format(input));
            System.out.printf("You entered: %,.2f lbs\n", input);
            System.out.println("Packages above 20 lbs are too heavy to ship.");
            System.out.println("Please try again with a different item.");
            
            // End process
            System.exit(0);
         }
            
         else if (input < 0)
         {
            // Error message
            //System.out.println(lbs.format(input) + " is invalid");
            System.out.printf("%,.2f is invalid.\n", input);
            System.out.println("Weight must be greater than 0 lbs.");
            System.out.println("Please try again.");         
         
            // End process
            System.exit(0);
         }
      }
      
      else // is valid
         weight = input; 
      
      // Return item's weight in lbs
      return weight;
      
   } // End getWeight()
   
   
   
   /**
      Calculates shipping costs in USD based on weight.

      @param weight The item's weight in lbs.
      @return shipping The shipping cost in USD, based on weight.
   */
   
   public static double calcShipping(double weight)
   {
      // Declare local variables
      double shipping = 0.0;
      
      // Calculate shipping cost with range-checking
      if (weight <= 1)
         shipping = 1.85;
      else 
      if (weight <= 5)
         shipping = 5.85;
      else
      if (weight <= 10)
         shipping = 9.85;
      else
         shipping = 12.75;
      
      // Return shipping cost in USD
      return shipping;
      
   } // End calcShipping(weight)
   
   
   
   /**
      Displays an itemized total of all costs, and calculates and displays
      final total in USD.
      
      @param price The item's base price in USD, before shipping.
      @param shipping The item's shipping cost in USD.
   */
   
   public static void displayTotal(double price, double shipping)
   { 
      // Create decimal formatter object
      // Designed for USD
      // DecimalFormat usd = new DecimalFormat("$" + "#0.00");
            
      // Display itemized totals to end-user
      /*
      System.out.println("Item price:" + "\t\t\t" + usd.format(price));
      System.out.println("Shipping:" + "\t\t\t" + usd.format(shipping));
      System.out.println("--------------------------");
      System.out.println("Total cost:" + "\t\t\t" + usd.format(price + shipping));
      */
      System.out.printf("Item price:" + "\t\t\t" + "$%,.2f\n", price);
      System.out.printf("Shipping:" + "\t\t\t" + "$%,.2f\n", shipping);
      System.out.println("--------------------------");
      System.out.printf("Total cost:" + "\t\t\t" + "$%,.2f\n", (price + shipping));      

   } // End displayTotal(price, shipping)
   
} // End class ShippingCalculator