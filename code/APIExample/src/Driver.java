import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
//		list.add(-1);
//		list.add(-11);
		list.add(5);
		try {
			int result = ListProcessor.countNegatives(list);
			System.out.println(result);
		} catch (NullListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
