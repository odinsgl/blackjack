package BlackjackProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackPlayerTest {
	
	private BlackjackPlayer player;
	private BlackjackPlayer player1;
	private BlackjackCard card1;
	private BlackjackCard card2;
	private BlackjackCard card3;
	private BlackjackCard card4;
	
	
	@BeforeEach
	void setUp() {
		player = new BlackjackPlayer();
		card1 = new BlackjackCard('S', 1);
		card2 = new BlackjackCard('H', 13);
		card3 = new BlackjackCard('D', 10);
		card4 = new BlackjackCard('C', 7);
	}
	
	@Test
	@DisplayName("Tester metoden som legger til kort i hånda")
	void testAddCard() {
		player.addCard(card4);
		player.addCard(card3);
		
		Assertions.assertEquals(2, player.getSize());
	}
	
	@Test
	@DisplayName("Sjekker om hånda har riktig antall ess")
	void testAceAmount() {
		player.addCard(card1);
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card1);
		
		Assertions.assertEquals(3, player.aceAmount());
	}
	
	@Test
	@DisplayName("Sjekker høyeste mulige sum uten at man buster")
	void testSumHand() {
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card1);
		player.addCard(card4);
		
		Assertions.assertEquals(19, player.sumHand());
	}
	
	@Test
	@DisplayName("Sjekker sum når ess er 1")
	void testSumHandAceAsOne() {
		player.addCard(card1);
		player.addCard(card4);
		
		Assertions.assertEquals(8, player.sumHandAceAsOne());
	}
	
	@Test
	@DisplayName("Sjekker sum uten å telle med dealerens første kort")
	void sumHandWOFirst() {
		player.addCard(card2);
		player.addCard(card4);
		Assertions.assertEquals(7, player.sumHandWOFirst());
		
		player1 = new BlackjackPlayer();
		player1.addCard(card4);
		player1.addCard(card1);
		Assertions.assertEquals(11, player1.sumHandWOFirst());
	}
	
	@Test
	@DisplayName("Sjekker at riktig kort returneres fra hånda")
	void testGetCard() {
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		player.addCard(card4);
		
		Assertions.assertEquals(card1, player.getCard(0));
		Assertions.assertEquals(card2, player.getCard(1));
		Assertions.assertEquals(card3, player.getCard(2));
		Assertions.assertEquals(card4, player.getCard(3));
	}
	
	@Test
	@DisplayName("Sjekker om man faktisk har blackjack")
	void testHasBlackjack() {
		player.addCard(card2);
		player.addCard(card3);
		player.addCard(card1);
		
		Assertions.assertFalse(player.hasBlackjack());	//ikke blackjack hvis man får 21 med mer enn 2 kort.
		
		player1 = new BlackjackPlayer();
		player1.addCard(card1);
		player1.addCard(card2);
		
		Assertions.assertTrue(player1.hasBlackjack());
	}

}
