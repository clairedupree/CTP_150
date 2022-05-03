import java.util.Scanner; //Scanner class

/**
   CTP 150-400
   Backward String | Pg. 605:
   Write a method that accepts a String object as an 
   argument and displays its contents backward. For 
   instance, if the string argument is “gravity” the 
   method should display -“ytivarg”. Demonstrate the 
   method in a program that asks the user to input a 
   string and then passes it to the method.
   
   @author Claire Dupree
   @since 4/16/22
*/

public class BackwardString
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      String input = "";
      String cont = "";
      
      do {
         //Collect user input
         System.out.print("Please enter something you would like reversed: ");
         input = scan.nextLine();
         //Call reverse method
         reverse(input);
         //Ask if continue?
         System.out.print("\n\nWould you like to enter another? Y/N: ");
         cont = scan.nextLine();
      } 
      while (cont.equalsIgnoreCase("y"));
      
      System.out.println("Goodbye!");
   }//end main
   
   public static void reverse(String input)
   {
      //Loop through string backwards
      for (int i = (input.length() - 1); i >= 0; i--)
         //print characters in reverse order
         System.out.print(input.charAt(i));
   }//end reversed
}//end class
