public class Dealer extends Player {

	public Hand dealerHand= new Hand();
	private int dealerBet=100;
	Player p=new Player();
	
	@Override
	public void hit()
	{
		System.out.println("Dealer is making a decision...");
		
		if(dealerHand.getHandValue()>17)
		{
			System.out.println("Dealer Stays");
			if(dealerHand.getHandValue()>21)
			{
				//bust();
				System.out.println("Dealer Busts!");
				lose();
				return;
			}
			stay();
			return;
		}
		else
		{ 
			dealerHand.add();
			if(dealerHand.getCardsHeld()>super.h.getCardsHeld())
				return;
			else
				hit();
		}
		if(dealerHand.getHandValue()>21)
		{
			System.out.println("Dealer Busts!");
			lose();
			return;
		}
	}
	@Override
	public boolean stay()
	{
		return true;
	}
	
	@Override
	public void seeCards()
	{
		dealerHand.getHand();
	}
	//@Override
	public boolean dealerLose()
	{
		dealerHand.clear();
		return true;
	}
	@Override
	public void reset()
	{
		dealerHand.clear();
	}
	
}
