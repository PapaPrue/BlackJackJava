import java.util.*;
import java.io.*;
public class Player {
	private String name;
	private int money;
	public int bet;
	private int wins=0;
	private int lose;
	public Hand h= new Hand();
	
	public Player()
	{
		name= " ";
		money=100;
		//bet=0;
		wins=0;
		lose=0;
	}
	public Player(String n, Hand h, int m, int b)
	{
		this.name=n;
		this.h=h;
		this.money=m;
		this.bet=b;
	}
	
	public int getMoney()
	{
		return money;
	}
	public int getWins()
	{
		//wins+=1;
		return wins;
	}
	public String getName()
	{
		return name;
	}
	public int getBet()
	{
		return bet;
	}
	public void hit()
	{
		h.add();
		//System.out.println(h.getCardsHeld());
		if(h.getHandValue()>21)
		{
			System.out.println("Bust! You lose...");
			lose();
		}
	}
	public void SetName(String n)
	{
		name=n;
	}
	public void SetMoney(int m)
	{
		money=m;
	}
	
	public void seeCards()
	{
		h.getHand();
	}
	
	public boolean stay()
	{
		return true;
	}
	public void lose()
	{
		money-=bet;
		
	}
	public boolean fold()
	{
		System.out.println("You fold and decide to keep your money...");
		return true;
	}
	
	public void setBet(int b) throws Exception
	{
			if(b<=money&&b!=0&&b>0)
				bet=b;
			else if(money<=0||b<0)
			{
				System.out.println("No money. You head home broke");
				System.exit(0);
			}
			else {
				System.err.print("Illegal bet has been made. You have been kicked out of the casino");
				System.exit(0);
			}
	}
	public void reset()
	{
		h.clear();
		
	}
	
}