/**
	CTP 150-400 | Lab 7
   <br>
	Class defintion of a place, contains attributes for the city and state.
      
	@author Claire Dupree
	@since 04/10/22
*/

public class Place
{
   /**
      Private attribute for the city.
   */
   private String city;
   
   /**
      Private attribute for the state.
   */
   private String state;
   
   
   
   /**
		This constructor creates a recreation place with default values for all attributes.
   */
   public Place()
   {
      this.city = "";
      this.state = "";
   }
   
   /**
		This constructor creates a place with input values for all attributes.
      @param city The place city.
      @param state The place state.
   */
   public Place(String city, String state)
   {
      this.city = city;
      this.state = state;
   }
   
   /**
      This constructor creates a place with copied attributes from an existing object.
      @param copy The place object to be copied.
   */
   public Place(Place copy)
   {
      this.city = copy.city;
      this.state = copy.state;
   }
   
   
   
   /**
      This method sets the place city attribute.
      @param city The value to be stored in city.      
   */
   public void setCity(String city)
   {
      this.city = city;
   }
   
   /**
		This function returns the place city.
		@return city The place city.
   */
   public String getCity()
   {
      return city;
   }

   /**
      This method sets the place state attribute.
      @param state The value to be stored in state.      
   */
   public void setState(String state)
   {
      this.state = state;
   }
   
   /**
		This function returns the place state.
		@return state The place state.
   */
   public String getState()
   {
      return state;
   }
   
   
   
   /**
      This function returns a boolean based on whether the parameter object
      is the same as the current object.
      @param compare The Place object to be compared against the current object.
      @return same A true or false on whether the objects are the same.
   */
   public boolean equals(Place compare)
   {
      boolean same = false;
      if (this.city.equalsIgnoreCase(compare.city) &&
         (this.state.equalsIgnoreCase(compare.state)))
         same = true;
         
      return same; 
   }
   
   /**
      This method returns the current state of the object.
      @return output The current state of all attributes.
   */
   public String toString()
   {
      String str = "";
      str += "\nCity: " + this.city;
      str += "\nState: " + this.state;
      
      return str;
   }
   
   /**
      This function returns the abbreviated initials of the object't state attribute.
      @return initials The initials of the state.
   */
   public String getStateInitials()
   {
      String initials = "";
            
      switch(this.state.toLowerCase())
      {
         case "maryland": 
            initials = "MD";
            break;
         case "delaware": 
            initials = "DE";
            break;
         case "florida": 
            initials = "FL";
            break;
         case "ohio":
            initials = "OH";
            break;
         case "pennsylvania": 
            initials = "PA";
            break;
         default: 
            System.out.println("Invalid state, initials not available");
      }
      
      return initials;
   }
}