import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FetchExample {

	
	public static void main(String[] args) {		
		//test out the HTTPFetcher
//		String page = HTTPFetcher.download("www.cs.usfca.edu", "/~srollins/test.html");
		
		String apiKey = "YOUR_KEY";
		String artist = "Madonna";
		String track = "Holiday";
		String page = HTTPFetcher.download("ws.audioscrobbler.com", "/2.0?artist=" + artist + 
						"&track=" + track + 
						"&api_key=" + apiKey + 
						"&method=track.getInfo&format=json");
		
		
		
		
		System.out.println(page);
		System.out.println("******");
		System.out.println(mystery1(page));
		
	}

}