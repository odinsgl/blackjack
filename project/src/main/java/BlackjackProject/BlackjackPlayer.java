package BlackjackProject;

public class BlackjackPlayer {
	private int amountOfCards;
	private BlackjackCard[] hand = new BlackjackCard[9];
	
	public void addCard(BlackjackCard card) {
		this.hand[amountOfCards] = card;
		this.amountOfCards++;
	}
	
	public int aceAmount() {
		int amountOfAces = 0;
		for (int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
				if(hand[i].getFace() == 1) {
					amountOfAces++;
				}
			}
		}
		return amountOfAces;
	}
	
	public String ifHasAce() {
		if(this.aceAmount() > 0 && this.sumHand() < 21 && this.sumHandAceAsOne() != this.sumHand()) {
			return(String.valueOf(this.sumHand()) + " / " + this.sumHandAceAsOne());
		} else {
			return(String.valueOf(this.sumHand()));
		}
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
	
public int sumHandAceAsOne() {
		
		int handSum = 0;
		int cardValue;
		
		for (int i = 0; i < amountOfCards; i++) {
			cardValue = hand[i].getFace();
			
			if(cardValue == 1) {
				handSum += 1;
			} else if(cardValue > 10) {
				handSum += 10;
			} else {
				handSum += cardValue;
			}
		}
		
		return handSum;
	}
	
public int sumHandWOFirst() {
		
		int handSum = 0;
		int numberOfAces = 0;
		int cardValue;
		
		for (int i = 1; i < amountOfCards; i++) { //i = 1 starter å telle dealeren sitt andre kort.
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

	public boolean hasBlackjack() {
		if (sumHand() == 21 && getSize() == 2) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return amountOfCards;
	}
	
	public BlackjackCard[] getHand() {
		return hand;
	}
	public BlackjackCard getCard(int index) {
        return hand[index];
    }
	
	public void emptyHand() {
		this.amountOfCards = 0;
	}
}
