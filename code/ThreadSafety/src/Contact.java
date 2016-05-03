
public class Contact {

	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Contact clone() {
		return new Contact(name, phone);
	}
}
