//Imports
import java.io.*;
import java.util.Scanner;

/**
   Read a file that shows an upper bound on each record.
   
   1. Write a program that reads a record in the file and 
   2. Shows integers in a range from 1 to that number (inclusive)that are divisible by 2
   3. Show the sum of those integers
   4. Show the number of integers not divisible by 2
   5. Show the sum of those integers
   6. Repeat all of the above, divisible by 3
   7. Repeat for every line of the file.
   
   * Sample output: *
   
      The following results are based on the the first record in the file which is:  10
         There are 5 numbers divisible by 2. The sum of the numbers divisible by 2 is 30.  Those numbers are 2 4 6 8 10
         There are 5 numbers not divisible by 2. The sum of the numbers not divisible by 2 is 25.  Those numbers are 1 3 5 7 9 
         
         The following results are based on the the first record in the file which is:  10
         There are 3 numbers divisible by 3. The sum of the numbers divisible by 3 is 18.  Those numbers are 3,6, 9.
         There are 7 numbers not divisible by 3. The sum of the numbers not divisible by 3 is 37.  Those numbers are 1 2 4 5 7 8 10
         
   // Probably nested loops      
   // TODO: introduce program.
   // TODO: would you like to read the next record in the file?
   // TODO: You have reached the end of the file.
    
   Read the next record and do the same thing as above 
   
   @author Claire Dupree
   @since 03/02/22
*/

public class Divisible
{
   public static void main(String[] args) throws IOException
   {
      // Declare local variables
      int fileNum = 0;
      String keepGoing = "Y";
       
      // Open file
      File file = new File("divisible");
      // Scanner for file reads
      Scanner inputFile = new Scanner(file);
      // Scanner for user input
      Scanner keyboard = new Scanner(System.in);
      
      
      while (inputFile.hasNext() && (keepGoing.equals("Y") || keepGoing.equals("y")))
      {
         fileNum = inputFile.nextInt();
         System.out.println("Current num: " + fileNum);
         
         //call divide by module, send 2 as dividend
         divideBy(fileNum, 2);
         
         //call divide by module, send 3 as dividend
         divideBy(fileNum, 3);
         
         System.out.print("Would you like to read another number? Y/N: ");
         keepGoing = keyboard.nextLine();
         System.out.println();
         
      } //end while
      
      // TODO: add if / else for specific end message (i.e. "goodbye" or "end of file, goodbye")
      System.out.println("Goodbye");
         
      // Close the file
      inputFile.close();    
      
   } //end main
   
   public static void divideBy(int maxNum, int dividend)
   {
      // Declare local sum
      int sum = 0;
      
      // Calculate numbers divisible by dividend
      System.out.print((maxNum / dividend) + " numbers are divisible by " + dividend + ": ");
      
      for(int currentNum = 1; currentNum <= maxNum; currentNum++)
      {
         if((currentNum % dividend) == 0)
         {
            System.out.print(currentNum + " ");
            sum += currentNum;
         } //end if
      } //end for
      
      System.out.println();
      System.out.println("Sum: " + sum);
      
      sum = 0; //clear sum
      
      // Calculate numbers not divisible by dividend
      System.out.print((maxNum - (maxNum / dividend)) + " numbers not divisible by " + dividend + ": ");
      for(int currentNum = 1; currentNum <= maxNum; currentNum++)
      {
         if((currentNum % dividend) != 0)
         {
            System.out.print(currentNum + " ");
            sum += currentNum;
         } //end if
      } //end for
      
      System.out.println();
      System.out.println("Sum: " + sum);


   } //end divideBy

} //end class


      /*
      // POTENTIAL SOLUTION, nested loops:
      // Logic works but is not ideal, code is confusing, heavy indentation, not scalable with different dividends
      // Would need to declare int sum and int dividend in code body
      
      while (inputFile.hasNext() && (keepGoing.equals("Y") || keepGoing.equals("y")))
      {
         fileNum = inputFile.nextInt();
         System.out.println("Current num: " + fileNum);
         
         for(dividend = 2; dividend <= 3; dividend++)
         {
            System.out.print((fileNum / dividend) + " numbers divisible by " + dividend + ": ");
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
            
            
            
            System.out.print((fileNum - (fileNum / dividend)) + " numbers not divisible by " + dividend + ": ");
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