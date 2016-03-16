import java.util.ArrayList;
import java.util.UUID;


public class UserInfo {

	private String name;
	private ArrayList<String> todos;
	
	public UserInfo(String name) {
		super();
		this.name = name;
		this.todos = new ArrayList<String>();
	}
	
	
	public synchronized void addTodoItem(String item) {
		this.todos.add(item);
	}

	public synchronized void delete(int index) {
		if(this.todos.size() > index) {
			this.todos.remove(index);
		}
	}


	public synchronized String getName() {
		return name;
	}
	
	public synchronized String listToHtml() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<table border=1 border-spacing=3px>");
		builder.append("<tr><td colspan=2><b>" + name + "'s ToDo List!</b></td></tr>");
		int i = 0;
		for(String todo: todos) {
			builder.append("<b><tr><td>" + todo + "</td><td><form action=\"list?delete=" + i++ + "\" method=\"post\"><input type=\"submit\" value=\"Done!\"></form></td></tr></b>");
		}
		builder.append("</table>");
		return builder.toString();
	}
	
	
}
