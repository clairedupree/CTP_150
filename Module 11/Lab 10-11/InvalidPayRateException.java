/**
   CTP 150-400 Lab 10-11
   Invalid pay rate value exception class definition
   @author Claire Dupree
   @since 5/6/22
*/
public class InvalidPayRateException extends Exception
{
   public InvalidPayRateException()
   {
      super("Error: invalid value for hourly pay rate");
   }
   
   public InvalidPayRateException(double input)
   {
      super("Error: invalid value of " + input + " for hourly pay rate");
   }
}