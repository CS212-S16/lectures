import java.util.Comparator;

public class ByDescriptionComparator implements Comparator<Widget>{

	@Override
	public int compare(Widget o1, Widget o2) {
		if(o1.getDescription().equals(o2.getDescription())) {
			return o1.getValue()-o2.getValue();
		}
		return o1.getDescription().compareTo(o2.getDescription());
	}

}
