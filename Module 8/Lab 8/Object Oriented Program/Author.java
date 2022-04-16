/**
   javadoc
*/

public class Author
{   
   //authorName: String
   private String authorName;
   
   //address : String
   private String address;
   
   
   //default constructor
   public Author()
   {
      this.authorName = "";
      this.address = "";
   }
   
   //second constructor with name and address as parameters
   public Author(String authorName, String address)
   {
      this.authorName = authorName;
      this.address = address;
   }
   
   //copy constructor
   //remember you dont need public methods because you have access to the whole object
   public Author(Author copy)
   {
      this.authorName = copy.authorName;
      this.address = copy.address;
   }
   
   
   /**
      authorName getter
   */
   public String getAuthorName()
   {
      return authorName;
   }
   
   /**
      authorName setter
   */
   public void setAuthorName(String authorName)
   {
      this.authorName = authorName;
   }


   /**
      address getter
   */
   public String getAddress()
   {
      return address;
   }
   
   /**
      address setter
   */
   public void setAddress(String address)
   {
      this.address = address;
   }
      
   
   //equals()
   public boolean equals(Author compare)
   {
      boolean same = false;
      if (this.authorName.equals(compare.getAuthorName()) &&
          this.address.equals(compare.getAddress()))
          same = true;
      
      return same;
   }
   
   //toString()
   public String toString()
   {
      String str = "";
      str += "\nAuthor name: " + this.authorName;
      str += "\nAuthor address: " + this.address;
      
      return str;
   }
  
} //end class