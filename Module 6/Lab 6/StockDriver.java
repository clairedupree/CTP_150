import java.io.*; //for file use
import java.util.*; //for ArrayList and Scanner class



/**
   CTP 150-400 | Lab 6
   <br>
   This is the application driver for the Stock program.

   @author Claire Dupree
   @since 04/03/22
*/
public class StockDriver
{
   /**
      Main module, creates an ArrayList of Stock objects,
      calls methods to input file data into array and
      display user menu.
      
      @param args A String of args.
      @throws IOException For file use.
   */
   public static void main(String[] args) throws IOException
   {     
      //Create an ArrayList of Stock objects
      ArrayList<Stock> stocks = new ArrayList<Stock>();
      
      //Call method to read file data into ArrayList
      setStockData(stocks);
      
      //Call method to display a sort menu
      sortData(stocks);
      
      //End program message
      System.out.println("Goodbye");

   }//end main
   
   
   
   /**
      This method displays a menu, sorts the Stock objects in the 
      ArrayList alphabetically or by price based on user selection,and 
      then calls displayStockData() to display the sorted list of stocks.
      
      @param stockList The ArrayList of Stock objects to be sorted.
   */
   public static void sortData(ArrayList<Stock> stockList)
   {
      // Create a temporary stock object
      Stock curStock;
      
      int select = 0; //menu select variable
      
      // Create Scanner for user input
      Scanner scan = new Scanner(System.in);
      
      // Display menu
      do {
         System.out.println("\t\t\t- Sort Menu -");
         System.out.println("------------------------------------");
         
         System.out.println("1) Display stocks alphabetically");
         System.out.println("2) Sort stocks by price: descending");
         System.out.println("3) Sort stocks by price: ascending");
         System.out.println("\t(press any other key to exit)");
         
         // Collect user input menu selection
         select = scan.nextInt();
         //System.out.println(); // line break
         
         switch(select)
         {
            // Sort ArrayList alphabetically by stock name
            case 1: for (int i = 0; i < stockList.size() - 1; i++)
                     for (int j = 1; j < stockList.size(); j++)
                        if (stockList.get(j-1).getName().compareToIgnoreCase(stockList.get(j).getName()) > 0)
                        {
                           curStock = stockList.get(j-1);
                           stockList.set((j-1), stockList.get(j));
                           stockList.set(j, curStock);
                        }
                     displayStockData(stockList); 
                     break;
                     
            // Sort ArrayList numerically, largest to smallest by stock price                     
            case 2: for (int i = 0; i < stockList.size() -1; i++)
                        for (int j = 1; j < stockList.size(); j++)
                           if(stockList.get(j-1).getCurrentPrice() < (stockList.get(j).getCurrentPrice()))
                              {
                                 curStock = stockList.get(j-1);
                                 stockList.set((j-1), stockList.get(j));
                                 stockList.set(j, curStock);
                              }
                     displayStockData(stockList); 
                     break;
            
            // Sort ArrayList numerically, smallest to largest by stock price                     
            case 3: for (int i = 0; i < stockList.size() -1; i++)
                        for (int j = 1; j < stockList.size(); j++)
                           if(stockList.get(j-1).getCurrentPrice() > (stockList.get(j).getCurrentPrice()))
                              {
                                 curStock = stockList.get(j-1);
                                 stockList.set((j-1), stockList.get(j));
                                 stockList.set(j, curStock);
                              }
                     displayStockData(stockList); 
                     break;
         
         }//end switch
         
         System.out.println(); //line break
              
      } while (select >= 1 && select <= 3);
   }
   
   
   
   /**
      This method displays all private attributes of a Stock object
      by utilizing the toString method in the Stock class.
      
      @param stockList The ArrayList of Stock objects to be displayed.
   */
   public static void displayStockData(ArrayList<Stock> stockList)
   {
      // Display each ArrayList Stock object on a loop
      for (int i = 0; i < stockList.size(); i++)
         System.out.print(stockList.get(i)); //using the toString method in the Stock class
   }
   
   
   
   /**
      This method accepts an ArrayList used for storing stock objects, 
      opens a source file, and uses source file data to create stock objects.
      
      @param stockList The ArrayList to store Stock objects.
      @throws IOException For file use.
   */
   public static void setStockData(ArrayList<Stock> stockList) throws IOException
   {
      // Open source file
      File file = new File("stockData.txt");
      
      // Create Scanner to read file
      Scanner read = new Scanner(file);
      
      // Input file data into ArrayList array
      while (read.hasNext())
      {
         // Create new array objects
         stockList.add(new Stock(read.nextLine(), read.nextLine(), 
                     Double.parseDouble(read.nextLine())));
      }
   }//end setStockData
}//end class