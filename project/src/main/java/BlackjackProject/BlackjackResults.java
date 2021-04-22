package BlackjackProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BlackjackResults implements ResultsInterface {
	
	private List<String> resultStrings = new ArrayList<String>();
	private List<String> sessionResultStrings = new ArrayList<String>();
	private String stringDate;
	
	private int sessionWins, sessionLoss, sessionPushes;
	
	public void addDate() {
		DateFormat sdf = new SimpleDateFormat("dd.MMMM - kk:mm:ss");
		Date date = new Date();
		stringDate = sdf.format(date);
		
		resultStrings.add(stringDate + "\n");
		sessionResultStrings.add(stringDate + "\n");
	}

	public void writeResultsFile(String text) {
		
		resultStrings.add(text);
		
		try {
			PrintWriter writer = new PrintWriter("result_history.txt");
			for(String e : resultStrings) {
				writer.println(e);
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getResultsFromFile(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			resultStrings.add(line);
		}
		resultStrings.add("\n");
	}
	
	public void writeSessionResultsFile(String text) {
		
		sessionResultStrings.add(text);
		
		try {
			PrintWriter writer = new PrintWriter("session_result.txt");
			for(String e : sessionResultStrings) {
				writer.println(e);
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getSessionResultsFromFile(String filename) throws FileNotFoundException {
		sessionLoss = 0;
		sessionPushes = 0;
		sessionWins = 0;
		
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(line.contains("Win")) {
				sessionWins++;
			} else if(line.contains("Push")) {
				sessionPushes++;
			} else if(line.contains("Loss")) {
				sessionLoss++;
				
			}
		}
	}
	
	public String getSessionLoss() {
		return "" + sessionLoss;
	}
	
	public String getSessionPushes() {
		return "" + sessionPushes;
	}
	
	public String getSessionWins() {
		return "" + sessionWins;
	}
}
