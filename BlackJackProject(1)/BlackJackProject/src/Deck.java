import java.util.*;
public class Deck {
	
	//private Card cards[];
	private ArrayList<Card>cardDeck=new ArrayList<Card>(); 
	//private int max= 52;
	private int deckIndex;
	
	public enum Suits
	{
		HEARTS, SPADES, CLUBS, DIAMONDS;
	}
	
	private String values[]= {"Ace","2","3","4","5","6","7","8","9","10", "Jack", "Queen", "King"};
	
	
	
	public Deck()
	{
		fill();
		shuffle();
		
	}
	public void fill()
	{
		for(Suits s: Suits.values())
			for(int i=0; i<values.length;i++)
			{
			cardDeck.add(new Card(s.name(),values[i]));
			}	
	}
	
	public void shuffle()
	{
		
		Collections.shuffle(cardDeck);
	}
	
	public Card draw()
	{
		Card drawnCard=cardDeck.get(deckIndex);
		deckIndex++;
		return drawnCard;
	}
	
	public void reset()
	{
		deckIndex=0;
		//max=52;
		cardDeck.clear();
		fill();
		shuffle();
	}
	
}