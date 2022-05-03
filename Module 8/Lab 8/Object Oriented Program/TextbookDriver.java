import java.util.*; //arraylist & scanner
import java.io.*; //file use

/**
   CTP 150-400 | Lab 8
   Main application for a Textbook search program. Calls methods of
   the Textbook Application class to import file data, search and sort
   the textbook data based on user input.
   <br>
   @author Claire Dupree
   @since 4/16/22
*/

public class TextbookDriver
{
   /**
      Main module, creates an ArrayList of Textbook objects, calls 
      method to input file data into array and displays a user menu.
      
      @param args A String of args.
      @throws IOException For file use.
   */
   public static void main(String[] args) throws IOException
   {
      //Create an ArrayList of Textbook objects
      ArrayList<Textbook> books = new ArrayList<>();
      
      //Call method to import file into ArrayList
      TextbookUtilities.readAllBookData(books);
      
      //Create scanner for user input
      Scanner scan = new Scanner(System.in);
      int select;
      
      //Display main menu
      do {
         System.out.println("================ MENU ================");
         System.out.println("1) Display all books");
         System.out.println("2) Search book by category");
         System.out.println("3) Search book by title");
         System.out.println("4) Search book by price");
         System.out.println("5) Sort books by author");
         System.out.println("6) Quit");
         
         select = scan.nextInt(); //user input
         
         switch(select)
         {
            case 1:      
               TextbookUtilities.displayAllBookData(books);
               break;            
            case 2:
               TextbookUtilities.searchForCategory(books);
               break;
            case 3:
               TextbookUtilities.searchForBook(books);
               break;
            case 4:   
               TextbookUtilities.searchByPrice(books);
               break;
            case 5:
               TextbookUtilities.sortByAuthor(books);
               break;
            case 6:
               //Quit
               System.out.println("Goodbye!");
               break;
            default:
               //Error checking invalid entry
               if (select != 6)
                  System.out.println("Invalid entry, please select from " +
                                     "the options below");
         }
      }         
      while (select != 6);

   } //end main  
} //end class