package BlackjackProject;

public class BlackjackCard {
	private char suit;
	private int face;
	
	public BlackjackCard(char suit, int face) { // lager objektet BlackjackCard
		this.suit = suit;
		this.face = face;
	}
	
	public char getSuit() {
		return suit;
	}
	
	public int getFace() {
		return face;
	}
	
	@Override
	public String toString() {
		return "" + face + suit;
	}
}