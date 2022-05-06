/**
   CTP 150-400 Lab 9
   SavingsAccount class definition
   Is an Account
   
   @author Claire Dupree
   @since 4-29-22
*/
public class SavingsAccount extends Account
{
   private static double overdraftLimit = 5000;
   
   public SavingsAccount()
   {
      super();
   }
   
   public SavingsAccount(String name, double balance)
   {
      super(name, balance);
   }
   
   public SavingsAccount(SavingsAccount copy)
   {
      super(copy.getName(), copy.getBalance());
   }
   
   @Override
   public double getMonthlyInterestRate()
   {
      return getAnnualInterestRate() / 12;
   }
   
   public void setOverdraftLimit(double overdraftLimit)
   {
      this.overdraftLimit = overdraftLimit;
   }
   
   public double getOverdraftLimit()
   {
      return this.overdraftLimit;
   }
   
   public boolean equals(SavingsAccount compare)
   {
      boolean same = false;
      
      if (this.getName().equals(compare.getName()) &&
          this.getBalance() == compare.getBalance() &&
          this.overdraftLimit == compare.overdraftLimit)
          same = true;
      
      return same;
   }
   
   public String toString()
   {
      String str = "";
      str += "\nType: Savings Account";
      str += super.toString();
      //str += "\nOverdraft limit: $" + this.overdraftLimit;
      //str += "\nMonthly interest rate: " + getMonthlyInterestRate() + "%";
      //str += "\nMonthly interest: $" + (getMonthlyInterestRate() * getBalance());
      
      return str;
   }
}