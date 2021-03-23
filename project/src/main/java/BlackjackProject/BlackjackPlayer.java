package BlackjackProject;

public class BlackjackPlayer {
	private int amountOfCards;
	private BlackjackCard[] hand = new BlackjackCard[15];
	private String name;
	
	
	public BlackjackPlayer(String name) {
		this.name = name;
		emptyHand();							//hver gang et spiller-objekt opprettes, tøm hånda.
	}
	
	private void emptyHand() {
		for (int i = 0; i < 15; i++) {			//for hver index av hånda opp til max størrelse på hånda
			hand[i] = null;						//sett den indexen av hånda til ingenting
		}
		amountOfCards = 0;
	}

	public boolean isHandEmpty() {
		if (hand.length == 0) {
			return true;
		}
		return false;
	}
	
	public boolean addCard(BlackjackCard card) {
		hand[amountOfCards] = card;
		amountOfCards++;
		
		return (sumHand() <= 21);
	}
	
	public int sumHand() {
		
		int handSum = 0;
		int numberOfAces = 0;
		int cardValue;
		
		for (int i = 0; i < amountOfCards; i++) {
			cardValue = hand[i].getFace();
			
			if(cardValue == 1) {
				numberOfAces++;
				handSum += 11;
			} else if(cardValue > 10) {
				handSum += 10;
			} else {
				handSum += cardValue;
			}
		}
		
		while(handSum > 21 && numberOfAces > 0) {
			handSum -= 10;
			numberOfAces--;	
		}
		
		return handSum;
	}
	
	public void hideDealerCard(boolean hideFirst) {
		
		for (int i = 0; i < amountOfCards; i++) {
			if (i == 0 && hideFirst == true) {	/// endres ift. brukergrensesnitt ?
				System.out.println("Hidden");  
			} else {
				System.out.println(hand[i].toString());
			}
		}
	}
	
	public String getName() {
		return name;
	}
}
	
// skrive session games til fil? Reset session når appen åpnes?
