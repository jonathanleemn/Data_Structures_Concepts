class Coin
{
	private CoinName myName;
	private int value; // In cents

	/**
	 * Constructs an object for the coin having a given value and mint year. The
	 * visible side of the new coin is set at random.
	 */
	public Coin(int coinValue)
	{
		switch (coinValue)
		{
		case 5:
			myName = CoinName.NICKEL;
			break;
		case 10:
			myName = CoinName.DIME;
			break;
		case 25:
			myName = CoinName.QUARTER;
			break;
		case 50:
			myName = CoinName.FIFTY_CENT;
			break;
		// default:
		// myName = CoinName.PENNY;
		// break;
		} // end switch

		value = coinValue;
	} // end constructor

	/**
	 * Constructs an object for the coin having a given name and mint year. The
	 * visible side of the new coin is set at random.
	 */
	public Coin(CoinName name)
	{
		switch (name)
		{
		case NICKEL:
			value = 5;
			break;
		case DIME:
			value = 10;
			break;
		case QUARTER:
			value = 25;
			break;
		case FIFTY_CENT:
			value = 50;
			break;
		// default:
		// value = 1;
		// break;
		} // end switch

		myName = name;
	} // end constructor

	/** Returns the name of the coin. */
	public CoinName getCoinName()
	{
		return myName;
	} // end getCoinName

	/** Returns the value of the coin in cents. */
	public int getValue()
	{
		return value;
	} // end getValue

} // end Coin
