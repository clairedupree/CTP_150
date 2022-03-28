import java.util.Scanner;
import java.io.*;

/**
   CTP 150-400 | Assignment no. 1
   <br>
   Application for the procedural Football program.
   @author Claire Dupree
   @since 03/27/22
*/
public class Football
{
   
   /**
      The main() module imports a source file containing the names and
      passing yard averages of football players, performs various calculations
      on that data, and displays the results to the user.
      @param args A String[] of args.
      @throws IOException For file use during runtime.
   */
   public static void main(String[] args) throws IOException
   {
      /**
         A constant used to determine the size of the players[] and scores[]
         arrays, based on the number of players in the source file.
      */
      final int SIZE = 7; 
      
      /**
         The index location of the highest player score.
      */
      int highest = 0; //initialize to index 0
      
      /**
         The index location of the lowest player score.
      */
      int lowest = 0; //initialize to index 0
      
      /**
         The average of all player scores.
      */      
      int average = 0;
      
      /**
         The total of all player scores.
      */
      int total = 0;
      
      /**
         The number of players whos scores are greater than 65,000 yds.
      */
      int over65000 = 0;

      
      // Open the file
      File inputFile = new File("football.txt");
      
      if (!inputFile.exists()) // is not valid
      {
         System.out.println("File not found."); // display error message
         System.exit(0); // close program
      }
      
      // Create Scanner to read file
      Scanner read = new Scanner(inputFile);
      
      // Create array for players
      String[] players = new String[SIZE];
      
      // Create array for scores
      int[] scores = new int[SIZE];
      
      // Clear file header
      read.nextLine();
      
      
      // Input players and passing yard averages into respective arrays
      for (int i = 0; i < SIZE; i++)
      {
         players[i] = read.nextLine();
         //System.out.print(players[i] + ": ");
         scores[i] = Integer.parseInt(read.nextLine());
         //System.out.printf("%,d yds\n", scores[i]);
      }
      
       
      // Determine the highest and lowest passing yard scores
      for (int i = 0; i < scores.length; i++)
      {
         // If current score is higher than previous, save index location
         if (scores[i] > scores[highest])
            highest = i;         

         // If current score is lower than previous, save index location            
         if (scores[i] < scores[lowest])
            lowest = i;
            
         // If current score is higher than 65,000 yds, add to count           
         if (scores[i] > 65000) 
            over65000++;
         
         // Add current score to total of all scores
         total += scores[i];             
      }
      
      // Calculate average of all scores based on total
      average = total / scores.length;
      
      // Display highest score
      System.out.printf("Highest running yard average: %s | %,d yds\n", players[highest], scores[highest]);
      
      // Display lowest score
      System.out.printf("Lowest running yard average: %s | %,d yds:\n", players[lowest], scores[lowest]);

      // Display average of all scores
      System.out.printf("Average of all running yard average scores: %,d yds\n", average);
      
      //Display the number of scores above 65,000 yds
      System.out.printf(over65000 + " players scored greater than %,d yds:\n", 65000); 

      /**
         Display the player names and ranks of all scores greater than 65,000 yds.
      */
      for (int i = 0; i < scores.length; i++)
         if (scores[i] > 65000)
            System.out.printf("\t%s | %,d yds\n", players[i], scores[i]);
         
      // Close the file
      read.close();
   }
}