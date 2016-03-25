import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FetchExample {

	/**
	 * What does the mystery method do?
	 * @param page
	 * @return
	 */
	public static String mystery1(String page) {

		String newPage = page.replaceAll("(?is)<.*?>", "");
		return newPage;		

	}
 
	/**
	 * What does the mystery method do?
	 * @param page
	 * @return
	 */
	public static ArrayList<String> mystery2(String page) {
				
		String REGEX = "(?is)(<\\s*a\\s+[^>]*href\\s*=\\s*\")(.+?)(\")";
		int GROUP = 2;
		ArrayList<String> result = new ArrayList<String>();
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(page);
		while(m.find()) {
			result.add(m.group(GROUP));
		}
		return result;
	}



	public static void main(String[] args) {

		//test out the HTTPFetcher
		String page = HTTPFetcher.download("www.cs.usfca.edu", "/~srollins/test.html");
		
		System.out.println(page);
		System.out.println("******");
		System.out.println(mystery1(page));
		
	}

}