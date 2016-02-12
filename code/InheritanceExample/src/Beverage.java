public abstract class Beverage {

	protected int ounces;
		
	public Beverage(int ounces) {
		this.ounces = ounces;
	}
		
	public int getSize() {
		return this.ounces;
	}
	
	public void drink() {
		System.out.println("Mmm, tasty");
	}

	public abstract String getServingGlass();
}