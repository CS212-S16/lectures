import java.util.HashMap;
import java.util.UUID;

public class Data {

	//maintain a map of name to UserInfo object
	protected HashMap<String, UserInfo> userInfo;

	//constructor
	public Data() {
		userInfo = new HashMap<String, UserInfo>();
	}
		
	/*
	 * Returns true if the user exists in the data store.
	 */
	public synchronized boolean userExists(String name) {
		return userInfo.containsKey(name);
	}
	
	/*
	 * Add a new UserInfo object for a particular user.
	 */
	public synchronized void addUser(String name) {
		if(!userInfo.containsKey(name)) {
			userInfo.put(name, new UserInfo(name));
		}
	}

	/*
	 * For a given user, add a new todo.
	 */
	public synchronized boolean add(String name, String item) {
		if(!userInfo.containsKey(name)) {
			return false;
		}
		userInfo.get(name).addTodoItem(item);
		return true;
	}
	
	public synchronized void delete(String name, int index) {
		if(userInfo.containsKey(name)) {
			userInfo.get(name).delete(index);
		}
	}

	/*
	 * Returns a String containing an HTML representation of the
	 * list associated with the session identified by id.
	 */
	public synchronized String listToHtml(String name) {

		if(!userInfo.containsKey(name)) {
			return null;
		}		
		return userInfo.get(name).listToHtml();
	}


}
