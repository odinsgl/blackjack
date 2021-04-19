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
	
	private final String resultHistory = "result_history";
	private List<String> resultStrings = new ArrayList<String>();
	private String stringDate;
	
	public void addDate() {
		DateFormat sdf = new SimpleDateFormat("dd.MMMM - kk:mm:ss");
		Date date = new Date();
		stringDate = sdf.format(date);
		
		resultStrings.add(stringDate + "\n");
	}
	
	public void writeResultsFile(String text) {
		
		resultStrings.add(text);
		
		try {
			PrintWriter writer = new PrintWriter(resultHistory);
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
}
