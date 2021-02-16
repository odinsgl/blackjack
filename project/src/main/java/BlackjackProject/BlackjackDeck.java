package BlackjackProject;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackDeck {
	private ArrayList<BlackjackCard> threeDeck = new ArrayList<BlackjackCard>();
	private char[] suits = {'S','H','D','C'};
	private Random rd = new Random();
	
	public BlackjackDeck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 1; j <= 13; j++) {
				threeDeck.add(new BlackjackCard(suits[i], j)); 
				threeDeck.add(new BlackjackCard(suits[i], j));
				threeDeck.add(new BlackjackCard(suits[i], j));
			}
		}
	}
	
	public int getCardCount() {
		return threeDeck.size();
	}
	
	public BlackjackCard dealCard() {
		BlackjackCard drawnCard = threeDeck.get(rd.nextInt(threeDeck.size()));
		threeDeck.remove(drawnCard);
		if(threeDeck.size() < 104) {
			for (int i = 0; i < suits.length; i++) {
				for (int j = 1; j <= 13; j++) {
					threeDeck.add(new BlackjackCard(suits[i], j));
				}
			}
		}
		System.out.println(drawnCard);
		return drawnCard;
	}
	
	public static void main(String[] args) {
		BlackjackDeck cardDeck = new BlackjackDeck();
		System.out.println(cardDeck.threeDeck.size());
		System.out.println(cardDeck.dealCard());
		System.out.println(cardDeck.threeDeck.size());
	}
}
