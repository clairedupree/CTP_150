/**
   CTP 150-400 | Lab 8
   Class definition for an Author, defines the author name and address.
   <br>
   @author Claire Dupree
   @since 4/16/22
*/

public class Author
{   
   /**
      Private attribute for the author's name.
   */
   private String authorName;
   
   /**
      Private attribute for the author's address.
   */   private String address;
   
   
   /**
		This constructor creates an Author object with default 
      values for all attributes.
   */
   public Author()
   {
      this.authorName = "";
      this.address = "";
   }
   
   /**
		This constructor creates an Author with input values for all attributes.
      @param authorName The author's name.
      @param address The author's address.
   */
   public Author(String authorName, String address)
   {
      this.authorName = authorName;
      this.address = address;
   }
   
   /**
      This constructor creates an Author with copied attributes 
      from an existing Author object.
      @param copy The Author object to be copied.
   */
   public Author(Author copy)
   {
      this.authorName = copy.authorName;
      this.address = copy.address;
   }
   
   
   /**
      Returns the private author name attribute.
      @return authorName The author's name.
   */
   public String getAuthorName()
   {
      return authorName;
   }
   
   /**
      Sets the value of the author name attribute.
      @param authorName The value to be stored in authorName.
   */
   public void setAuthorName(String authorName)
   {
      this.authorName = authorName;
   }


   /**
      Returns the private author address attribute.
      @return address The author's address.
   */
   public String getAddress()
   {
      return address;
   }
   
   /**
      Sets the value of the author address attribute.
      @param address The value to be stored in address.
   */
   public void setAddress(String address)
   {
      this.address = address;
   }
      
   
   /**
      This function returns a boolean based on whether the 
      parameter object is the same as the current object.
      @param compare The Author object to be compared against the current object.
      @return same A true or false on whether the objects are the same.
   */
   public boolean equals(Author compare)
   {
      boolean same = false;
      if (this.authorName.equals(compare.getAuthorName()) &&
          this.address.equals(compare.getAddress()))
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
      str += "\nAuthor name: " + this.authorName;
      str += "\nAuthor address: " + this.address;
      
      return str;
   }
  
} //end class