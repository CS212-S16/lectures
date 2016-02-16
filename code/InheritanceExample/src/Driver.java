
public class Driver {

	public static void main(String[] args) {

		
		Beverage[] beverages = new Beverage[3];
		beverages[0] = new Soda(12, 45);
		beverages[1] = new Coffee(8, false);
		beverages[2] = new Latte(12, true);		
		for(Beverage b: beverages) {			
			if(b instanceof Coffee) {			
				Coffee c = (Coffee) b;
				System.out.println(c.isDecaf());
			} else if(b instanceof Soda) {
				Soda s = (Soda) b;
				System.out.println(s.getSugarContent());
			}			
		}
		
		
		
		
		
		
	}

}
