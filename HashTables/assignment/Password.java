package assignment;

import java.util.HashMap;

public class Password 
{
	String userID, hash, salt;
	HashMap<String, String> database = new HashMap<String, String>();
	
	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	public String getHash()
	{
		return hash;
	}

	public void setHash(String hash)
	{
		this.hash = hash;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	
	
}
