package BlackjackProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class BlackjackResults implements ResultsInterface {
	
	public void writeResultsToFile(String filename) {
		try {
			PrintWriter writer = new PrintWriter(filename);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
