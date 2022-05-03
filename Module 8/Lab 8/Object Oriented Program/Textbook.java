/**
   CTP 150-400 | Lab 8
   Class definition for a Textbook, defines the book category, price, name, and "has an" Author.
   <br>
   @author Claire Dupree
   @since 4/16/22
*/

public class Textbook
{
   /**
      Private object attribute for the Author,
      contains name and address.
   */
   private Author author;
   
   /**
      Private attribute for the book name.
   */
   private String bookName;
   
   /**
      Private attribute for the book category.
   */
   private String category;
   
   /**
      Private attribute for the book price.
   */
   private double price;
   
   
   /**
		This constructor creates a Textbook object with default 
      values for all attributes.
   */
   public Textbook()
   {
      this.author = new Author();
      this.bookName = "";
      this.category = "";
      this.price = 0.0;
   }
   
   /**
		This constructor creates a Textbook with input values for all attributes.
      @param authorName The author's name.
      @param authorAddress The author's address.
      @param bookName The book name.
      @param category The book category.
      @param price The book price.
   */
   public Textbook(String authorName, String authorAddress, String bookName, 
                   String category, double price)
   {
      this.author = new Author(authorName, authorAddress);
      this.bookName = bookName;
      this.category = category;
      this.price = price;
   }
   
   /*
   //Constructor with Author object instead of individual values
   public Textbook(Author author, String bookName, 
                   String category, double price)
   {
      this.author = new Author(author);
      this.bookName = bookName;
      this.category = category;
      this.price = price;
   }
   */
   
   /**
      This constructor creates a Textbook with copied attributes 
      from an existing Textbook object.
      @param copy The Textbook object to be copied.
   */
   public Textbook(Textbook copy)
   {
      this.author = new Author(copy.author);
      this.bookName = copy.bookName;
      this.category = copy.category;
      this.price = copy.price;
   }
   
   
   /**
      Returns the private Author object.
      @return author The author object.
   */
   public Author getAuthor()
   {
      Author authorCopy = new Author(this.author);
      return authorCopy;
   }
   
   /**
      Sets the values of the Author object based on individual
      values for name and address.
      @param authorName The author's name to be stored.
      @param address The author's address to be stored.
   */
   public void setAuthor(String authorName, String address)
   {
      this.author = new Author(authorName, address);
   }
   
   /*
      Sets the values of the Author object based on
      a parameter object to be copied.
      @param author An author object to be copied into author.
   public void setAuthor(Author author)
   {
      this.author = new Author(author);
   }
   */
   
   
   /**
      Returns the private book title attribute.
      @return bookName The book title.
   */
   public String getBookName()
   {
      return bookName;
   }
   
   /**
      Sets the value of the book name attribute.
      @param bookName The value to be stored in bookName.
   */
   public void setBookName(String bookName)
   {
      this.bookName = bookName;
   }
   
   
   /**
      Returns the private book category attribute.
      @return category The book category.
   */
   public String getCategory()
   {
      return category;
   }
   
   /**
      Sets the value of the book category attribute.
      @param category The value to be stored in category.
   */
   public void setCategory(String category)
   {
      this.category = category;
   }
   
   
   /**
      Returns the private book price attribute.
      @return price The book price.
   */
   public double getPrice()
   {
      return price;
   }
   
   /**
      Sets the value of the price category attribute.
      @param price The value to be stored in price.
   */
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   
   /**
      This function returns a boolean based on whether the 
      parameter object is the same as the current object.
      @param compare The Textbook object to be compared against the current object.
      @return same A true or false on whether the objects are the same.
   */
   public boolean equals(Textbook compare)
   {
      boolean same = false;
      if (this.author.equals(compare.author) &&
          this.bookName.equals(compare.bookName) &&
          this.category.equals(compare.category) &&
          this.price == compare.price)
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
      str += this.author;
      str += "\nTextbook title: " + this.bookName;
      str += "\nCategory: " + this.category;
      str += "\nPrice: $" + this.price;
      
      return str;
   }
   
   
   /**
      This method displays the reduced price of
      the Textbook based on a percetage amount.
      @param percent The percentage the price is to be reduced by.
   */
   public void reducePrice(double percent)
   {
      //Calculate amount to reduce based on percent
      double reduced = 0.0;
      reduced = price - (price * percent);

      //Display reduced price
      System.out.println("Reduced price: $" + reduced);      
   } 
  
} //end class