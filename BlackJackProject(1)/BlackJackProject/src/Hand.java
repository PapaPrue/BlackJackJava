import java.io.*;

public class Hand implements Serializable {

	private Card[] hand= new Card[11];
	private int cardsHeld=0;
	Deck d=new Deck();
	//private boolean hasCards=false;
	
	public Hand()
	{
		for(int i=0;i<hand.length;i++)
			hand[i]=null;
		cardsHeld=0;
		
	}
	
	public void add()
	{
		Card card = d.draw();
		hand[cardsHeld]=card;
		cardsHeld++;
		if(cardsHeld<2)
		{
			add();
		}
	}
	
	public void clear()
	{
		cardsHeld=0;
		for(int i=0; i<hand.length;i++)
		{
			hand[i]=null;
			//System.out.println(hand[i]);
		}
		d.reset();
	}
	
	public void getHand()
	{
		if(hand.length!=0)
		{
			for(int i=0;i<hand.length;i++)
			{
				if(hand[i]!=null)
				{
					
				System.out.println(hand[i].toString());
				//System.out.println(hand[i]);

				}
			}
		}
	}
	public int getCardsHeld()
	{
		return cardsHeld;
	}
	public int getHandValue()
	{
		int value=0;
		if(hand.length!=0)
		{
			for(int i=0;i<hand.length;i++)
			{
				if(hand[i]!=null)
				{
				int v= hand[i].getValue();
				value+=v;
				}
			}
		}
		return value;
	}
}
