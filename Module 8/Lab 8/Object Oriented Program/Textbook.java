/**
   Class definition for a Textbook, defines the book category, price, name, and "has an" Author.
*/

public class Textbook
{
   //author : Author
   private Author author;
   
   //name: String
   private String bookName;
   
   //category : String
   private String category;
   
   //price : double
   private double price;
   
   
   //default constructor
   public Textbook()
   {
      this.author = new Author();
      this.bookName = "";
      this.category = "";
      this.price = 0.0;
   }
   
   //second constructor with author, category,  
   //price as parameters
   //DOES THIS NEED TO IMPORT AN AUTHOR OBJECT?****************
   public Textbook(String authorName, String authorAddress, String bookName, 
                   String category, double price)
   {
      this.author = new Author(authorName, authorAddress);
      this.bookName = bookName;
      this.category = category;
      this.price = price;
   }
   
   /*
   //copy constructor
   //are getters correct here? ***************
   public Textbook(Textbook copy)
   {
      this.author = new Author(copy.author.getAuthorName(), copy.author.getAddress());
      this.bookName = copy.bookName;
      this.category = copy.category;
      this.price = copy.price;
   }
   */
   //second constructor with author, category,  
   //price as parameters
   public Textbook(Author author, String bookName, 
                   String category, double price)
   {
      this.author = new Author(author);
      this.bookName = bookName;
      this.category = category;
      this.price = price;
   }
   
   //copy constructor
   //are getters correct here? ***************
   public Textbook(Textbook copy)
   {
      this.author = new Author(copy.author);
      this.bookName = copy.bookName;
      this.category = copy.category;
      this.price = copy.price;
   }
   
   /**
      author getter
   */
   public Author getAuthor()
   {
      Author authorCopy = new Author(this.author);
      return authorCopy;
   }
   
   /**
      author setter
   */
   public void setAuthor(String authorName, String address)
   {
      this.author = new Author(authorName, address);
   }
   
   /**
      author setter
   */
   public void setAuthor(Author author)
   {
      this.author = new Author(author);
   }
   
   /**
      bookName getter
   */
   public String getBookName()
   {
      return bookName;
   }
   
   /**
      bookName setter
   */
   public void setBookName(String bookName)
   {
      this.bookName = bookName;
   }
   
   
   /**
      category getter
   */
   public String getCategory()
   {
      return category;
   }
   
   /**
      category setter
   */
   public void setCategory(String category)
   {
      this.category = category;
   }
   
   
   /**
      price getter
   */
   public double getPrice()
   {
      return price;
   }
   
   /**
      price setter
   */
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   //equals()
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
   
   //toString()
   public String toString()
   {
      String str = "";
      str += this.author;
      str += "\nTextbook title: " + this.bookName;
      str += "\nCategory: " + this.category;
      str += "\nPrice: $" + this.price;
      
      return str;
   }
   
   //reducePrice(percentage : double)
   //Create a method to be able to take the price 
   //and reduce it by a percentage of the total 
   //current price and print that out.  You have 
   //direct access to that price. 
   public void reducePrice(double percent)
   {
      double reduced = 0.0;
      reduced = price - (price * percent);

      System.out.println("Reduced price: $" + reduced);      
   } 
  
} //end class