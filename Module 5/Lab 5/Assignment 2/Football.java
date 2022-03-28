import java.io.*; 
import java.util.Scanner; 

/**
   CTP 150-400 | Assignment no. 2
   <br>
   Class definition for the Football program.
   @author Claire Dupree
   @since 03/27/22
*/

public class Football
{
   /**
      An array of Strings to hold football player names, in order of rank.
   */
   private String[] players;
   
   /**
      A constant used to set the size of the players[] array, 
      determined by the number of player names found in the source file.
   */
   private final int NUM_PLAYERS = 10; 
      
   
   /**
      This constructor opens a source file containing football player names
      and imports those names into the players[] array.
      @throws IOException for file use during runtime.
   */
   public Football() throws IOException
   {
      // Open source file
      File inputFile = new File("footballnames.txt");
      if (!inputFile.exists()) // is not valid
      {
         System.out.println("File not found."); // display error message
         System.exit(0); // close program
      }
      
      // Create scanner to read source file
      Scanner read = new Scanner(inputFile);
      
      // Initialize array to appropriate size for source file
      players = new String[NUM_PLAYERS];
      
      // Clear file header
      read.nextLine();
      
      // Loop through each array element
      for (int i = 0; i < players.length; i++)
      {
         // Populate array element with current file line
         players[i] = read.nextLine();  
         //System.out.println(players[i]);
      }
      
      // Close the file
      read.close();
   }
   
   
   /**
      This method displays the names and ranks of the football players
      from highest to lowest rank.
   */   
   public void displayPlayers()
   {
      // Display header
      System.out.println("Players from highest to lowest rank:");
      System.out.println("------------------------------------");
      
      // Loop through and display each array element
      for (int i = 0; i < players.length; i++)
      {
         System.out.printf("#%d:\t%s\n", i + 1, players[i]);
      }
   }
   
 
   /**
      This method displays the names and ranks of the football players
      from lowest to highest rank.
   */    
   public void displayPlayersReverse()
   {
      // Display header
      System.out.println("Players from lowest to highest rank:");
      System.out.println("------------------------------------");
      
      // Loop through and display each array element
      for (int i = players.length; i > 0; i--)
      {
         System.out.printf("#%d:\t%s\n", i, players[i-1]);
      }
   }

   
   /**
      This method displays the name of a player associated with a
      rank number input by the user.
   */
   public void displayWinnersByNumber()
   {
      //TODO: Move user input options to select case 3 in main() module?
      //OR: Move select case 4 input options to findPlayers() module?
      
      // Local variable for user input
      int select = 1;
      
      // Initialize Scanner for user input
      Scanner input = new Scanner(System.in); 
      
      // Continue search loop
      do {
         // Prompt user to enter a rank number      
         System.out.print("Please enter a rank number from 1-10: ");
         select = input.nextInt();
         
         while (select > NUM_PLAYERS || select < 1) // is not valid
         {
            // Prompt user to try again
            System.out.print("Invalid entry, please enter a rank from 1-10: ");
            select = input.nextInt(); 
         }
         
         // Display selected player based on rank
         // -1 to account for correct array subscript number
         System.out.printf("#%d: %s\n", select, players[select - 1]);
         
         System.out.println(); //line break
         
         // Ask user if they choose to search another rank
         System.out.println("Search another rank?\n1) Yes\n2) No");
         select = input.nextInt();
         System.out.println(); //line break

         while (select != 1 && select != 2) //is not valid
         {
            // Prompt user to try again
            System.out.println("Invalid entry. Please select:\n1) Yes\n2) No");
            select = input.nextInt();
            
            System.out.println(); //line break
         }              
      } while (select == 1); // Continue while user selects "Yes"
   }
   
   
   /**
      This function accepts a search string, compares that string with
      player names in the players[] array, and returns the rank of the 
      searched name, if it is found within the list of names.
      @param search The user input to be searched.
      @return The subscript location of the name, if found, or -1 if not found.
   */   
   public int findPlayers(String search)
   {

      int i = 0; // Array index variable
      boolean found = false; // Flag for found or not found
      int location = -1; // Subscript location of the search results in the array
      
      // Continue searching while not found and while there are elements left
      while (!found && i < players.length)
      {
         // If search matches an array element
         if (players[i].equals(search))
         {
            // Found is true and index location is stored
            found = true;
            location = i;
         }
         i++;
      }
      // Return index location of match or -1 for no match     
      return location;
   }
   
   
   /**
      This method prompts the user that the program is ending.
   */   
   public static void exit()
   {
      System.out.println("Goodbye");
   }
}