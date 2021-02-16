package BlackjackProject;

public class BlackjackPlayer {
	private int handSum, cardsInHand;
	private BlackjackCard[] hand = new BlackjackCard[8];
	
	
	public BlackjackPlayer() {
		emptyHand();
	}
	
	private void emptyHand() {
		for (int i = 0; i < 8; i++) {
			hand[i] = null;
		}
		cardsInHand = 0;
	}

	public boolean isHandEmpty() {
		if (hand.length == 0) {
			return true;
		}
		return false;
	}
	
//	public int checkCardValue(BlackjackCard card) {
//		
//	}
	
	public int sumHand() {
		BlackjackDeck dealt = new BlackjackDeck();
		BlackjackCard drawn = dealt.dealCard();
		String string = drawn.toString();
		String str = string.replaceAll("[A-Z]", "");
		int aces = 0;										//amount of aces
		
		int value = Integer.parseInt(str.trim());
		
		if(value == 1) {
			aces++;
			handSum += 11;
		} else if(value > 10) {
			handSum += 10;
		} else {
			handSum += value;
		}
		
		while(handSum > 21 && aces > 0) {
			handSum -= 10;
			aces--;	
		}
		
		return handSum;
	}
	
	
	public static void main(String[] args) {
		BlackjackPlayer player1 = new BlackjackPlayer();
		System.out.println(player1.sumHand());
	}
}
	
	

