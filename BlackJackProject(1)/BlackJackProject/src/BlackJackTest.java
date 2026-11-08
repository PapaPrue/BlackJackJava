//This project was a collabrative effort between Prue Thomas, Aidan Johnson, and Hadyen Emmerich.

import java.util.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class BlackJackTest {
	public static void main(String[] args)
	{
		int wins=0;
		
		boolean play=true;
		Scanner sc=new Scanner(System.in);
		Player p= new Player();
		Dealer d= new Dealer();
		BlackJackClass b=new BlackJackClass();
		
		
		
		
		System.out.println("Hello, Welcome to Blackjack. The rules are: get as close to 21 as possible.\nGo over and it's a bust!");
		System.out.print("\nEnter your name: ");
		String name = sc.next();
		System.out.println("\nHello " + name + ". Your dealer is: Fred"); //Dealer names incomplete for the time being
		//Random rand = new Random();
		
		p.SetName(name);
		while(play==true)
		{
			
			System.out.println("Your cards are: ");
			p.hit();
			p.seeCards();
			System.out.println("The value is: " + p.h.getHandValue());
			//System.out.println("Dealer hits...");
			d.hit();
			int bet;
			System.out.print("\nCurrent Amount of Money: " + p.getMoney()+ "\nPlace Your Bet: ");
			boolean folded=false;
			try {
				bet = sc.nextInt();
				p.setBet(bet);
				p.getBet();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			b.PrizePot(p);
			System.out.print("\nHit(1), Stay(2), or Fold(3): ");
			
			
			
			
			while(p.h.getHandValue()<21) {
			try {
				int x = sc.nextInt();
				while(x==1)
				{
					p.hit();
					
					System.out.println("Your cards are: ");
					p.seeCards();
					System.out.println("The value is: " + p.h.getHandValue());
					if(p.h.getHandValue()>=21||d.dealerHand.getHandValue()>=21)
						break;
					d.hit();
					System.out.print("\nHit(1), Stay(2), or Fold(3): ");
					x = sc.nextInt();
				}
				if(x==2)
				{
					p.stay();
					d.hit();
					break;
				}
				if(x==3)
				{
					folded = p.fold();
					//p.fold();
					b.fold(p);
					folded=true;
					break;
				}
				else if(x>3||x<0)
				{
					System.err.print("You have been caught cheating. You have been kicked out of the casino");
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.err.print("You have attacked the bouncers. You have been kicked out of the casino.");
				System.exit(0);
			}
				
				
			}
			if(p.h.getHandValue()==21&&folded==false)
			{
				System.out.println("Blackjack! You win!");
				wins++;
				int y= b.getPrize();
				p.SetMoney(p.getMoney()+y);
				//break;
			}
			
			else if (p.h.getHandValue()>21&&folded==false)
			{
				System.out.println("Bust! Dealer wins!");
			}
			else if(d.dealerHand.getHandValue()>21&&folded==false)
			{
				System.out.println("Dealer Cards are: ");
				d.seeCards();
				System.out.println("Dealer Busts! You win!");
				
				d.lose();
				int y= b.getPrize();
				int x=p.getMoney();
				p.SetMoney(x+b.getPrize());
				wins++;
				//break;
			}
						
			else if(p.stay()&&d.stay()&&folded!=true)
			{
				System.out.println("Dealer Cards are: ");
				d.seeCards();
				System.out.println("\nValue of Your Hand: " + p.h.getHandValue() + "\nValue of Dealer's Hand: " + d.dealerHand.getHandValue());
				int winCheck = b.compareCards(p.h.getHandValue(), d.dealerHand.getHandValue());
				if(winCheck==1)
				{ 
					System.out.println("You win!");
					int y= b.getPrize();
					int x=p.getMoney();
					p.SetMoney(x+b.getPrize());
					wins++;
				}
				else if(winCheck==2)
				{
					System.out.println("Tie!"); 
					//return;
				}
				else if(winCheck==3) 
				{
					System.out.println("Dealer wins!");
					p.lose();
					
				}
			}
			
			System.out.println("Would you like to play again: ");
			char check = sc.next().charAt(0);
			if(check=='y'||check=='Y')
			{
				p.reset();
				d.reset();
			}
			else
			{
				play=false;
			}
		}
	System.out.println("Thanks for playing. Final score: ");
	System.out.println("Wins: " + wins + "\tEarnings: " + p.getMoney() );
	
		File f=new File("Scores.txt");
	
		
		try {
			Scanner fileScan=new Scanner(f);
			PrintWriter outputFile = new PrintWriter(new FileWriter(f,true));
			outputFile.append("Name: "+ p.getName() + "\t Wins: " + wins + "\t Earnings: " + p.getMoney()+"\n");
			outputFile.close();
			System.out.println("\nScores: ");
			while(fileScan.hasNext())
			{
				String str=fileScan.nextLine();
				System.out.println(str);
			}
			fileScan.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	
	}
}

