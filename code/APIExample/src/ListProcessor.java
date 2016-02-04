import java.util.ArrayList;

public class ListProcessor {

	/**
	 * Returns the number of negative integers in the list
	 * passed as input.
	 * Throws NullListException if the list is null.
	 * @param list
	 * @return
	 */
	public static int countNegatives(ArrayList<Integer> list) throws NullListException {
		if(list == null) {
			throw new NullListException("List is null");
		}
		int result = 0;
		for(int i: list) {
			if(i < 0) {
				result++;
			}
		}
		return result;
	}
	
}
