package BlackjackProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlackjackResultsTest {
	
	BlackjackResults blackjackResults;
	
	int sessionLoss;
	int sessionPushes;
	int sessionWins;
	
	@BeforeEach
	private void setUp() {
		blackjackResults = new BlackjackResults();
	}
	
	public void writeSessionResultsFile() {
		
		try {
			PrintWriter writer = new PrintWriter(AppController.getTextPath() + "session_result.txt");
			
			writer.println("26.april - 13:45:23");
			writer.println();
			writer.println("Win: 19 vs 17");
			writer.println("Win: 19 vs 17");
			writer.println("Push: 21 vs 21");
			writer.println("Push: 17 vs 17");
			writer.println("Win: 21 vs 17");
			writer.println("Win: 15 vs 24");
			writer.println("Loss: 22 vs 20");
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testGetSessionResultsFromFile() {
		writeSessionResultsFile();
		blackjackResults.getSessionResultsFromFile(AppController.getTextPath() + "session_result.txt");
		
		Assertions.assertEquals("4", blackjackResults.getSessionWins());
		Assertions.assertEquals("2", blackjackResults.getSessionPushes());
		Assertions.assertEquals("1", blackjackResults.getSessionLoss());
		
		Assertions.assertNotEquals("0", blackjackResults.getSessionWins());
		Assertions.assertNotEquals("3", blackjackResults.getSessionPushes());
		Assertions.assertNotEquals("2", blackjackResults.getSessionLoss());
	}
}
