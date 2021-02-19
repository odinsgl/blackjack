package BlackjackProject;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackDeck {
	private ArrayList<BlackjackCard> threeDeck = new ArrayList<BlackjackCard>(); //lager ArrayList som inneholder objekter av typen BlackjackCard.
	private char[] suits = {'S','H','D','C'};
	private Random rd = new Random();
	
	public BlackjackDeck() {
		for (int i = 0; i < suits.length; i++) { 
			for (int j = 1; j <= 13; j++) {
				threeDeck.add(new BlackjackCard(suits[i], j)); // for hver suit, lag 13 kort med den suit'en og legg til i "threeDeck".
			}
		}
	}
	
	public ArrayList<BlackjackCard> getThreeDeck() {
		return threeDeck;
	}
	
	public int getCardCount() {
		return threeDeck.size();
	}
	
	public BlackjackCard dealCard() {
		BlackjackCard drawnCard = threeDeck.get(rd.nextInt(threeDeck.size()));
		threeDeck.remove(drawnCard);

		return drawnCard;
	}
}
