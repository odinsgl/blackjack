package BlackjackProject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class AppController {
	
	@FXML
	private MenuItem closeWindow;
	
	@FXML
	private MenuItem allTimeResults;
	
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
	private Label resultLabel;
	
	@FXML
	private Label playerName;
	
	@FXML
	private Label sessionWinsLabel;
	
	@FXML
	private Label sessionPushesLabel;
	
	@FXML
	private Label sessionLossLabel;
	
	@FXML
	private List<ImageView> dlImgViewList = new ArrayList<ImageView>();
	
	@FXML
	private List<ImageView> plImgViewList = new ArrayList<ImageView>();
	
	@FXML
	private ImageView dealerImgView1, dealerImgView2, dealerImgView3, dealerImgView4,
	dealerImgView5, dealerImgView6, dealerImgView7, dealerImgView8, dealerImgView9;
	
	@FXML
	private ImageView playerImgView1, playerImgView2, playerImgView3,playerImgView4,
	playerImgView5, playerImgView6, playerImgView7, playerImgView8, playerImgView9;
	
	private BlackjackPlayer player1;
	
	private BlackjackPlayer dealer;
	
	private BlackjackDeck BJdeck;
	
	private BlackjackResults resultHistory;
	
	private BlackjackResults sessionResults;
	
	private int plImgViewListIndex;
	
	private int dlImgViewListIndex;
	
	private final static String IMAGE_PATH = "file:src/main/resources/";
	
	private final static String TEXT_PATH = "src/main/resources/";
	
	
	public void initialize() {
		
		player1 = new BlackjackPlayer();
		dealer = new BlackjackPlayer();
		
		resultHistory = new BlackjackResults();
		sessionResults = new BlackjackResults();
		resultHistory.getResultsFromFile(TEXT_PATH + "result_history.txt");
		resultHistory.addDate();
		sessionResults.addDate();
		
		dlImgViewList.addAll(Arrays.asList(dealerImgView1, dealerImgView2, dealerImgView3, dealerImgView4,
				dealerImgView5, dealerImgView6, dealerImgView7, dealerImgView8, dealerImgView9));
		
		plImgViewList.addAll(Arrays.asList(playerImgView1, playerImgView2, playerImgView3, playerImgView4,
				playerImgView5, playerImgView6, playerImgView7, playerImgView8, playerImgView9));
		
		hit.setDisable(true);
		stand.setDisable(true);
	}

	
	public void setPlayerName(String name) {
		playerName.setText(name);
	}
	
	public static String getImagePath() {
		return IMAGE_PATH;
	}
	
	public static String getTextPath() {
		return TEXT_PATH;
	}
	
	@FXML
	public void onDeal() {
		BJdeck = new BlackjackDeck();
		
		player1.emptyHand();
		dealer.emptyHand();
		
		resultLabel.setText(null);
		
		plImgViewListIndex = 2;
		dlImgViewListIndex = 2;

		for (int i = 0; i < dlImgViewList.size(); i++) {	// tømmer imageview'ene
			dlImgViewList.get(i).setImage(null);
		}
		
		for (int i = 0; i < plImgViewList.size(); i++) {
			plImgViewList.get(i).setImage(null);
		}
		
		deal.setDisable(true);
		hit.setDisable(false);
		stand.setDisable(false);
		
		
		
		player1.addCard(BJdeck.dealCard());
		dealer.addCard(BJdeck.dealCard());
		
		player1.addCard(BJdeck.dealCard());
		dealer.addCard(BJdeck.dealCard());
		
		playerHandValue.setText(player1.ifHasAce());//
		
		dealerHandValue.setText(String.valueOf(dealer.sumHandWOFirst()));
		
		if(dealer.hasBlackjack() || player1.hasBlackjack()) {
			spoilCard();
			setResultLabel();
			} else {
			Image dlImg1 = new Image(IMAGE_PATH + "purple_back.png");
			dealerImgView1.setImage(dlImg1);
			
			
		}
		Image dlImg2 = new Image(IMAGE_PATH + dealer.getCard(1).toString() + ".png");
		dealerImgView2.setImage(dlImg2);
		
		
		Image plImg1 = new Image(IMAGE_PATH + player1.getCard(0).toString() + ".png");
		playerImgView1.setImage(plImg1);
		
		
		Image plImg2 = new Image(IMAGE_PATH + player1.getCard(1).toString() + ".png");
		playerImgView2.setImage(plImg2);
		
	}
	
	public void dealerFinish() { 	//dealer fullfører sin tur.
		dealer.addCard(BJdeck.dealCard());
		Image dlImg = new Image(IMAGE_PATH + dealer.getCard(dealer.getSize() - 1).toString() + ".png");
		dlImgViewList.get(dlImgViewListIndex).setImage(dlImg);
		dlImgViewListIndex++;
	}
	
	public void spoilCard() {
		dealerHandValue.setText(String.valueOf(dealer.sumHand()));
		deal.setDisable(false);
		hit.setDisable(true);
		stand.setDisable(true);
		Image dlImg1 = new Image(IMAGE_PATH + dealer.getCard(0).toString() + ".png");
		dealerImgView1.setImage(dlImg1);
	}
	
	public void setResultLabel() {
		String s = player1.sumHand() + " vs " + dealer.sumHand();
		if(dealer.hasBlackjack() && !player1.hasBlackjack()) {
			resultLabel.setText("Dealer has blackjack! You lose.");
			resultHistory.writeResultsFile("Loss: " + s);
			sessionResults.writeSessionResultsFile("Loss: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionLossLabel.setText(sessionResults.getSessionLoss());
			
		} else if(player1.hasBlackjack() && !dealer.hasBlackjack()) {
			resultLabel.setText("You got blackjack! Congratulations!");
			resultHistory.writeResultsFile("Win: " + s);
			sessionResults.writeSessionResultsFile("Win: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionWinsLabel.setText(sessionResults.getSessionWins());
			
		} else if(player1.hasBlackjack() && dealer.hasBlackjack()) {
			resultLabel.setText("You both got blackjack! It's a PUSH!");
			resultHistory.writeResultsFile("Push: " + s);
			sessionResults.writeSessionResultsFile("Push: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionPushesLabel.setText(sessionResults.getSessionPushes());
			
		} else if(player1.sumHand() > 21) {
			resultLabel.setText("You busted :(");
			resultHistory.writeResultsFile("Loss: " + s);
			sessionResults.writeSessionResultsFile("Loss: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionLossLabel.setText(sessionResults.getSessionLoss());
			
		} else if(player1.sumHand() <= 21 && (dealer.sumHand() < player1.sumHand() || dealer.sumHand() > 21)) {
			resultLabel.setText("You win with " + player1.sumHand() + " against " + dealer.sumHand() + "!");
			resultHistory.writeResultsFile("Win: " + s);
			sessionResults.writeSessionResultsFile("Win: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionWinsLabel.setText(sessionResults.getSessionWins());
			
		} else if(player1.sumHand() <= 21 && (dealer.sumHand() > player1.sumHand() && dealer.sumHand() <= 21)) {
			resultLabel.setText("You lost with " + player1.sumHand() + " against " + dealer.sumHand() + "!");
			resultHistory.writeResultsFile("Loss: " + s);
			sessionResults.writeSessionResultsFile("Loss: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionLossLabel.setText(sessionResults.getSessionLoss());
			
		} else if(player1.sumHand() <= 21 && dealer.sumHand() == player1.sumHand()) {
			resultLabel.setText("You both have " + player1.sumHand() + " it's a push!");
			resultHistory.writeResultsFile("Push: " + s);
			sessionResults.writeSessionResultsFile("Push: " + s);
			sessionResults.getSessionResultsFromFile(TEXT_PATH + "session_result.txt");
			sessionPushesLabel.setText(sessionResults.getSessionPushes());
			
		}
	}
	
	@FXML
	public void onHit() {
		
		player1.addCard(BJdeck.dealCard());
		
		if(player1.sumHand() > 21) {
			spoilCard();
			setResultLabel();
		}	
		
		if(player1.sumHand() == 21) {
			while(dealer.sumHand() < 17) {
				dealerFinish();
			}
			spoilCard();
			setResultLabel();
			
		}
		
		Image plHitImg = new Image(IMAGE_PATH + player1.getCard(player1.getSize() - 1).toString() + ".png");
		plImgViewList.get(plImgViewListIndex).setImage(plHitImg);
		plImgViewListIndex++;
		
		playerHandValue.setText(player1.ifHasAce());//
	}
	
	@FXML
	public void onStand() {
		spoilCard();
		
		while(dealer.sumHand() < 17) {
			dealerFinish();
		}
		
		setResultLabel();
		
		dealerHandValue.setText(String.valueOf(dealer.sumHand()));
		playerHandValue.setText(String.valueOf(player1.sumHand()));
		
	}
	
	@FXML
	private void closeWindowAction(){
	    Platform.exit();
	}
	
	@FXML
	private void openResultHistoryFile() throws IOException {
		File resultFile = new File(TEXT_PATH + "result_history.txt");
		Desktop.getDesktop().open(resultFile);
	}
}
