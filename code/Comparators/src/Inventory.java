import java.util.TreeSet;

public class Inventory {

	private TreeSet<Widget> widgetsByValue;
	private TreeSet<Widget> widgetsByDescription;
	
	public Inventory() {
		widgetsByValue = new TreeSet<>(new ByValueComparator());
		widgetsByDescription = new TreeSet<>(new ByDescriptionComparator());
	}
	
	public void addWidget(Widget widget) {
		widgetsByValue.add(widget);
		widgetsByDescription.add(widget);
	}
	
	public void printByValue() {
		for(Widget w: widgetsByValue) {
			System.out.println(w);
		}
	}
	
	public void printByDescription() {
		for(Widget w: widgetsByDescription) {
			System.out.println(w);
		}
		
	}
}
