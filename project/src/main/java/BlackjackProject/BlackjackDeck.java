package BlackjackProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlackjackDeck {
	private ArrayList<BlackjackCard> threeDeck = new ArrayList<BlackjackCard>();
	private char[] suits = {'S','H','D','C'};
	private Random rd = new Random();
	
	public BlackjackDeck() {
		for (int i = 0; i < 166; i++) {
			threeDeck.add(new BlackjackCard(suits[rd.nextInt(suits.length)], ThreadLocalRandom.current().nextInt(1, 14)));
		}
	}
	
	public int getCardCount(){
		return threeDeck.size();
	}
	
	public BlackjackCard getCard(int n){
		return threeDeck.get(n);
	}
	
	public BlackjackCard drawRandom() {
		return threeDeck.get(rd.nextInt(threeDeck.size()));
	}
	public static void main(String[] args) {
		BlackjackDeck cardDeck = new BlackjackDeck();
		System.out.println(cardDeck.drawRandom());
	}
	
//	public static void main(String[] args) {				not rly needed?
//		BlackjackDeck cardDeck = new BlackjackDeck();
//		System.out.println("Card amount equal to three decks: " + cardDeck.threeDeck);
//	}
}
