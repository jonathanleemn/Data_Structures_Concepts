package accounts;

import java.util.Random;

public class Account {
	 private double balance;
	  private String name;
	  private long acctNum;
	  private Random generator=new Random();

	  //----------------------------------------------
	  //Constructor -- initializes balance, owner, and account number
	  //----------------------------------------------
	  public Account(double initBal, String owner, long number)
	  {
	    balance = initBal;
	    name = owner;
	    acctNum = number;
	  }

	  public Account(double initBal, String owner){
		  balance = initBal;
		  name = owner;
		  acctNum = generator.nextInt(999999)+1;
	  }
	  
	  public Account(String owner){
		  balance = getBalance();
		  name = owner;
		  acctNum = setAcctNum();	  
	  }
	  
	  //transfers money from passed object into the calling object
	  public void transfer(Account acct, double amnt){
		  	  acct.withdraw(amnt);//passed object
		  	  this.deposit(amnt);//caling object
	  }
	 
	  private long setAcctNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	//----------------------------------------------
	  // Checks to see if balance is sufficient for withdrawal.
	  // If so, decrements balance by amount; if not, prints message.
	  //----------------------------------------------
	  public void withdraw(double amount)
	  {
	    if (balance >= amount)
	       balance -= amount;
	    else
	       System.out.println("Insufficient funds");
	  }

	  //----------------------------------------------
	  // Adds deposit amount to balance.
	  //----------------------------------------------
	  public void deposit(double amount)
	  {
	    balance += amount;
	  }

	  //----------------------------------------------
	  // Returns balance.
	  //----------------------------------------------
	  public double getBalance()
	  {
	    return balance;
	  }


	  //----------------------------------------------
	  // Returns a string containing the name, account number, and balance.
	  //----------------------------------------------
	 
	  public String toString()
	  {
		  return "Account holder: "+name+"\nAccount number: "+acctNum+"\nBalance: "+balance+"\n";
	  }

	  //----------------------------------------------
	  // Deducts $10 service fee
	  //----------------------------------------------
	  public double chargeFee()
	  {
	    balance-=10;
	    return balance;
	  }

	  //----------------------------------------------
	  // Changes the name on the account 
	  //----------------------------------------------
	  public void changeName(String newName){
		  name=newName;
	  }
	   

		public void setName(String name) {
			this.name=name;
			
		}
}
