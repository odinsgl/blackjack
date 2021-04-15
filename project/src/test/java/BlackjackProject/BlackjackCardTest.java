package BlackjackProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackCardTest {
	
	private BlackjackCard card1;
	private BlackjackCard card2;
	private BlackjackCard card3;
	private BlackjackCard card4;
	
	@BeforeEach
	public void setUp() {
		card1 = new BlackjackCard('S', 3);
		card2 = new BlackjackCard('H', 11);
		card3 = new BlackjackCard('D', 1);
		card4 = new BlackjackCard('C', 13);
	}
	
	@Test
	@DisplayName("Sjekk at riktig sort returneres")
	void testSuit() {
		assertEquals('S', card1.getSuit());
		assertEquals('H', card2.getSuit());
		assertEquals('D', card3.getSuit());
		assertEquals('C', card4.getSuit());
	}
	
	@Test
	@DisplayName("Sjekk at riktig tall returneres")
	void testFace() {
		assertEquals(3, card1.getFace());
		assertEquals(11, card2.getFace());
		assertEquals(1, card3.getFace());
		assertEquals(13, card4.getFace());
	}

}
