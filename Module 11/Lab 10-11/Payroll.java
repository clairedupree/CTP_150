import java.text.DecimalFormat; //currency formatting

/**
   CTP 150-400 Lab 10-11
   Payroll class definition
   @author Claire Dupree
   @since 5/6/22
*/
public class Payroll
{
   //private attributes
   private String employeeName, idNumber;
   private double payRate, hoursWorked;
   
   //default constructor
   public Payroll() 
   {
      this.employeeName = "";
      this.idNumber = "";
      this.payRate = 0.0;
      this.hoursWorked = 0.0;
   }
   
   //overloaded constructor
   public Payroll(String employeeName, String idNumber) throws EmptyStringException
   {
      if (employeeName.equals(""))
         throw new EmptyStringException();

      this.employeeName = employeeName;
         
      if (idNumber.equals(""))
         throw new EmptyStringException();

      this.idNumber = idNumber;
   }
   
   
   //setter employeeName
   public void setEmployeeName(String employeeName) throws EmptyStringException
   {
      if (employeeName.equals(""))
         throw new EmptyStringException();

      this.employeeName = employeeName;
   }
   
   //getter employeeName
   public String getEmployeeName()
   {
      return this.employeeName;
   }
   
   
   //setter idNumber
   public void setIdNumber(String idNumber) throws EmptyStringException
   {
      if (idNumber.equals(""))
         throw new EmptyStringException();

      this.idNumber = idNumber;
   }
      
   //getter idNumber
   public String getIdNumber()
   {
      return this.idNumber;
   }   
   
   
   //setter payRate
   public void setPayRate(double payRate) throws InvalidPayRateException
   {
      if (payRate < 0 || payRate > 25)
         throw new InvalidPayRateException(payRate);

      this.payRate = payRate;
   }
       
   //getter payRate
   public double getPayRate()
   {
      return payRate;
   }   
   
   
   //setter hoursWorked
   public void setHoursWorked(double hoursWorked) throws InvalidHoursWorkedException
   {
      if (hoursWorked < 0 || hoursWorked > 84)
         throw new InvalidHoursWorkedException(hoursWorked);

      this.hoursWorked = hoursWorked;
   } 
   
   //getter hoursWorked
   public double getHoursWorked()
   {
      return hoursWorked;
   }  
   
   
   //get gross pay
   public double getGrossPay()
   {
      return (hoursWorked * payRate);
   }
   
   //returns current state of the object
   public String toString()
   {
      DecimalFormat dollar = new DecimalFormat("$#,##0.00");
      String str = "";
      
      str += "Employee name: " + this.employeeName;
      str += "\nID number: " + this.idNumber;
      str += "\nHourly rate: " + dollar.format(this.payRate);
      str += "\nHours worked: " + this.hoursWorked;
      str += "\nGross pay: " + dollar.format(getGrossPay());
      
      return str;
   }
}