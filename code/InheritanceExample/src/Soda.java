
public final class Soda extends Beverage {

	private int sugarContent;
	
	public Soda(int ounces, int sugarContent) {
		super(ounces);
		this.sugarContent = sugarContent;
	}

	@Override
	public String getServingGlass() {
		return "Glass";
	}
	
	
	
	
}
