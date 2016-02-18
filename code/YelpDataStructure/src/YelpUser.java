import java.util.*;

/*
{  
   "votes":{  
      "funny":15,
      "useful":48,
      "cool":18
   },
   "user_id":"JkeCKyEaQlbLd9uZYl4DjA",
   "name":"LiiLii C.",
   "url":"http://www.yelp.com/user_details?userid=JkeCKyEaQlbLd9uZYl4DjA",
   "average_stars":3.2258064516128999,
   "review_count":31,
   "type":"user"
}
 */

public class YelpUser {

	private String name;
	private String id;
	private int reviewCount;
//	private HashMap<String, Integer> votes;	
	
	/**
	 * Construct a YelpUser.
	 * @param name
	 * @param id - must be unique
	 * @param reviewCount
	 */
	public YelpUser(String name, String id, int reviewCount) {
		super();
		this.name = name;
		this.id = id;
		this.reviewCount = reviewCount;
	}

	/**
	 * Returns the name of this YelpUser.
	 * @return
	 */
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getReviewCount() {
		return reviewCount;
	}
	
	/**
	 * Boring toString method used for debugging
	 */
	public String toString() {
		return id + " - " + name;
	}
	
	public static void main(String[] args) {
		System.out.println("YelpUser main method");
	}
		
}
