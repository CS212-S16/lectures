
public abstract class Beverage {

	protected int ounces;
	
	public Beverage(int ounces) {
		this.ounces = ounces;
	}
	
	public abstract String getServingGlass();
	
	public void drink() {
		System.out.println("mmm tasty");
	}
	
}
