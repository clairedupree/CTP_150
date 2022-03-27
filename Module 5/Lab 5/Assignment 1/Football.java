import java.util.Scanner;
import java.io.*;

/*
Assignment 1
Procedural program – create at least one array in this program and use it in the program

Input File: The top football averages and the names of the players.
There is a heading on the file that you will have to read past that first record to get to the first player. 
This is a procedural program NOT an Object Oriented Program.  There are no classes and objects required for this. 

Write program that will:
   - Determine the highest football passing yards.
      You will need to find the largest number in the data file - chapter 4 describes how to do this.
      Display the highest yards and the player's name.
   - Determine the lowest football passing yards.
      You will need to find the smallest number in the data file - chapter 4 describes how to do this.
      Display the lowest yards and the player's name. 
   - Determine the average of all of the passing yards.
      Display the average.
   - Determine the players and their averages that are higher than 65000 yards.
      Display how many of them are over this amount.
      
Deliverables:
Football.java
*/

public class Football
{
   public static void main(String[] args) throws IOException
   {
      // Declare constants
      final int SIZE = 7; // number of football players and scores to be entered
      
      // Declare local variables
      //int i = 0; // index variable
      int highest = 0;
      //int hiI = 0; // TEMPORARY FIX
      int lowest = 0;
      //int lowI = 0; // TEMPORARY FIX
      int average = 0;
      int total = 0;
      int over65000 = 0;
      int i = 0;
      
      // Open the file
      File inputFile = new File("footballtest.txt");
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
      
      // Prime read, clear file header
      read.nextLine();
      
      // Input players and passing yard averages into respective arrays
      for (i = 0; i < SIZE; i++)
      {
         players[i] = read.nextLine();
         //System.out.print(players[i] + ": ");
         scores[i] = Integer.parseInt(read.nextLine());
         //System.out.printf("%,d yds\n", scores[i]);
      }
      
      // ENCHANCED FOR LOOP
      // for (datatype variable: array)
      
      /*
      Determine the highest football passing yards.
      You will need to find the largest number in the data file - ch7.4
      Display the highest yards and the player's name.
      */
      for (i = 0; i < scores.length; i++)
      {
         // ~ solved!!!
         // TODO: FIND SOLUTION TO KEEP PLAYER AND SCORE TOGETHER
         // right now, in order to compare, need to save actual index amount
         // but would be more efficent if i only needed to save the subscript
         if (scores[i] > scores[highest])
            highest = i;         
            
         if (scores[i] < scores[lowest])
            lowest = i;
            
         if (scores[i] > 65000) 
            over65000++;
      
         total += scores[i];             
      }
      // Calculate average of all scores
      average = total / scores.length;
      
      // Display highest score
      System.out.printf("Highest running yard average: %s | %,d yds\n", players[highest], scores[highest]);
      
      // Display lowest score
      System.out.printf("Lowest running yard average: %s | %,d yds:\n", players[lowest], scores[lowest]);

      // Display average of all scores
      System.out.printf("Average of all running yard average scores: %,d yds\n", average);
      
      System.out.printf(over65000 + " players scored greater than %,d yds:\n", 65000); 

      /*
      Determine the players and their averages that are higher than 65000 yards.
      Display how many of them are over this amount.
      */
      
      //TODO: make the players into a print statement 
      //which feeds into a variable and print that variable
      // in order to calculayte first and didsplay second?
      // or find a solution to count how many are greater than 65000
      // ** add to main if statement: if (scores[i] > 65000) count++;
      // System.out.println(count + " players scored greater than %,d yds", 65000);
      //System.out.println("Players with averages greater than 65,000 yds: ");
      for (i = 0; i < scores.length; i++)
         if (scores[i] > 65000)
            System.out.printf("\t%s | %,d yds\n", players[i], scores[i]);
            //count++;
         
      // Close the file
      read.close();
   }
}