import java.util.Scanner; //user input

/**
   CTP 150-400 Lab 10-11
   Payroll Application
   @author Claire Dupree
   @since 5/6/22
*/   
public class PayrollDriver
{
   public static void main(String[] args)
   {
      //create employee payroll object
      Payroll employee1 = new Payroll();
      //scanner for user input
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Add a new employee to payroll:");
      
      //input employee name
      try {
         System.out.print("Enter name: ");
         employee1.setEmployeeName(scan.nextLine());
      } catch (EmptyStringException e) {
         System.out.println("\t" + e.getMessage());
      }
      
      //input employee id number
      try {
         System.out.print("Enter ID number: ");
         employee1.setIdNumber(scan.nextLine());
      } catch (EmptyStringException e) {
         System.out.println("\t" + e.getMessage());
      }
      
      //input hourly pay rate
      try {
         System.out.print("Enter hourly pay rate: $");
         employee1.setPayRate(scan.nextDouble());
      } catch (InvalidPayRateException e) {
         System.out.println("\t" + e.getMessage());
      }
      
      //input hours worked  
      try {
         System.out.print("Enter hours worked: ");
         employee1.setHoursWorked(scan.nextDouble());
      } catch (InvalidHoursWorkedException e) {
         System.out.println("\t" + e.getMessage());
      }    
      
      //print data, incl. gross pay
      System.out.println("-------------------------------");
      System.out.println(employee1);
   }
}