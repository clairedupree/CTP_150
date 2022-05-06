/**
   CTP 150-400 Lab 9
   CheckingAccount class definition
   Is an Account
   <br>
   @author Claire Dupree
   @since 4-29-22
*/
public class CheckingAccount extends Account
{
   /**
      Private, static attribute for the checking account overdraft limit.
   */
   private static double overdraftLimit = 5000;
   
   /**
      This constructor sets all non-static attributes to default values.
   */
   public CheckingAccount()
   {
      super();
   }
   
   /**
      This constructor sets all non-static attributes to parameter values.
      @param name The value to be stored in name.
      @param balance The value to be stored in balance.
   */
   public CheckingAccount(String name, double balance)
   {
      super(name, balance);
   }
   
   /**
      This constructor creates a copy of an existing CheckingAccount object.
      @param copy The CheckingAccount object to be copied.
   */
   public CheckingAccount(CheckingAccount copy)
   {
      super(copy.getName(), copy.getBalance());
   }
   
   @Override
   /**
      This function overrides an abstract method in Account, and
      returns the monthly interest rate of the account. Checking 
      accounts do not accrue interest so this method returns 0.
      @return 0.0 A numeric literal for the 0% monthly interest rate.
   */
   public double getMonthlyInterestRate()
   {
      //checking accts do not accrue interest
      return 0.0;
   }
   
   /**
      This method sets the static overdraft limit for CheckingAccount objects.
      @param overdraftLimit The value to be stored in overdraftLimit.
   */
   public void setOverdraftLimit(double overdraftLimit)
   {
      this.overdraftLimit = overdraftLimit;
   }
   
   /**
      This function returns the value of the current overdraft limit.
      @return overdraftLimit The current value of the overdraft limit.
   */
   public double getOverdraftLimit()
   {
      return this.overdraftLimit;
   }
   
   /**
      This function compares the a parameter object to the current 
      object and returns a boolean true if the objects attributes are the same.
      @param compare The object to be compared.
      @return same A true/false value of whether the objects are the same.
   */
   public boolean equals(CheckingAccount compare)
   {
      boolean same = false;
      
      if (this.getName().equals(compare.getName()) &&
          this.getBalance() == compare.getBalance() &&
          this.overdraftLimit == compare.overdraftLimit)
          same = true;
      
      return same;
   }
   
   /**
      This function returns the current state of the object.
      @return str The current state of all attributes.
   */
   public String toString()
   {
      String str = "";
      str += "\nType: Checking Account";
      str += super.toString();
      //str += "\nOverdraft limit: $" + this.overdraftLimit;
      //str += "\nMonthly interest rate: " + getMonthlyInterestRate() + "%";
      //str += "\nMonthly interest: $" + (getMonthlyInterestRate() * getBalance());
      
      return str;
   }
}