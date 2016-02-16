
public class Latte extends Coffee {

	public Latte(int ounces, boolean isDecaf) {
		super(ounces, isDecaf);
	}

	public void drink() {
		super.drink();
		System.out.println("creamy");
	}

}
