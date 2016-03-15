import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneFinder {

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

	public static TreeSet<Integer> getAreaCodes(String data) {
		
		TreeSet<Integer> areaCodes = new TreeSet<>();
		String regex = "(\\d{3})(-\\d{3}-\\d{4})";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()) {
			int areaCode = Integer.parseInt(matcher.group(1));
			areaCodes.add(areaCode);
			//System.out.println(matcher.group(1));
		}
		return areaCodes;		
	}

	public static String extractHeaders(String data) {		
		String REGEX = "(?sm)(.+?:.+?)+(^\\s*$)";
		return data.replaceFirst(REGEX, "");
	}
	
	
	public static void main(String[] args) throws IOException {
		String data = readFile("customerinfo.txt");		

		data = extractHeaders(data);		
		//System.out.println(data);		
		//getAreaCodes(data).size();
		System.out.println(getAreaCodes(data).size());
	}


}
