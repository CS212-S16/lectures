import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HeaderMatcher {
	
	public static String readFile(String fileName) {
		StringBuffer buf = new StringBuffer();
		try (Scanner instream = new Scanner(new FileReader(fileName))) {		
			while(instream.hasNext()) {
				buf.append(instream.nextLine() + "\n");
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return buf.toString();
	}	

	
	public static void printMatches(String data, String regex) {
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);
		System.out.println("Regular expression: " + regex);
		int match = 1;
		while(m.find()) {
			int count = 1;
			for(int i = 0; i < m.groupCount(); i++) {
				System.out.println("Match " + match + " - Group " + count++ + ":\n" + m.group(i));
			}
			match++;
			System.out.println();
		}
		System.out.println("\n============\n");
	}

	
	
	public static void main(String[] args) {
		String data = readFile("customerinfo.txt");
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//note newline does not match .
		printMatches(data, "(.+:.+)");
		
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//note that DOTALL mode allows newline to match .
		printMatches(data, "(?s)(.+:.+)");
		
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//use DOTALL mode and reluctant quantifier
		printMatches(data, "(?s)(.+?:.+?)");
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//followed by a blank line
		//use DOTALL mode and reluctant quantifier		
		//note, does not use MULTILINE mode
		printMatches(data, "(?s)(.+?:.+?)^\\s*$");
		
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//followed by a blank line
		//use DOTALL mode and reluctant quantifier and MULTILINE mode
		printMatches(data, "(?sm)(.+?:.+?)^\\s*$");
		
		//print out matches for one or more chars, followed by : followed by one or more chars
		//followed by a blank line
		//use DOTALL mode and reluctant quantifier and MULTILINE mode
		printMatches(data, "(?sm)((.+?:.+?)+?)^\\s*$");
				
	}
	
	
}
