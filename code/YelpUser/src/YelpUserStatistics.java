import java.nio.file.Path;

public class YelpUserStatistics {

	//TODO: declare constants and data members
	
	public YelpUserStatistics(Path path) {
		//TODO: initialize data members
		
	}
	
		//open file
		//for each line
		// parse as json
		// if review count > threshold
		//  increment active
		// if at least one vote recorded
		//  increment voters
		
	
	/**
	 * Returns the number of active users.
	 * An active user is one who has contributed 
	 * more than 10 reviews.
	 * 
	 * @return
	 */
	public int getNumberActiveUsers() {		
		return 0;
	}
	
	/**
	 * Returns the number of users who 
	 * have voted at least once.
	 * 
	 * @return
	 */
	public int getVoters() {
		return 0;
	}
	
}