package BlackjackProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackDeckTest {

	private BlackjackDeck deck;

	@BeforeEach
	public void setUp() {
		deck = new BlackjackDeck();
	}
	
	@Test
	@DisplayName("Sjekker at kortstokken har riktig antall kort")
	void testConstructor() {
		assertEquals(156, deck.getCardCount());

	}
	
	@Test
	@DisplayName("Sjekker at dealCard fjerner et kort fra kortstokken")
	void testDealCard() {
		deck.dealCard();
		deck.dealCard();
		
		assertEquals(154, deck.getCardCount());
	}

}
