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
   }
}