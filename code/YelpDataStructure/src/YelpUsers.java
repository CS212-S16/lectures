import java.util.ArrayList;
import java.util.HashMap;
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
		for(String id: this.usersMap.navigableKeySet()) {
			System.out.println(id + ": " + this.usersMap.get(id));
		}
	}
	
	
}
