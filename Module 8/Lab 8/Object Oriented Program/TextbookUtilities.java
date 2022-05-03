import java.util.*; //Scanner & ArrayList
import java.io.*; //File use

/**
   CTP 150-400 | Lab 8
   Class definition for Textbook Utilities class, defines public methods to 
   import file data, sort and search that data.
   <br>
   @author Claire Dupree
   @since 4/16/22
*/

public class TextbookUtilities
{
   /**
      Divider line for consistent formatting.
   */
   public static final String divider = "--------------------------------------";
   
   /**
      Creates an ArrayList from the data file.
      @param books The ArrayList of textbooks.
      @throws IOException For file use.
   */
   public static void readAllBookData(ArrayList<Textbook> books) throws IOException
   {
      //Open source file
      File infile = new File("textbookdata.csv");
      if (!infile.exists()) //if file is not found
      {
         System.out.print("File not found"); //display error
         System.exit(0); //close application
      }
      
      Scanner scan = new Scanner(infile);    
      String[] token; //to hold file data
      String str = ""; //to hold current record
      int bookCount = 0; //count number of books imported
      
      scan.nextLine(); //clear file header
      
      while (scan.hasNext())
      {
         str = scan.nextLine(); //store next record line into variable
         token = str.split(","); //break line into strings, comma delimeter
         
         //Data order: Book,Author,Address,Price,Category
         books.add(new Textbook(token[1], token[2], token[0], 
                   token[4], Double.parseDouble(token[3])));
         
         //test input
         //System.out.println(books.get(bookCount));
         
         bookCount++; //increment book count
      }
      scan.close(); //close file
   }
   
      
   /**
      Displays all members of the books ArrayList.
      @param books The ArrayList of textbooks.
   */
   public static void displayAllBookData(ArrayList<Textbook> books)
   {
      for (Textbook book : books)
         System.out.println(book);
      System.out.println(divider + "\n");   
   }
   
   
   /**
      Collects user input to search Textbook ArrayList by
      book category, displays any matches.
      @param books The ArrayList of textbooks.
   */
   public static void searchForCategory(ArrayList<Textbook> books)
   {
      //Create scanner for user input
      Scanner scan = new Scanner(System.in);
      String lookUp = "";
      int matchCount = 0;
      
      //Collect user input
      System.out.print("Enter a category to search: ");
      lookUp = scan.nextLine().trim();
      
      //Print any books that match user entered substring category
      for (Textbook book : books)
         if (book.getCategory().toLowerCase().indexOf(lookUp.toLowerCase()) != -1)
         {
            System.out.println(book);
            matchCount++;
         }
      //Print number of matches
      System.out.println(divider);
      System.out.println("(" + matchCount + " matches found for search: " 
                         + lookUp + ")\n");  
   }
   
   /**
      Collects user input to search book ArrayList by
      book title, displays all books that starts with 
      a certain letter or few letters
      @param books The ArrayList of textbooks.
   */
   public static void searchForBook(ArrayList<Textbook> books)
   {
      //Scanner object for user input
      Scanner scan = new Scanner(System.in);
      String lookUp = "";
      int matchCount = 0;
      
      //Collect user input
      System.out.print("Enter the first few letters of a title: ");
      lookUp = scan.nextLine().trim();
      
      //Print any books that match first characters of title
      for (Textbook book : books)
      {
         if (book.getBookName().toLowerCase().startsWith(lookUp.toLowerCase()))
         {
            System.out.println(book);
            matchCount++;
         }
      }
      //Print number of matches
      System.out.println(divider);
      System.out.println("(" + matchCount + " matches found for search: " 
                         + lookUp + ")\n");  
   }   
   
   
   /**
      Collects user input to search Textbook ArrayList
      by a maximum price, displays all books less than
      or equal to that price.
      @param books The ArrayList of textbooks.
   */
   public static void searchByPrice(ArrayList<Textbook> books)
   {
      //Scanner for user input
      Scanner scan = new Scanner(System.in);
      double maxPrice;
      int matchCount = 0;
      
      //Collect user input
      System.out.print("Enter a maximum price: $");
      maxPrice = scan.nextDouble();
      
      //Print any books that are less than user entered price
      for (Textbook book : books)
         if (book.getPrice() <= maxPrice)
         {
            System.out.println(book);
            matchCount++;
         }
      //Print number of matches
      System.out.println(divider);
      System.out.println("(" + matchCount + " matches found for $" + maxPrice +
                         " or less)\n");  
   }

   
   /**
      Sorts the Textbook ArrayList from a-z or z-a,
      depending on user selection, calls method to
      then display the ArrayList.
      @param books The ArrayList of textbooks.
   */
   public static void sortByAuthor(ArrayList<Textbook> books)
   {
      //Temporary author object
      Textbook curBook;
      
      //Scanner object for user input
      Scanner scan = new Scanner(System.in);
      int choice;
      
      //Sort order menu
      String sortOptions = "\t1) Sort A-Z\n\t2) Sort Z-A\n\tPlease select: ";
      
      //Collect user input for sort order
      System.out.print(sortOptions);
      choice = scan.nextInt();
      
      //Error checking invalid entry
      while (choice != 1 && choice != 2)
      {
         System.out.print("Invalid selection. " + sortOptions);
         choice = scan.nextInt();
      }
      
      //Sort books ArrayList a-z
      if (choice == 1)
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
      //Sort books ArrayList z-a
      else 
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
       //Display ArrayList after sort
       displayAllBookData(books);
   }
} //end class