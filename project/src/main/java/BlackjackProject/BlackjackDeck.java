package BlackjackProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackjackDeck {
	private List<BlackjackCard> BJdeck = new ArrayList<BlackjackCard>();
	private final char[] SUITS = {'S','H','D','C'};
	private Random rd = new Random();
	
	public BlackjackDeck() {
		for (int i = 0; i < SUITS.length; i++) { 
			for (int j = 1; j <= 13; j++) {
				BJdeck.add(new BlackjackCard(SUITS[i], j)); // for hver suit, lag 13 kort med den suit'en og legg til i deck.
				BJdeck.add(new BlackjackCard(SUITS[i], j));
				BJdeck.add(new BlackjackCard(SUITS[i], j));
			}
		}
	}
	
	public List<BlackjackCard> getBJdeck() {
		return BJdeck;
	}
	
	public int getCardCount() {
		return BJdeck.size();
	}
	
	public BlackjackCard dealCard() {
		BlackjackCard drawnCard = BJdeck.get(rd.nextInt(BJdeck.size()));
		return drawnCard;
	}
}
