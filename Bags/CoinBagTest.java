import java.util.Random;

/*
 * Program: CoinBagTest.java
 * Purpose: To simulate the exchanging of coins using bags
 * Author: Jonathan Lee
 * Date Due: 2/23/2017
 */

public class CoinBagTest
{
	//driver class that initially creates $1000 worth of random coin values
	//for an instance of BankCoinBag
	public static void main(String[] args)
	{
		BankCoinBag<Coin> bank = new BankCoinBag<Coin>();
		CoinBag test = new CoinBag();
		test.fillBank(bank);
		test.runProgram(bank);
	} // end main
}

class CoinBag
{
	ShopperCoinBag<Coin> shopper = new ShopperCoinBag<Coin>();
	MerchantCoinBag<Coin> merchant = new MerchantCoinBag<Coin>();
	Random rand = new Random();
	private int productPrice, totalTransactionValue;
	Coin nickel = new Coin(5);
	Coin dime = new Coin(10);
	Coin quarter = new Coin(25);
	Coin halfDollar = new Coin(50);

	public void runProgram(BankCoinBag<Coin> bank)
	{
		int bankCounter = 0;
		int transactionCounter = 0;
		
		try
		{
			while (bank.getBalance() > 0)
			{
				//before each visit, coins are transferred form the bank to the shopper object
				withdrawFromBank(bank, shopper);
				bankCounter++;
				generateWeeklyPrice();
				//determines whether the shopper can afford to purchase
				//from merchant
				if (shopper.getBalance() >= productPrice)
				{
					
					//way to check if merchant will have enough change before transaction commences
					//prevents the program from breaking early on due to an infinite loop
					if(productPrice >= 400 && merchant.getBalance() <= productPrice)
					{
						System.out.println("Merchant does not have enough change. Transaction Cancelled");
					}
					else
					{
					System.out.println("Transaction successful");
					System.out.println("Merchant bal: " + merchant.getBalance() + " cents");
					System.out.println("Shopper bal: " + shopper.getBalance() + " cents");
					System.out.println("Product Price: " + productPrice + " cents");
					System.out.println("Bank bal: " + bank.getBalance() + " cents\n");
					
					totalTransactionValue += productPrice;
					beginTransaction(shopper, merchant);
					transactionCounter++;
					}

				}
				else
				{
					System.out.println("Transaction unsuccessful\n");
				}
			}
		} catch (NullPointerException e)
		{

		}

		System.out.println("Done");
		System.out.printf("Number of market visits: %d\n", bankCounter);
		System.out.printf("Number of transactions: %d\n", transactionCounter);
		System.out.printf("Total transaction value: %d cents\n", totalTransactionValue);
		System.out.printf("Average transaction value: %d cents", (totalTransactionValue/transactionCounter));
	}

	//retrieves elements from ShopperCoinBag object, transferring it over to the
	//ShopperCoinBag object during each transaction
	private void beginTransaction(ShopperCoinBag<Coin> shopper, MerchantCoinBag<Coin> merchant)
	{
		while (productPrice != 0)
		{
			while (productPrice > 0)
			{

				Coin removedCoin = (Coin) shopper.grab();
//				System.out.println("Removed a " + removedCoin.getCoinName() + ".");
				shopper.setBalance(shopper.getBalance() - removedCoin.getValue());
				merchant.add(removedCoin);
				merchant.setBalance(merchant.getBalance() + removedCoin.getValue());
				productPrice -= removedCoin.getValue();
			}
			giveChange();
		}
	}
	
	private void giveChange()
	{
		//simulates the merchant giving change back to the shopper
		if (productPrice <= -50 && merchant.contains(halfDollar))
		{
			merchant.remove(halfDollar);
			merchant.setBalance(merchant.getBalance() - halfDollar.getValue());
			shopper.add(halfDollar);
			shopper.setBalance(shopper.getBalance() + halfDollar.getValue());
			productPrice += halfDollar.getValue();
	//		System.out.println("50C CHANGE GIVEN BACK");
		}

		else if (productPrice <= -25 && merchant.contains(quarter))
		{
			merchant.remove(quarter);
			merchant.setBalance(merchant.getBalance() - quarter.getValue());
			shopper.add(quarter);
			shopper.setBalance(shopper.getBalance() + quarter.getValue());
			productPrice += quarter.getValue();
		//	System.out.println("25C CHANGE GIVEN BACK");
		}

		else if (productPrice <= -10 && merchant.contains(dime))
		{
			merchant.remove(dime);
			merchant.setBalance(merchant.getBalance() - dime.getValue());
			shopper.add(dime);
			shopper.setBalance(shopper.getBalance() + dime.getValue());
			productPrice += dime.getValue();
		//	System.out.println("10C CHANGE GIVEN BACK");
		}

		else if (productPrice <= -5 && merchant.contains(nickel))
		{
			merchant.remove(nickel);
			merchant.setBalance(merchant.getBalance() - nickel.getValue());
			shopper.add(nickel);
			shopper.setBalance(shopper.getBalance() + nickel.getValue());
			productPrice += nickel.getValue();
		//	System.out.println("5C CHANGE GIVEN BACK");
		}
	}
	

	//generates new random price between $1-10
	//before each potential transaction
	//multiplied by 100 to convert it to dollars since we're dealing with cents
	private int generateWeeklyPrice()
	{
		productPrice = (rand.nextInt(10) + 1) * 100;
		return productPrice;
	}

	//fills bank with $1000 worth of random coin values
	//using integer values to present coin values for more precision
	public void fillBank(BankCoinBag<Coin> bank)
	{

		while (bank.getBalance() != 100000)
		{
			while (bank.getBalance() < 100000)
			{
				int randCoinPick = rand.nextInt(4) + 1;
				switch (randCoinPick)
				{
				case 1:
					bank.add(nickel);
					bank.setBalance(bank.getBalance() + 5);
					break;
				case 2:
					bank.add(dime);
					bank.setBalance(bank.getBalance() + 10);
					break;
				case 3:
					bank.add(quarter);
					bank.setBalance(bank.getBalance() + 25);
					break;
				case 4:
					bank.add(halfDollar);
					bank.setBalance(bank.getBalance() + 50);
					break;
				}
			}

			while (bank.getBalance() > 100000)
			{
				Coin removedCoin = (Coin) bank.grab();
				bank.setBalance(bank.getBalance() - removedCoin.getValue());
			}
		}
	}

	//retrieves elements from BankCoinBag to put into ShopperCoinBag object
	private void withdrawFromBank(BankCoinBag<Coin> bank, ShopperCoinBag<Coin> shopper)
	{
		for (int i = 0; i < 10; i++)
		{
			Coin removedCoin = (Coin) bank.grab();
			bank.setBalance(bank.getBalance() - removedCoin.getValue());

			shopper.add(removedCoin);
			shopper.setBalance(shopper.getBalance() + removedCoin.getValue());
		}
	}
}
