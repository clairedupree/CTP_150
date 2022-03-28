import java.io.*;
import java.util.Scanner;

/**
   CTP 150-400 | Assignment no. 2
   <br>
   Application driver for the object-oriented Football program.
   @author Claire Dupree
   @since 03/27/22
*/
public class FootballDriver
{
   /**
      The main() module contains the menu to operate the program
      and calls methods from the Football class based on user selection.
      @param args A String[] of args.
      @throws IOException For file use during runtime.
   */
   public static void main(String[] args) throws IOException
   {
      /**
         A variable to hold user integer menu selection input.
      */
      int select = 0;
      
      /**
         A variable to hold user string search input.
      */      
      String search = "";
      
      // Create object of football class
      Football fb = new Football();
      
      // Create a scanner object to collect user input
      Scanner input = new Scanner(System.in);
      
      // Display Main Menu
      do {
         System.out.println("\t\t\t\t== MAIN MENU ==");
         System.out.println("****************************************");
         System.out.println("1) Show all players in ascending order");
         System.out.println("2) Show all players in descending order");
         System.out.println("3) Search a player by rank");
         System.out.println("4) Search a player by name");
         System.out.println("5) Exit");
         
         // Collect user menu selection
         select = input.nextInt();
         System.out.println(); // line break
         
         switch(select)
         {
            // Call method to display ascending players
            case 1: 
               fb.displayPlayers();
            break;
            
            // Call method to display descending players
            case 2: 
               fb.displayPlayersReverse();
            break;
            
            // Call method to search a player by number
            case 3: 
               fb.displayWinnersByNumber();
            break;
            
            // Call method to search a player by name
            case 4: 
               input.nextLine(); // clear scanner
               
               // Collect user search input
               System.out.print("Please enter the name of a player you would like to search: ");
               search = input.nextLine();

               // Display error if search is not found
               if (fb.findPlayers(search) == -1)
                  System.out.println("Player not found in list");
                  // TODO: Add a "search another?" feature
               // Display player rank if search is found
               else
                  System.out.printf("%s is ranked #%d\n", search, fb.findPlayers(search)+1);
            break;
            
            // Display error if menu selection is invalid
            default: 
               if (select != 5)
                  System.out.println("Invalid entry, try again");
         }
         
         System.out.println(); // line break
         
      } while (select != 5);
      
      // End program
      fb.exit();
   }   
}