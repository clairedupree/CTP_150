import java.util.*; //Scanner & ArrayList
import java.io.*; //File use
/**
   javadoc
*/

//TODO: error checking
//TODO: does file exist
//goodbye

public class TextbookUtilities
{
   /**
   readAllBookData(books : ArrayList<Book>)
   creates the ArrayList from the data file 
   bookdata.txt Preview the document
   remember to close the file
   */
   public static void readAllBookData(ArrayList<Textbook> books) throws IOException
   {
      File infile = new File("textbookdata.csv");
      Scanner scan = new Scanner(infile);
      
      
      String[] token; //to hold file data
      String str = ""; //to hold current record
      
      int bookCount = 0;
      
      scan.nextLine(); //clear file header
      while (scan.hasNext())
      {
         str = scan.nextLine(); //store next record line into variable
         token = str.split(","); //break line into strings, comma delimeter
         
         //Data order: Book,Author,Address,Price,Category
         books.add(new Textbook(token[1], token[2], token[0], token[4], Double.parseDouble(token[3])));
         
         //test input
         //System.out.println(books.get(bookCount));
         
         bookCount++;
      }
      
      scan.close();      
   }
   
   
   /**
   displayAllBookData(books : ArrayList<Book>)
   displays the ArrayList, nicely formatted
   */
   public static void displayAllBookData(ArrayList<Textbook> books)
   {
      for (Textbook book : books)
         System.out.println(book);
   }
   
   /**
   searchForCategory(books : ArrayList<Book>)
   displays the Book object with a certain category 
   passed in, search on a substring of the category
   */
   
   /**
   searchForBook(books: ArrayList<Book>)
   displays the Book object on a book that starts 
   with a certain letter  or few letters
   */
   
   /**
   searchByPrice (books : ArrayList<Book>, double minPrice)
   displays all Books with maxPrice price and below.  
   So if I enter $30, it will list book <= $30.
   */
   public static void searchByPrice(ArrayList<Textbook> books)
   {
      Scanner scan = new Scanner(System.in);
      double maxPrice;
      
      System.out.print("Enter a maximum price: ");
      maxPrice = scan.nextDouble();
      
      for (Textbook book : books)
         if (book.getPrice() <= maxPrice)
            System.out.println(book);
   }

   
   /**
   sortyByAuthor((books : ArrayList<Book>)
   Sort the books by author, maybe a choice of ascending 
   versus descending
   */
   public static void sortByAuthor(ArrayList<Textbook> books)
   {
      //temporary author object
      Textbook curBook;
      
      //Scanner object
      Scanner scan = new Scanner(System.in);
      //Input variable
      int choice;
      String sortOptions = "\t1) Sort A-Z\n\t2) Sort Z-A\n\tPlease select: ";
      System.out.print(sortOptions);
      choice = scan.nextInt();
      while (choice != 1 && choice != 2)
      {
         System.out.print("Invalid selection. " + sortOptions);
         choice = scan.nextInt();
      }
      
      if (choice == 1) //sort books a-z
      {
         
         for (int i = 0; i < books.size() - 1; i++)
            for (int j = 1; j < books.size(); j++)
               if (books.get(j-1).getAuthor().getAuthorName().
                   compareToIgnoreCase(books.get(j).getAuthor().getAuthorName()) > 0)
               {
                  curBook = books.get(j-1);
                  books.set((j-1), books.get(j));
                  books.set(j, curBook);
               }
               
      }
      else //Sort books z-a
      { 
         for (int i = 0; i < books.size() - 1; i++)
            for (int j = 1; j < books.size(); j++)
               if (books.get(j-1).getAuthor().getAuthorName().
                   compareToIgnoreCase(books.get(j).getAuthor().getAuthorName()) < 0)
               {
                  curBook = books.get(j-1);
                  books.set((j-1), books.get(j));
                  books.set(j, curBook);
               }
               
      }
      
      displayAllBookData(books);
   }
   
} //end class