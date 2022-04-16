/**
	CTP 150-400 | Lab 7
   <br>
	Class defintion of a recreation place, contains attributes for the 
	place name, type, price, and "has a" place object.
   
	@author Claire Dupree
	@since 04/10/22
*/

public class RecreationPlace
{
   /**
      Private attribute for the place name.
   */
   private String name;
   
   /**
      Private attribute for the place type.
   */
   private String type;
   
   /**
      Private attribute for the place price.
   */
   private int price;
   
   /**
      Has a place object, containing place location: city, state.
   */
   private Place place;
   
   
   
   /**
		This constructor creates a recreation place with default values for all attributes.
   */
   public RecreationPlace()
   {
      this.name = "";
      this.type = "";
      this.price = 0;
      this.place = new Place();
   }
   
   /**
		This constructor creates a recreation place with input values for all attributes.
      @param name The place name.
      @param type The place type.
      @param price The place price.
      @param place The place object containing city and state.
   */
   public RecreationPlace(String name, String type, int price, Place place)
   {
      this.name = name;
      this.type = type;
      this.price = price;
      this.place = new Place(place);
   }
   
   /**
		This constructor creates a recreation place with input values for some attributes.
      @param name The place name.
      @param price The place price.
      @param place The place object containing city and state.
   */
   public RecreationPlace(String name, int price, Place place)
   {
      this.name = name;
      this.price = price;
      this.place = new Place(place);
   }   
   
   
   
   /**
      This method sets the place name attribute.
      @param name The value to be stored in name.      
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
		This function returns the place name.
		@return name The place name.
   */
   public String getName()
   {
      return name;
   }
   
   /**
      This method sets the place type attribute.
      @param type The value to be stored in type.  
   */
   public void setType(String type)
   {
      this.type = type;
   }
   
   /**
		This function returns the place type.
		@return type The place type.
   */
   public String getType()
   {
      return type;
   }
   
   /**
      This method sets the place price attribute.
      @param price The value to be stored in price.  
   */
   public void setPrice(int price)
   {
      this.price = price;
   }
   
   /**
		This function returns the place price.
		@return price The place price.
   */
   public int getPrice()
   {
      return price;
   }
   
   /**
      This method sets the place object attribute.
      @param place The object to be copied and stored in place.  
   */
   public void setPlace(Place place)
   {
      this.place = new Place(place); 
   }
   
   /**
		This function returns the place object.
		@return place The place object, containing city and state.
   */
   public Place getPlace()
   {
      Place placeRef = new Place(place);
      return placeRef;
   }



   /**
      This function returns a boolean based on whether the parameter object
      is the same as the current object.
      @param compare The RecreationPlace object to be compared against the current object.
      @return same A true or false on whether the objects are the same.
   */
   public boolean equals(RecreationPlace compare)
   {
      boolean same = false;
      
      //If object attributes are all same
      if (this.name.equalsIgnoreCase(compare.name) &&
         this.type.equalsIgnoreCase(compare.type) &&
         this.price == compare.price &&
         this.place.equals(compare.place))
         same = true; //same is true
         
         return same;
   }
   
   /**
      This function returns a copy of the current RecreationPlace object.
      @return recPlaceCopy A copy of the current object.
   */
   public RecreationPlace copy()
   {
      RecreationPlace recPlaceCopy = new RecreationPlace(name, type, price, place);
      
      return recPlaceCopy;
   }
   
   /**
      This method returns the current state of the object.
      @return output The current state of all attributes.
   */
   public String toString()
   {
      String str = "";
      str += "\nName: " + this.name;
      str += "\nType: " + this.type;
      str += "\nPrice: $" + this.price;
      str +=  place;  //implicit call
      
      return str;
   }   
}