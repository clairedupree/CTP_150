/**
   CTP 150-400 Lab 10-11
   Invalid hours worked value exception class definition
   @author Claire Dupree
   @since 5/6/22
*/
public class InvalidHoursWorkedException extends Exception
{
   public InvalidHoursWorkedException()
   {
      super("Error: invalid value for hours worked");
   }
   
   public InvalidHoursWorkedException(double input)
   {
      super("Error: invalid value of " + input + " for hours worked");
   }
}