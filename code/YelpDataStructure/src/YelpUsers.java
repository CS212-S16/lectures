import java.util.ArrayList;
import java.util.HashMap;

public class YelpUsers {

	//Maintain a data structure containing data about all Yelp users.
	//It should be efficient to fetch user information given a specific user id.
	//It should also be efficient to fetch a list of all users with a given user name.
	
	private HashMap<String, YelpUser> usersMap;
	private HashMap<String, ArrayList<YelpUser>> nameMap;	
	
	
	public YelpUsers() {
		this.usersMap = new HashMap<>();
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
		//TODO: implement this!
		return null;
	}
	
	public YelpUser getByUserId(String userId) {
		//TODO: is this method doing the right thing if userId is not in our data structure?
		return this.usersMap.get(userId);
	}
	
}
