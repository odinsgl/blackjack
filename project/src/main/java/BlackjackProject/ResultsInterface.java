package BlackjackProject;

import java.io.FileNotFoundException;

public interface ResultsInterface {
	
	public void writeResultsFile(String text);
	
	public void getResultsFromFile(String filename) throws FileNotFoundException;
	
	public void writeSessionResultsFile(String text);
	
	public void getSessionResultsFromFile(String filename) throws FileNotFoundException;
	
}
