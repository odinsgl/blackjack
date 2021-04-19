package BlackjackProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BlackjackResults implements ResultsInterface {
	
	private File resultHistory;
	
	public void writeResultsFile(String text) {
		
		resultHistory = new File("result_history.txt");
		
		try {
			PrintWriter writer = new PrintWriter(resultHistory);
			writer.write(text);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
