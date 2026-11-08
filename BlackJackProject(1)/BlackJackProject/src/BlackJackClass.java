
public class BlackJackClass {
	int prizePool=0;
	Player p;
	Dealer d;
	
	
	public static <T extends Comparable<T>> int compareCards(T p1, T p2)
	{
		if(p1.compareTo(p2)>0)
			return 1;
		if (p1.equals(p2))
			return 2;
		else 
			return 3;
	}

	public void PrizePot(Player p)
	{
		int playerBet = p.getBet()*2;
		//int dealerBet=d.getBet();
		prizePool=playerBet;
		
	}
	public void fold(Player p)
	{
		int playerBet = p.getBet();
		//int dealerBet=d.getBet();
		prizePool=0;
	}
	
	public int getPrize()
	{
		//prizePot();
		return prizePool;
	}
	void reset()
	{
		prizePool=0;
	}
	
}
