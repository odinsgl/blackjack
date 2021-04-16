package BlackjackProject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartUpController {
	
	@FXML
	private TextField username;

	@FXML
	private Button play;
	
	public void initialize() {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				username.requestFocus();
			}
		});
	}

	
	@FXML
	public void onSubmit(ActionEvent event) throws Exception {               
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setTitle("BlackJack App");
	        stage.setScene(new Scene(root1));  
	        stage.show();
	        play.getScene().getWindow().hide();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
