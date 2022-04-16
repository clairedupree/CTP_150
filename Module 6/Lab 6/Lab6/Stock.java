/**
	CTP 150-400 | Lab 6
   <br>
	Class defintion of a stock, contains attributes for the 
	stock symbol, name, and current price.
   
	@author Claire Dupree
	@since 04/01/22
*/

public class Stock
{
	/**
		Private attribute for the stock symbol.
	*/
	private String symbol;

	/**
		Private attribute for the stock name.
	*/
	private String name;

	/**
		Private attribute for the current price of the stock.
	*/
	private double currentPrice;
	
	
   
	/**
		This constructor creates a stock with default values for all attributes.
	*/
	public Stock()
	{
		symbol = "";
		name = "";
		currentPrice = 0.0;
	}

	/**
		This constructor creates a stock with user-input values for all attributes.
      @param symbol The stock symbol.
      @param name The stock name.
      @param currentPrice The current price per stock.
	*/
	public Stock(String symbol, String name, double currentPrice)
	{
		this.symbol = symbol;
		this.name = name;
      this.currentPrice = currentPrice;
	}
	
   
   
	/**
		This function returns the stock symbol.
		@return symbol The stock symbol.
	*/
	public String getSymbol()
	{
		return symbol;
	}

	/**
      This method sets the stock symbol attribute.
      @param symbol The value to be stored in symbol.      
   */
   public void setSymbol(String symbol)
   {
      this.symbol = symbol;
   }
   	
      	
	
	/**
		This function returns the stock name.
		@return name The stock name.
	*/
	public String getName()
	{
		return name;
	}

	/**
      This method sets the stock name attribute.
      @param name The value to be stored in name.      
   */
   public void setName(String name)
   {
      this.name = name;
   }
	
   
   
	/**
		This function returns the current stock price.
		@return currentPrice The current stock price.
	*/
	public double getCurrentPrice()
	{
		return currentPrice;
	}

	/**
      This method sets the current stock price.
      @param currentPrice The value to be stored in currentPrice.
   */
   public void setCurrentPrice(double currentPrice)
   {
      this.currentPrice = currentPrice;
   }
   
   
   
   /**
      This method returns the current state of the object.
      @return output The current state of all attributes.
   */
   public String toString()
   {
      String output = "";
      output += "\nStock symbol: " + symbol;
      output += "\nStock name: " + name;
      output += "\nCurrent stock price: $" 
             + currentPrice + " per stock\n";
      
      return output;
   }
   					
} //end class