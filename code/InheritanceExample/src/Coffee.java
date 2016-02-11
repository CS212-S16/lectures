
public class Coffee extends Beverage {

	private boolean isDecaf;
	
	public Coffee(int ounces, boolean isDecaf) {
		super(ounces);
		this.isDecaf = isDecaf;		
	}
	
	@Override
	public String getServingGlass() {
		return "cup";
	}

	public String toString() {
		return "Coffee: " + ounces + " " + getServingGlass();
	}
	
	public void drink() {
		System.out.println("that's hot!");
	}

	
}
