import java.io.*;
import java.util.Scanner;

/*
-- DRIVER --
*/

public class FootballDriver
{
   public static void main(String[] args) throws IOException
   {
      /**
         documentation
      */
      int select = 0; // to hold user menu input
      
      // Create object of football class
      Football fb = new Football();
      
      // Create a scanner object to collect user input
      Scanner input = new Scanner(System.in);
      
      // menu do while loop
      do {
         System.out.println("\t\t\t\t== MAIN MENU ==");
         System.out.println("****************************************");
         System.out.println("1) Show all players - ascending order");
         System.out.println("2) Show all players - descending order");
         System.out.println("3) Search a player by rank");
         System.out.println("4) Search a player by name");
         System.out.println("5) Exit");
         
         select = input.nextInt();
         System.out.println(); // line break
         
         switch(select)
         {
            case 1: fb.displayPlayers();
            break;
            case 2: fb.displayPlayersReverse();
            break;
            case 3: fb.displayWinnersByNumber();
            break;
            case 4:
         }
         
         System.out.println(); // line break
         
      } while (select != 5);
      
      // exit method
      fb.exit();
      
   }   
}