
public class Soda extends Beverage {

	private int sugarContent;
	
	public Soda(int ounces, int sugarContent) {
		super(ounces);
		this.sugarContent = sugarContent;
	}

	public int getSugarContent() {
		return this.sugarContent;
	}
	
	@Override
	public String getServingGlass() {
		return "Glass";
	}
	
	
	
	
}
