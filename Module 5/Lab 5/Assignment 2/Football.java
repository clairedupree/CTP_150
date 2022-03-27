import java.io.*; //files
import java.util.Scanner; //scanner class

/*
-- CLASS DEFINITION --
*/

public class Football
{
   /**
      add documentation
   */
   private String[] players; // player names
   
   /**
      add docs
   */
   private final int NUM_PLAYERS = 10; // number of players on the source file
   
   
   /**
      This constructor...
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
      
      // Initialize array to needed size for source file
      players = new String[NUM_PLAYERS];
      
      // Clear file header
      read.nextLine();
      
      for (int i = 0; i < players.length; i++)
      {
         players[i] = read.nextLine();  
         //System.out.println(players[i]);
      }
      
      // close the file
      read.close();
   }
   
   public void displayWinnersByNumber()
   {
      int select = 1; //to store user input
      Scanner input = new Scanner(System.in); //to collect user input
      
      do {
         System.out.print("Please enter a rank number from 1-10: ");
         select = input.nextInt();
         while (select > 10 || select < 1)
         {
            System.out.print("Invalid entry, please enter a rank from 1-10: ");
            select = input.nextInt(); 
         }
         
         // Display selected player based on rank
         System.out.printf("Rank %d: %s\n", select, players[select - 1]);
         System.out.println(); //line break

         System.out.println("Search another rank?\n1) Yes\n2) No");
         select = input.nextInt();
            while (select != 1 && select != 2)
            {
               System.out.println("Invalid entry. Please select either:\n1) Yes\n2) No");
               select = input.nextInt();
            }
               
      } while (select == 1);
   }
   
   public static void exit()
   {
      System.out.println("Goodbye");
   }
}