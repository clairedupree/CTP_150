/**
   CTP 150-400 Lab 10-11
   Empty string exception class definition
   @author Claire Dupree
   @since 5/6/22
*/
public class EmptyStringException extends Exception
{
   public EmptyStringException()
   {
      super("Error: input may not be blank");
   }
   
   public EmptyStringException(String input)
   {
      super("Error: input may not be blank");
   }
}