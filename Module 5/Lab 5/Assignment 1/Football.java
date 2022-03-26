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
      final int NUM_ENTRIES = 10; // number of football players and scores to be entered
      
      // Declare local variables
      
      // Open the file
      File inputFile = new File("football.txt");
      if (!inputFile.exists()) // is not valid
      {
         System.out.println("File not found.");
         System.exit(0);
      }
      
      // Create Scanner to read file
      Scanner read = new Scanner(inputFile);
      
      // Create array for players
      String[] players = new String[NUM_ENTRIES];
      
      // Create array for scores
      int[] passingYardAvgs = new int[NUM_ENTRIES];
      
      // Prime read, clear file header
      read.nextLine();
      
      // Input players and passing yard averages into respective arrays
      for (int i = 0; i < NUM_ENTRIES; i++)
      {
         players[i] = read.nextLine();
         System.out.print(players[i] + ": ");
         passingYardAvgs[i] = Integer.parseInt(read.nextLine());
         System.out.printf("%,d yds\n", passingYardAvgs[i]);
      }
         
      // Close the file
      //inputFile.close();
   }
}