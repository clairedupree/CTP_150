import java.util.*; //Scanner and Arraylist
import java.io.*; //File use

/**
	CTP 150-400 | Lab 7
   <br>
	Main application for the Recreation Places program.
   
	@author Claire Dupree
	@since 04/10/22
*/

public class RecreationPlaceDriver
{
   /**
      Constant for the number of places in the source file.
      IF THE INSTRUCTIONS DONT SPECIFY USE OF A CONSTANT,
      DONT USE A CONSTANT? Sometimes theres a reason for not.
   */
   final static int NUM_PLACES = 10;
   
   /**
      Main module, creates an array of place objects, an
      ArrayList of recreational place objects, calls method 
      to input file data into array and displays a user menu.
      
      @param args A String of args.
      @throws IOException For file use.
   */
   public static void main(String[] args) throws IOException
   {
      //Create an ArrayList to hold RecreationPlace objects
      ArrayList<RecreationPlace> recPlaces = new ArrayList<>();
      
      //Create an array to hold Place objects
      Place[] places = new Place[NUM_PLACES];
      
      //Scanner object to collect user input
      Scanner input = new Scanner(System.in);
      
      //Call method to input file data into arrays
      fillPlaces(recPlaces, places);
      
      //Variable to store user input
      int select;
      
      //Main menu loop
      do 
      {
         System.out.println("\tRecreation Places Menu");
         System.out.println("----------------------------");
         System.out.println("1) Display all places");
         System.out.println("2) Sort places by price");
         System.out.println("3) Search places by city");         
         System.out.println("4) Search places by type");     
         System.out.println("5) Quit");   
         
         //Collect user input
         select = input.nextInt();
         
         switch(select)
         {
            case 1:
               //display all recreation places
               displayData(recPlaces);
               break;
            case 2:
               //sort places from lowest-highest price
               sortByPrice(recPlaces);
               break;
            case 3:
               //search rec places by city
               searchByCity(recPlaces);
               break;
            case 4:
               //search rec places by type
               searchByType(recPlaces);
               break;  
            case 5:
               //quit message
               System.out.println("Goodbye.");
               break;          
            default:
               //error checking
               if (select != 5)
                  System.out.println("Invalid entry, please try again.");
         }
         System.out.println(); //line break
         
      }              
      while (select != 5);      
   }
   
   
   
   /**
      This method sorts the RecreationPlace ArrayList objects from 
      lowest to highest price.
      @param recPlaces The ArrayList of recreation places.
   */
   public static void sortByPrice(ArrayList<RecreationPlace> recPlaces)
   {
      //Create temporary object
      RecreationPlace temp;
      
      //Loop through ArrayList and sort from least to most expensive
      for (int i = 0; i < recPlaces.size() -1; i++)
         for (int j = 1; j < recPlaces.size(); j++)
            if(recPlaces.get(j-1).getPrice() > (recPlaces.get(j).getPrice()))
               {
                  temp = recPlaces.get(j-1);
                  recPlaces.set((j-1), recPlaces.get(j));
                  recPlaces.set(j, temp);
               }
      //Display arrayList after sort
      displayData(recPlaces); 
   }



   /**
      This method searches the RecreationPlace ArrayList objects by place
      type based on user input.
      @param recPlaces The ArrayList of recreation places.
   */
   public static void searchByType(ArrayList<RecreationPlace> recPlaces)
   {
      //Scanner object to collect user input
      Scanner read = new Scanner(System.in);
      
      //Collect user input
      System.out.print("Enter a recreation place type to search: ");
      String search = read.nextLine();
      
      boolean found = false;
      
      //Loop through ArrayList looking for match
      for (int i = 0; i < recPlaces.size(); i++)
      {
         //Loop through the type attribute in each ArrayList object
         if (search.equalsIgnoreCase(recPlaces.get(i).getType()))
         {
            //If a type match is found
            found = true;
            //Display the place associated with that type
            System.out.println(recPlaces.get(i));
         }
      }
      
      //If a match is not found
      if (!found)
         //Display error
         System.out.println("No places of that type found.");      
   }     
   
   
   
   /**
      This method searches the RecreationPlace ArrayList objects by city 
      based on user input.
      @param recPlaces The ArrayList of recreation places.
   */
   public static void searchByCity(ArrayList<RecreationPlace> recPlaces)
   {
      //Scanner object to collect user input
      Scanner read = new Scanner(System.in);
      
      //Collect user input
      System.out.print("Enter a city to search: ");
      String search = read.nextLine();
      
      boolean found = false;
      
      //Loop through ArrayList looking for match
      for (int i = 0; i < recPlaces.size(); i++)
      {
         //Loop through the place.city attribute in each ArrayList object
         if (search.equalsIgnoreCase(recPlaces.get(i).getPlace().getCity()))
         {
            //If a city match is found
            found = true;
            //Display the place associated with that city
            System.out.println(recPlaces.get(i));
         }
      }
      
      //If a match is not found
      if (!found)
         //Display error
         System.out.println("No places found in that city.");      
   }      
    
    
         
   /**
      This method displays all recreation place objects in the ArrayList.
      @param recPlaces The ArrayList of recreation places.
   */
   public static void displayData(ArrayList<RecreationPlace> recPlaces)
   {
      // Display every recreation place object in the arraylist
      for (RecreationPlace place: recPlaces)
         System.out.println(place);
   }
   
   
   
   /**
      This method populates the places array, and recreation places ArrayList
      with data from a source file.
      @param recPlaces The ArrayList of recreation places.
      @param places The array of locations.
      @throws IOException For file use.
   */
   public static void fillPlaces(ArrayList<RecreationPlace> recPlaces, Place[] places) throws IOException
   {
      //Open file
      File infile = new File("entertainment.csv");
      if (!infile.exists()) //if file is not found
      {
         System.out.print("File not found."); //display error
         System.exit(0); //close process
      }
      
      //Create Scanner object to read file data
      Scanner read = new Scanner(infile);
      
      //Make a string array of tokens
      String str = "";
      String[] tokens;
      
      //Create Place objects in an array 
      for (int i = 0; i < places.length; i++)
         places[i] = new Place();
         
      //Create variable to document number of place objects created
      int placeCount = 0;
      
      read.nextLine(); //clear file header
      
      while (read.hasNext()) //while file has more data
      {
         str = read.nextLine(); //Store next record into variable
         tokens = str.split(","); //file delimiter is commas

         //File data order: name, type, price, city, state

         //Instantiate place objects with data from file
         places[placeCount] = new Place(tokens[3], tokens[4]);
         
            /*
            //Test array input
            System.out.println(places[placeCount]);
            */
         
         //Create and instaniate recreational place objects
         //with data from places array and from file
         recPlaces.add(new RecreationPlace(tokens[0], tokens[1], 
                       Integer.parseInt(tokens[2]), places[placeCount]));
         
            /*              
            // test arraylist input
            System.out.println(recPlaces.get(placeCount));
            */
         
         //Increment number of places
         placeCount++;
      }
      //close the file
      read.close();
   }
}