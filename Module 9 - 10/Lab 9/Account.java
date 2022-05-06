/**
   CTP 150-400 Lab 9
   Account class definition
   
   @author Claire Dupree
   @since 4-29-22
*/

public abstract class Account
{
   private String name;
   private double balance;
   private final double ANNUAL_INTEREST_RATE = 0.045;
   
   public Account()
   {
      this.name = "";
      this.balance = 0.0;
   }
   
   public Account(String name, double balance)
   {
      this.name = name;
      this.balance = balance;
   }
   
   public Account(Account copy)
   {
      this.name = copy.name;
      this.balance = copy.balance;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setBalance(double balance)
   {
      this.balance = balance;
   }
   
   public double getBalance()
   {
      return this.balance;
   }
   
   public double getAnnualInterestRate()
   {
      return this.ANNUAL_INTEREST_RATE;
   }
   
   /**
      Abstract method to return the monthly interest rate of an account.
   */
   public abstract double getMonthlyInterestRate();
   
   public void withdraw(int amount)
   {
      this.balance -= amount;
   }
   
   public void deposit(int amount)
   {
      this.balance += amount;
   }
   
   public boolean equals(Account compare)
   {
      boolean same = false;
      
      if (this.name.equals(compare.name) &&
          this.balance == compare.balance)
          same = true;
      
      return same;
   }
   
   public String toString()
   {
      String str = "";
      str += "\nOwner: " + this.name;
      str += "\nBalance: $" + this.balance;
      
      return str;
   }
}