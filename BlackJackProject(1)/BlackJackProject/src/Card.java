import java.util.*;
import java.io.*;

public class Card implements Serializable{
	private String value;
	private String suit;
	
	//private Map<String, Integer> cardMap=new HashMap<>();
	private Card()
	{
		suit=" ";
		value=" ";			
	}
	
	public Card(String s, String v) 
	{
		this.value=v;
		this.suit=s;
	}
	public String getSuit()
	{
		return suit;
	}
	public String toString()
	{
		return String.format("%s of %s", value, suit);
	}
	public int getValue()
	{
		String y=value;
		if(y.equals("Jack")||y.equals("Queen")||y.equals("King"))
		{
			y="10";
		}
		if(y.equals("Ace"))
		{
			y = AceCheck();
		}
		int x= Integer.parseInt(y);
		return x;
	}
	public String AceCheck()
	{
		Player p=new Player();
		int x= 0;
		if (p.h.getHandValue()<11)
			x=11;
		else x=1;
		
		//aceScan.close();
		return Integer.toString(x);
		
			
	}
	
	
	
}
