public class FetchExample {

	
	public static void main(String[] args) {		
		//test out the HTTPFetcher
		String page = HTTPFetcher.download("www.cs.usfca.edu", "/~srollins/test.html");
		
//		String apiKey = "YOUR_KEY";
//		String artist = "Madonna";
//		String track = "Holiday";
//		String page = HTTPFetcher.download("ws.audioscrobbler.com", "/2.0?artist=" + artist + 
//						"&track=" + track + 
//						"&api_key=" + apiKey + 
//						"&method=track.getInfo&format=json");
		
		System.out.println(page);
		
	}

}