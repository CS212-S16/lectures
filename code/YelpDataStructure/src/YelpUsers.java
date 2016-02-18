import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class YelpUsers {

	//Maintain a data structure containing data about all Yelp users.
	//It should be efficient to fetch user information given a specific user id.
	//It should also be efficient to fetch a list of all users with a given user name.
	
	private TreeMap<String, YelpUser> usersMap;
	private HashMap<String, ArrayList<YelpUser>> nameMap;	
	
	
	public YelpUsers() {
		this.usersMap = new TreeMap<>();
		this.nameMap = new HashMap<>();
	
	}	
	
	
	public void add(YelpUser user) {
		
		this.usersMap.put(user.getId(), user);
		
		
		String name = user.getName();
		//if I have never seen a user with this name before
		//  create a new arraylist to put into the map
		if(!this.nameMap.containsKey(name)) {
			this.nameMap.put(name, new ArrayList<YelpUser>());
		}

		
//		this.nameMap.get(name).add(user); // this is the same as the following two lines
		
		ArrayList<YelpUser> tmp = this.nameMap.get(name);
		tmp.add(user);
	
	}
	
	public ArrayList<YelpUser> getByName(String name) {
		if(!this.nameMap.containsKey(name)) {
			return new ArrayList<YelpUser>();
		}
		return this.nameMap.get(name);
	}
	
	public YelpUser getByUserId(String userId) {
		return this.usersMap.get(userId);
	}
	
	public void debugById() {
		//Path path = Paths.get("/Users/srollins/teaching/cs212/lectures/code/YelpDataStructure/tmp.txt");
		Path path = Paths.get("tmp.txt");
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.forName("UTF-8")))) {
			for(String id: this.usersMap.navigableKeySet()) {
				writer.println(this.usersMap.get(id));				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
}
