import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Example {

	public static void tryTweet() {
		
		String tweet = "Everyone knows #cs212 is an #awesome class at #usf"; //at #usf
		//How would you modify to disregard a # in the middle of a word?
		
		Pattern p = Pattern.compile("#(.*?)(\\s|$)");
				
		int count = 0;		
		Matcher m = p.matcher(tweet);		
		while (m.find()) {
			System.out.println("Tag " + ++count + ": "  + m.group(1));
		}
		
	}
	
	public static void tryEmail() {
		
		String addrs = "srollins@cs.usfca.edu, snrollins@usfca.EDU, srollins@gmail.com, rollins@samirollins.com";
		
		Pattern p = Pattern.compile("(?i)(^|\\s)(.*?)@(.*?)\\.(com|edu)");		
		
		int count = 0;
		Matcher m = p.matcher(addrs);		
		while (m.find()) {
			System.out.println("User " + ++count + ": "  + m.group(2));
		}
	}
	
	public static void tryParensExample() {
		
		String addrs = "abababaacababaac";
		
		Pattern p = Pattern.compile("((ab)+?(aac))");		
		
		int count = 0;
		Matcher m = p.matcher(addrs);		
		while (m.find()) {
			System.out.println(m.group(2));
		}
	}
	
	public static void main(String[] args) {
		
		tryTweet();
		//tryEmail();
		//tryParensExample();
		
	
	
	
	}
	
	
	
}
