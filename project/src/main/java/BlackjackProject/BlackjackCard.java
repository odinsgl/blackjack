package BlackjackProject;

public class BlackjackCard {
	private char suit;
	private int face;
	
	public BlackjackCard(char suit, int face) {
		if ((suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C') && (face <= 13 && face >= 1))  {
			this.suit = suit;
			this.face = face;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public char getSuit() {
		return suit;
	}
	
	public int getFace() {
		return face;
	}
	
	
	public String toString() {
		return "" + suit + face;
	}
}