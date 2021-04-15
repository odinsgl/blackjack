package BlackjackProject;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class AppController {

	@FXML
	private Button stand;
	
	@FXML
	private Button hit;
	
	@FXML
	private Button deal;
	
	@FXML
	private Label playerHandValue;
	
	@FXML
	private Label dealerHandValue;
	
	@FXML
	private List<ImageView> dlImgViewList = new ArrayList<ImageView>();
	
	@FXML
	private List<ImageView> plImgViewList = new ArrayList<ImageView>();
	
	@FXML
	private ImageView dealerImgView1, dealerImgView2, dealerImgView3, dealerImgView4,
	dealerImgView5, dealerImgView6, dealerImgView7, dealerImgView8;
	
	@FXML
	private ImageView playerImgView1, playerImgView2, playerImgView3,playerImgView4,
	playerImgView5, playerImgView6, playerImgView7, playerImgView8;
	
	@FXML
	private HBox dealerHBox;
	
	@FXML
	private HBox playerHBox;
	
	private BlackjackPlayer player1;
	
	private BlackjackPlayer dealer;
	
	private BlackjackDeck BJdeck;
	
	private int plImgViewListIndex;
	
	private int dlImgViewListIndex;
	
	public void initialize() {
		
		dlImgViewList.addAll(Arrays.asList(dealerImgView1, dealerImgView2, dealerImgView3, dealerImgView4,
				dealerImgView5, dealerImgView6, dealerImgView7, dealerImgView8));
		
		plImgViewList.addAll(Arrays.asList(playerImgView1, playerImgView2, playerImgView3, playerImgView4,
				playerImgView5, playerImgView6, playerImgView7, playerImgView8));
		
		hit.setDisable(true);
		stand.setDisable(true);
		
	}
	
	@FXML
	public void onDeal() {
		plImgViewListIndex = 2;
		dlImgViewListIndex = 2;

		for (int i = 0; i < dlImgViewList.size(); i++) {
			dlImgViewList.get(i).setImage(null);
		}
		
		for (int i = 0; i < plImgViewList.size(); i++) {
			plImgViewList.get(i).setImage(null);
		}
		
		deal.setDisable(true);
		hit.setDisable(false);
		stand.setDisable(false);
		
		BJdeck = new BlackjackDeck();
		
		player1 = new BlackjackPlayer("Dealer");
		dealer = new BlackjackPlayer("Player");
		
		player1.addCard(BJdeck.dealCard());
		dealer.addCard(BJdeck.dealCard());
		
		player1.addCard(BJdeck.dealCard());
		dealer.addCard(BJdeck.dealCard());
		
		anyAces();
		
		dealerHandValue.setText(String.valueOf(dealer.sumHandWOFirst()));
		
		if(dealer.sumHand() == 21 || player1.sumHand() == 21) {
			spoilCard();
			} else {
			Image dlImg1 = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\purple_back.png").toURI().toString());
			dealerImgView1.setImage(dlImg1);
			
			
		}
		Image dlImg2 = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + dealer.getCard(1).toString() + ".png").toURI().toString());
		dealerImgView2.setImage(dlImg2);
		
		
		Image plImg1 = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + player1.getCard(0).toString() + ".png").toURI().toString());
		playerImgView1.setImage(plImg1);
		
		
		Image plImg2 = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + player1.getCard(1).toString() + ".png").toURI().toString());
		playerImgView2.setImage(plImg2);
		
	}
	
	public void anyAces() {
		
		if(player1.aceAmount() > 0 && player1.sumHand() < 21 && (player1.sumHandAceAsOne() != player1.sumHand())) {
			playerHandValue.setText(String.valueOf(player1.sumHand()) + " / " + player1.sumHandAceAsOne());
		} else {
			playerHandValue.setText(String.valueOf(player1.sumHand()));
		}
	}
	
	public void dealerFinish() {
		dealer.addCard(BJdeck.dealCard());
		Image dlImg = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + dealer.getCard(dealer.getSize() - 1).toString() + ".png").toURI().toString());
		dlImgViewList.get(dlImgViewListIndex).setImage(dlImg);
		dlImgViewListIndex++;
	}
	
	public void spoilCard() {
		dealerHandValue.setText(String.valueOf(dealer.sumHand()));
		deal.setDisable(false);
		hit.setDisable(true);
		stand.setDisable(true);
		Image dlImg1 = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + dealer.getCard(0).toString() + ".png").toURI().toString());
		dealerImgView1.setImage(dlImg1);
	}
	
	@FXML
	public void onHit() {
		
		player1.addCard(BJdeck.dealCard());
		
		if(player1.sumHand() > 21) {
			spoilCard();
		}	
		
		if(player1.sumHand() == 21) {
			while(dealer.sumHand() < 17) {
				dealerFinish();
			}
			spoilCard();
		}
		
		Image plHitImg = new Image(new File("C:\\Users\\oglad\\Documents\\BlackjackCards\\" + player1.getCard(player1.getSize() - 1).toString() + ".png").toURI().toString());
		plImgViewList.get(plImgViewListIndex).setImage(plHitImg);
		plImgViewListIndex++;
		
		anyAces();
	}
	
	@FXML
	public void onStand() {
		spoilCard();
		
		while(dealer.sumHand() < 17) {
			dealerFinish();
		}
		
		dealerHandValue.setText(String.valueOf(dealer.sumHand()));
		playerHandValue.setText(String.valueOf(player1.sumHand()));
		
	}
}
