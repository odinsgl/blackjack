package BlackjackProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackjackDeck {
	private List<BlackjackCard> BJdeck = new ArrayList<BlackjackCard>(); //lager List som er av typen ArrayList som inneholder objekter av typen BlackjackCard.
	private char[] suits = {'S','H','D','C'};
	private Random rd = new Random();
	
	public BlackjackDeck() {
		for (int i = 0; i < suits.length; i++) { 
			for (int j = 1; j <= 13; j++) {
				BJdeck.add(new BlackjackCard(suits[i], j)); // for hver suit, lag 13 kort med den suit'en og legg til i "threeDeck".
			}
		}
	}
	
	public List<BlackjackCard> getThreeDeck() {
		return BJdeck;
	}
	
	public int getCardCount() {
		return BJdeck.size();
	}
	
	public BlackjackCard dealCard() {
		BlackjackCard drawnCard = BJdeck.get(rd.nextInt(BJdeck.size()));	//add a random card from threeDeck to a varible
		BJdeck.remove(drawnCard);											//remove it from 
		return drawnCard;
	}
}
