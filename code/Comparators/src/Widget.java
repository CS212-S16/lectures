
public class Widget {

	private int value;
	private String description;
	
	public Widget(int value, String description) {
		super();
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return value + " " + description;
	}	
}
