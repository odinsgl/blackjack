package BlackjackProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("username.fxml"))));
		primaryStage.setTitle("BlackJack App Welcome");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public static void main(String[] args) {
		App.launch(args);
	}
}
