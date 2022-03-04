// Import Java API libraries
import java.io.*;
import java.util.Scanner;

/**
   CTP 150-400 | Module 3 | Lab 3
   <br>
   This program performs a series of division operations on integers 
   imported from a file. Using a loop, the program imports each file 
   line, determines which numbers from 1 to that integer are divisible 
   by a chosen dividend, and then displays those numbers and the sum of 
   those numbers. The program then does the same for numbers which are 
   not divisible by the chosen dividend. 
        
   // TODO: introduce program.
   // TODO: You have reached the end of the file.
   // TODO: less comments
   // TODO: more spacing
       
   @author Claire Dupree
   @since 03/04/22
*/

public class Divisible
{
   
   /**
      Main module. Imports a file, calls intro(), reads each line from 
      that file and sends as an argument to divisibleBy() or 
      notDivisibleBy() on a loop.
   */
   
   public static void main(String[] args) throws IOException
   {
      // Declare local variables
      int fileNum = 0;
      String keepGoing = "Y"; // Initialized to "yes"
       
      // Open file
      File file = new File("divisible");
      
      // Create scanner for file reads
      Scanner inputFile = new Scanner(file);
      // Create scanner for user input
      Scanner keyboard = new Scanner(System.in);
      
      // Call module to introduce program
      intro();
      
      // Ask end-user if they want to start
      System.out.print("Would you like to calculate the first number? Y/N: ");
      keepGoing = keyboard.nextLine();
      System.out.println();
      
      // Enter loop if the file has another line 
      // and when user selects continue
      while (inputFile.hasNext() && (keepGoing.equals("Y") 
                                 || keepGoing.equals("y")))
      {
         // Import next integer
         fileNum = inputFile.nextInt();
         System.out.println("Current num: " + fileNum);
         
         // Call division modules, 2 as dividend
         divisibleBy(fileNum, 2);
         notDivisibleBy(fileNum, 2);
         
         // Call division modules, 3 as dividend
         divisibleBy(fileNum, 3);
         notDivisibleBy(fileNum, 3);
         
         // Ask end-user if they want to continue
         System.out.print("Would you like to read another number? Y/N: ");
         keepGoing = keyboard.nextLine();
         System.out.println();
         
      } //end while
      
      // TODO: add if / else for specific end message (i.e. "goodbye" or "end of file, goodbye")
      System.out.println("Goodbye");
         
      // Close the file
      inputFile.close();    
      
   } //end main
   
   
   
   
   /**
      Introduces program to end-user.
   */
   public static void intro()
   {
      //INSERT INTRO
      System.out.println("\t\t\t-- IS IT DIVISIBLE? --");
      System.out.println("This program reads integers from a file and");
      System.out.println("displays which ones are divisible and which");
      System.out.println("ones are not divisible by a chosen dividend.");
      System.out.println();
   }
   
   
   
      
   /**
      Accepts an integer and a dividend and calculates how many numbers
      from 1 to that integer that are divisible by the chosen dividend.
      Calculates the sum of these numbers and displays the results of
      all calculations in a table.
      
      @param maxNum Integer to be the high-end of the range of divisible numbers
      @param dividend Integer which each number be divided by
   */
   
   public static void divisibleBy(int maxNum, int dividend)
   {
      // Declare local sum
      int sum = 0;
      
      // Calculate & display the number of integers divisible by dividend
      System.out.print((maxNum / dividend) + " numbers are divisible by " + dividend + ": ");
      
      // Loop through each integer starting at 1 - file number
      for(int currentNum = 1; currentNum <= maxNum; currentNum++)
      {
         // Display each integer divisible by dividend      
         if((currentNum % dividend) == 0)
         {
            System.out.print(currentNum + " ");
            sum += currentNum; // Add integer to sum
         } //end if
      } //end for
      
      // Display sum of divisible integers
      System.out.println();
      System.out.println("Sum: " + sum);
   } // end divisibleBy




   /**
      Accepts an integer and a dividend and calculates how many numbers
      from 1 to that integer that NOT are divisible by the chosen dividend.
      Calculates the sum of these numbers and displays the results of
      all calculations in a table.
      
      @param maxNum Integer to be the high-end of the range of non-divisible numbers
      @param dividend Integer which each number be divided by
   */
   
   public static void notDivisibleBy(int maxNum, int dividend)
   {      
      // Declare local sum
      int sum = 0;
      
      // Calculate & display the number of integers NOT divisible by dividend
      System.out.print((maxNum - (maxNum / dividend)) + " numbers not divisible by " + dividend + ": ");
      for(int currentNum = 1; currentNum <= maxNum; currentNum++)
      {
         // Loop through each integer starting at 1 - file number
         if((currentNum % dividend) != 0)
         {
            // Display each integer NOT divisible by dividend      
            System.out.print(currentNum + " ");
            sum += currentNum; // Add integer to sum
         } //end if
      } //end for
      
      // Display sum of non-divisible integers
      System.out.println();
      System.out.println("Sum: " + sum);

   } //end notDivisibleBy

} //end class


      /*
      // Alternative solution using nested loops:
      // Logic works but is not ideal, confusing logic,
      // heavy indentation, not scalable with different dividends
      // Would need to declare int sum and int dividend in code body
      
      while (inputFile.hasNext() && (keepGoing.equals("Y") 
                                 || keepGoing.equals("y")))
      {
         fileNum = inputFile.nextInt();
         System.out.println("Current num: " + fileNum);
         
         for(dividend = 2; dividend <= 3; dividend++)
         {
            System.out.print((fileNum / dividend) + " numbers divisible by " 
                                                  + dividend + ": ");
            sum = 0; //clear sum
            for(int currentNum = 1; currentNum <= fileNum; currentNum++)
            {
               if((currentNum % dividend) == 0)
               {
                  System.out.print(currentNum + " ");
                  sum += currentNum;
               } //end if
            } //end 1st inner for
            System.out.println();
            System.out.println("Sum: " + sum);
            
            
            
            System.out.print((fileNum - (fileNum / dividend)) 
                              + " numbers not divisible by " + dividend + ": ");
            sum = 0; //clear sum
            for(int currentNum = 1; currentNum <= fileNum; currentNum++)
            {
               if((currentNum % dividend) != 0)
               {
                  System.out.print(currentNum + " ");
                  sum += currentNum;
               } //end if
            } //end 2nd inner for
            System.out.println();
            System.out.println("Sum: " + sum);          
         } //end outer for
                                  
                  
         // Continue?
         System.out.print("Would you like to read another number? Y/N: ");
         keepGoing = keyboard.nextLine();
         System.out.println();

      } //end while
      */