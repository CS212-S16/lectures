
public class Driver {

	public static void main(String[] args) {

		Widget w1 = new Widget(1, "B");
		Widget w2 = new Widget(2, "A");
		Widget w3 = new Widget(3, "C");
		Widget w4 = new Widget(12, "A");
		Inventory inventory = new Inventory();
		inventory.addWidget(w1);
		inventory.addWidget(w2);
		inventory.addWidget(w3);
		inventory.addWidget(w4);
		inventory.printByValue();
		System.out.println("************");
		inventory.printByDescription();
	}

}
