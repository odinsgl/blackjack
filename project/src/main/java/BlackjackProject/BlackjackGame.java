package BlackjackProject;

import java.util.Scanner;

public class BlackjackGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//"scanner" etter input fra bruker.
		BlackjackDeck leDeck = new BlackjackDeck();
		
		BlackjackPlayer player1 = new BlackjackPlayer("Player");
		BlackjackPlayer dealer = new BlackjackPlayer("Dealer");
		
		player1.addCard(leDeck.dealCard());
		dealer.addCard(leDeck.dealCard());
		player1.addCard(leDeck.dealCard());
		dealer.addCard(leDeck.dealCard());
		
		System.out.println("Player's hand:");
		player1.hideDealerCard(false);
		System.out.println("Player's sum: " + player1.sumHand());
		System.out.println(" ");
		
		if(player1.sumHand() == 21) {
			System.out.println("Dealer's hand:");
			dealer.hideDealerCard(false);
			System.out.println(" ");
		} else {
			System.out.println("Dealer's hand:");
			dealer.hideDealerCard(true);
			System.out.println(" ");
		}

		boolean player1DoneHitting = false;
		boolean dealerDoneHitting = false;
		
		if(player1.sumHand() == 21 || dealer.sumHand() == 21) {
			player1DoneHitting = true;
			dealerDoneHitting = true;
		}
		
		String choice;
		
		while (!player1DoneHitting || !dealerDoneHitting) {
			if (!player1DoneHitting) {
				System.out.println("Hit or Stay? (Enter H or S): ");
				choice = sc.next();
				
				if (choice.compareToIgnoreCase("H") == 0) {
					BlackjackCard latestDraw = leDeck.dealCard();
					player1DoneHitting = !player1.addCard(latestDraw);
					System.out.println("Player hits and draws " + latestDraw);
					System.out.println("Player's hand:");
					player1.hideDealerCard(false);
					System.out.println("New sum is: " + player1.sumHand());
					if(player1.sumHand() == 21) {
						player1DoneHitting = true;
					} else if(player1.sumHand() > 21) {
						break;
					}
					System.out.println(" ");
				} else {
					System.out.println("Player stays at: " + player1.sumHand());
					System.out.println(" ");
					player1DoneHitting = true;
				}
			}
			
			if (!dealerDoneHitting && (player1.sumHand() < 22 && player1DoneHitting)) {
				if (dealer.sumHand() < 17) {
					BlackjackCard latestDealerDraw = leDeck.dealCard();
					dealerDoneHitting = !dealer.addCard(latestDealerDraw);
					System.out.println("Dealer hits and draws " + latestDealerDraw + ", new sum is: " + dealer.sumHand());
					dealer.hideDealerCard(false);
					System.out.println(" ");
				} else {
					dealerDoneHitting = true;
				}
			}
		}
			
			
		//close scanner
		sc.close();
		
		//print final hands
		System.out.println("Player's final hand:");
		player1.hideDealerCard(false);
		System.out.println("Final sum: " + player1.sumHand() + "\n");
		System.out.println("Dealer's final hand:");
		dealer.hideDealerCard(false);
		System.out.println("Final sum: " + dealer.sumHand() + "\n");
		
		int player1Sum = player1.sumHand();
		int dealerSum = dealer.sumHand();
		
		if ((player1Sum > dealerSum && player1Sum <= 21) || dealerSum > 21) {
			System.out.println("Player wins with " + player1Sum + " against " + dealerSum + "!");
		} else if (player1Sum == dealerSum) {
			System.out.println("Push!");
		} else {
			System.out.println("Dealer wins with " + dealerSum + " against " + player1Sum + "!");
		}	
	}
}
