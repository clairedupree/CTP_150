/**
   CTP 150-400 Lab no. 4: 
   The Shoe class stores data about a shoe.
      
   @author Claire Dupree
   @since 3/13/22
*/

public class Shoe
{
   /**
      Private attribute for shoe brand.
   */
   private String brand; 
   
   /**
      Private attribute for shoe type.
   */
   private String type;

   /**
      Private attribute for shoe price.
   */   
   private double price; 

   /**
      Private attribute for shoe size, with half-sizing.
   */   
   private double size; 
   
   
   /**
      This constructor initializes all fields to 0 or null.
   */
   public Shoe()
   {
      brand = "";
      type = "";
      price = 0.0;
      size = 0.0;
   }
   
   /**
      This constructor initializes all fields to the data
      sent as arguments to the module.
      @param brand The value to store in the brand field.
      @param type The value to store in the type field.
      @param price The value to store in the price field.
      @param size The value to store in the size field.      
   */
   public Shoe(String brand, String type, double price, double size)
   {
      this.brand = brand;
      this.type = type;
      this.price = price;
      this.size = size;
   }
   
   /**
      The getBrand function returns the value of the shoe brand.
      @return brand The value in the brand field.
   */
   public String getBrand()
   {
      return brand;
   }
   
   /**
      The setBrand method sets the shoe brand.
      @param brand The value to store in the brand field.
   */
   public void setBrand(String brand)
   {
      this.brand = brand;
   }
  
  
   /**
      The getType function returns the value of the shoe type.
      @return type The value in the type field.
   */
   public String getType()
   {
      return type;
   }
   
   /**
      The setType method sets the shoe type.
      @param type The value to store in the type field.
   */
   public void setType(String type)
   {
      this.type = type;
   }
   
   
   /**
      The getPrice function returns the value of the shoe price.
      @return price The value in the price field.
   */
   public double getPrice()
   {
      return price;
   }
   
   /**
      The setPrice method sets the shoe price.
      @param price The value to store in the price field.
   */
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   
   /**
      The getSize function returns the value of the shoe size.
      @return size The value in the size field.
   */
   public double getSize()
   {
      return size;
   }   
   
   /**
      The setSize method sets the shoe size.
      @param size The value to store in the size field.
   */
   public void setSize(double size)
   {
      this.size = size;
   }
   
   
   /**
      The getDiscount function returns the discounted price of a shoe, 
      all boot-type shoes are 50% off. For all other shoe types,
      no discount is applied.
      @return discount The price of the shoe after discounts are applied.
   */
   public double getDiscount()
   {
      double discount = price; // Starting discount is 0% off
      
      if (type == "boot" || type == "Boot") // If the shoe is a boot,
      {
         discount = price * 0.5; // discount by 50% off
      }
      
      return discount;  // Return the discounted price
   }
   
   
   /**
      The toString method prints the current state of the Shoe object.
      @return output Returns the values of all object fields.
   */
   public String toString()
   {
      String output = "";
      output += "The shoe brand is: " + brand;
      output += "\nThe shoe type is: " + type;
      output += "\nThe shoe price is: $" + price;
      output += "\nThe shoe size is: " + size;
      
      return output;
   }
}