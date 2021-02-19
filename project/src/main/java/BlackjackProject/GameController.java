package BlackjackProject;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameController {
	private BlackjackGame game;
	
	@FXML
	Pane board;
	
	@FXML
	private void initialize() {
		game = new BlackjackGame();
	}
}
