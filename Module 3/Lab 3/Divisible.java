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
      int numDivisible = 0;
      String answer = "Y";
      int runningTotal = 0;
      int thisNum = 0;
      int innerNum = 0;
      //final int DIVIDE_BY_1ST = 2;
      //final int DIVIDE_BY_2ND = 3;
      
      // Open file
      File file = new File("divisible");
      // Scanner file read object
      Scanner inputFile = new Scanner(file);
      // Scanner system input object
      Scanner keyboard = new Scanner(System.in);


      // Read first number from file
      while (inputFile.hasNext() && (answer.equals("Y") || answer.equals("y"))) // " ?
      {
         fileNum = inputFile.nextInt();
         System.out.println("The current number is: " + fileNum); //TODO: add punctuation?
         // TODO: clean up formatting to resemble a table / list, not sentences
         //Calculate number of integers from 1-currentNum divisible by 2
         
         // How to efficently reuse the same loop for /2 & /3?
         // for loop dividend=2; dividend <= 3
         for(int dividend = 2; dividend <= 3; dividend++) //TODO: replace literals with constant?
         {
            // make this a method??? code reuse?
            numDivisible = (int)(fileNum / dividend);
            System.out.println("There are " + (numDivisible) + " numbers divisible by " + dividend); // TODO: replace with a constant?
            System.out.print("These numbers are: ");
            for(thisNum = 1; thisNum <= fileNum; thisNum++)
            {
               if ((thisNum % dividend) == 0)
               {
                  System.out.print(thisNum + " ");
                  runningTotal += thisNum;
               }

            } 
                     
            System.out.println();
            System.out.println("The sum of these numbers is: " + runningTotal);
            System.out.println();
            
            //---------------repetitive code-------------------//
            System.out.println("There are " + (fileNum-numDivisible) + " numbers not divisible by " + dividend);
            System.out.print("These numbers are: ");
            for(thisNum = 1; thisNum <= fileNum; thisNum++)
            {
               if ((thisNum % dividend) != 0)
               {
                  System.out.print(thisNum + " ");
                  runningTotal += thisNum;
               }   
            } 
                     
            System.out.println();
            System.out.println("The sum of these numbers is: " + runningTotal);
            System.out.println();

                         
         }
                  
         // Continue?
         System.out.print("Would you like to read another number? Y/N: ");
         answer = keyboard.nextLine();
         System.out.println();

      }
      
      //inputFile.nextLine();
      //keyboard.nextLine();
      //if (inputFile.hasNext())
         System.out.println("Goodbye");
      //else
         //System.out.println("That is the end of the file.");
         //System.out.println("Goodbye.");
         
      // Close the file
      inputFile.close();    
      
      
   } //end main
   
   /*
   // Overengineering?
   public static void numDivisible(int fileNum, int dividend, String type)
         System.out.println("There are " + (fileNum / dividend) + " numbers " + type + " by " + dividend); // TODO: replace with a constant?
         System.out.print("These numbers are: ");
         for(thisNum = 1; thisNum <= fileNum; thisNum++)
         {
            if ((thisNum % dividend) == 0)
            {
               System.out.print(thisNum + " ");
               runningTotal += thisNum;
            }   
         } 
                  
         System.out.println();
         System.out.println("The sum of these numbers is: " + runningTotal);
         System.out.println();
   */

} //end class