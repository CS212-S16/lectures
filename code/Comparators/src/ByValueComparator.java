import java.util.Comparator;

public class ByValueComparator implements Comparator<Widget>{

	@Override
	public int compare(Widget o1, Widget o2) {
//		if(o1.getValue() < o2.getValue()) {
//			return -1;
//		} else if (o1.getValue() == o2.getValue()) {
//			return o1.getDescription().compareTo(o2.getDescription());
//		} else {
//			return 1;
//		}
//		
		if(o1.getValue() == o2.getValue()) {
			return o1.getDescription().compareTo(o2.getDescription());
		}
		return o1.getValue()-o2.getValue();
		
		
		
//		return o1.getValue()-o2.getValue();
	}

}
