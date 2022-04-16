import java.util.*; //arraylist & scanner
import java.io.*; //file use

/**
   javadoc
*/

public class TextbookDriver
{
   public static void main(String[] args) throws IOException
   {
      //Create an ArrayList of Book objects
      ArrayList<Textbook> books = new ArrayList<>();
      
      //call readAllBookData()
      TextbookUtilities.readAllBookData(books);
      
      //call displayAllBookData()
      TextbookUtilities.displayAllBookData(books);
      
      //call searchByCategory() - the search comes 
      //from user input
      
      //call searchByPrice - the price comes from 
      //user input
      TextbookUtilities.searchByPrice(books);
      
      //call sortByAuthor - The information about the 
      //books is sorted by author
      TextbookUtilities.sortByAuthor(books);

   } //end main  
} //end class