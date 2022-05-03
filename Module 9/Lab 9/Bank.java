import java.util.*; //util pkg, arraylist & scanner
import java.io.*; //io pkg, file use

/**
   CTP 150-400 Lab 9
   Bank program
   
   @author Claire Dupree
   @since 4-29-22
*/

public class Bank
{
   /**
      Divider line for consistent formatting.
   */
   public static final String DIVIDER = "---------------------------------------------";

   public static void main(String[] args) throws IOException
   {
      //Create ArrayList for bank accounts
      ArrayList<Account> accounts = new ArrayList<>();      

      //Call method to populate array
      populateArrayList(accounts);
   
      //Display user menu
      menu(accounts);
   }
   
   
   //Populate ArrayList with data from a file
   public static void populateArrayList(ArrayList<Account> accounts) throws IOException
   {
      File infile = new File("accounts.csv");
      if (!infile.exists()) //if file is not found
      {
         System.out.print("File not found"); //display error
         System.exit(0); //close application
      }
      
      Scanner read = new Scanner(infile);
      String currentRecord = "";
      
      read.nextLine(); //clear file header
      
      //populate ArrayList
      while (read.hasNext())
      {
         currentRecord = read.nextLine();
         String[] token = currentRecord.split(",");
         
         if (token[0].equalsIgnoreCase("c"))
            accounts.add(new CheckingAccount(token[1], 
                         Double.parseDouble(token[2])));
         else                
         if (token[0].equalsIgnoreCase("s"))
            accounts.add(new SavingsAccount(token[1], 
                         Double.parseDouble(token[2])));  
         else
            System.out.println("Bad file data");    
      }
      
      //Close the file
      read.close();
   }


   //Display Account objects in the ArrayList based on arguments sent
   //from calling method menu() user input
   public static void displayAccounts(ArrayList<Account> accounts, String accountType)
   {
      int matchCount = 0;
      
      //display all Account objects
      if (accountType.equals("all"))
      {
         for (Account a: accounts)
         {
            System.out.println(a);
            matchCount ++;
         }
         System.out.println(DIVIDER);
         System.out.println("(" + matchCount + " accounts found)");     
      }
      
      //display CheckingAccount objects
      else
      if (accountType.equals("checking"))
      {
         for (Account a: accounts)
         {
            if (a instanceof CheckingAccount)
            {
               System.out.println(a);
               matchCount ++;
            }
         }
         System.out.println(DIVIDER);
         System.out.println("(" + matchCount + " checking accounts found)");  
      }
      
      //display SavingsAccount objects
      else
      if (accountType.equals("savings"))
      {
         for (Account a: accounts)
         {
            if (a instanceof SavingsAccount)
            {
               System.out.println(a);
               matchCount ++;
            }
         }
         System.out.println(DIVIDER);
         System.out.println("(" + matchCount + " savings accounts found)");    
      }   
      
      //error
      else
         System.out.println("Invalid request");    
   }
   
   
   //Search the ArrayList objects by their "name" attribute
   public static void searchAccountsByName(ArrayList<Account> accounts)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a name to search: ");
      String search = input.nextLine().trim();
      int matchCount = 0;
      
      for (Account account: accounts)
      {
         if (account.getName().toLowerCase().indexOf(search.toLowerCase()) != -1)
         {
            System.out.println(account);
            matchCount ++;
         }
         
      }
      System.out.println(DIVIDER);
      System.out.println("(" + matchCount + " accounts found with name " + search + ")");      
   }
   
   
   //Display all ArrayList objects with a balance greater than $1000
   public static void displayOver1000(ArrayList<Account> accounts)
   {
      int matchCount = 0;
      for (Account account: accounts)
         if (account.getBalance() > 1000)
         {
            System.out.println(account);
            matchCount ++;
         }
      System.out.println(DIVIDER);
      System.out.println("(" + matchCount + " accounts found with a balance greater than $1000)");  
   }


   //A menu of options, to call methods based on user input
   public static void menu(ArrayList<Account> accounts)
   {
      Scanner input = new Scanner(System.in);
      int choice;
      
      do {
         System.out.println("\n================= Bank Menu =================" +
                            "\n1) Display all bank accounts" +
                            "\n2) Display all checking accounts" +
                            "\n3) Display all savings accounts" +
                            "\n4) Search accounts by owner's name" +
                            //"\n5) Display all accounts with more than $1000" +
                            "\n0) Exit");
         
         choice = input.nextInt();
                            
         switch(choice)
         {
            case 1: displayAccounts(accounts, "all");
               break;
            case 2: displayAccounts(accounts, "checking");
               break;
            case 3: displayAccounts(accounts, "savings");
               break;
            case 4: searchAccountsByName(accounts);
               break;
            //case 5: displayOver1000(accounts);
               //break;
            case 0: System.out.println("Goodbye!");
               System.exit(0);
               break;
            default:
               if (choice != 0)
                  System.out.println("Invalid entry, please select from the options below:");
         }
      } while (choice != 0);
   }
}