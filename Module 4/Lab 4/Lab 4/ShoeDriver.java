/**
   CTP 150-400 Lab no. 4: 
   This is the application driver for the Shoe class.
   This program creates two shoe objects, stores data
   in each, and displays that data.
   
   @author Claire Dupree
   @since 3/13/22
*/
public class ShoeDriver
{
   /**
      Main module, creates 2 objects of the Shoe class.
      @param args The String of args.
   */
   public static void main(String[] args)
   {
      // Instantiate shoe1 with default constructor
      Shoe shoe1 = new Shoe();
      // Instantiate shoe2 with overloaded constructor
      Shoe shoe2 = new Shoe("Vans", "sneaker", 49.99, 8.0);
      
      // Set values for shoe1
      shoe1.setBrand("Clark");
      shoe1.setType("boot");
      shoe1.setPrice(100.0);
      shoe1.setSize(8.5);
      
      // Display status of shoe1 object
      System.out.println(shoe1);
      // Display discounted price of shoe1
      System.out.printf("The discounted price of Shoe #1 is: $%.2f\n", 
                           shoe1.getDiscount());

      System.out.println();
      
      // Display status of shoe2 object
      System.out.println(shoe2);
      // Display discounted price of shoe2
      System.out.printf("The discounted price of Shoe #2 is: $%.2f\n",
                           shoe2.getDiscount());
   }
}