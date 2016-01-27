import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YelpUserStatistics {

	//TODO: declare constants and data members
	private int numActive;
	private Path path;
		
	public YelpUserStatistics(Path path) {
		//TODO: initialize data members
		this.path = path;
		this.numActive = 0;
		parseUsers();
	}
	
	/**
	 * Logic to initialize data members from user file:
	 * open file
	 * for each line
	 * 	 parse as json
	 *   if review_count > threshold
	 * 	   increment active
	 *   if at least one vote is recorded
	 *     increment voters  
	 */
	private void parseUsers() {
		
		//create a parser to take text and create JSONObjects
		JSONParser parser = new JSONParser();

		//open the file using try-with-resources
		try (BufferedReader reader = Files.newBufferedReader(this.path, Charset.forName("UTF-8"))) {
			//read in the first line of the file
			String line = reader.readLine();
			//as long as there is another line to process
			while(line != null) {
				//take the line of text and create a JSONObject
				JSONObject contents = (JSONObject) parser.parse(line);
				//retrieve the value associated with the key "review_count"
				long reviewCount = (long) contents.get("review_count");
				
				//if the review count is greater than 10, increment active users
				//it would be a great idea to use a constant rather than a magic number!
				if(reviewCount > 10) {
					this.numActive++;
				}
				//update our loop control variable
				//i.e., read the next line
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
		
	
	/**
	 * Returns the number of active users.
	 * An active user is one who has contributed 
	 * more than 10 reviews.
	 * 
	 * @return
	 */
	public int getNumberActiveUsers() {		
		return this.numActive;
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
