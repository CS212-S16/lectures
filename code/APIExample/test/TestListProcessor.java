import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class TestListProcessor {

	@Test
	public void testEmpty() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			assertEquals(0, ListProcessor.countNegatives(list));
		} catch(NullListException nle) {
			fail("NullListException thrown in case of list with no elements");
		}
	}

	@Test
	public void testNull() {
		try {
			assertEquals(-1, ListProcessor.countNegatives(null));
		} catch(NullListException nle) {
			//passes test
			return;
		}
		fail("NullListException not thrown in case of null list");
	}

	@Test
	public void testCountNegatives() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(-1);
		list.add(-11);
		list.add(5);
		try {
			assertEquals(2, ListProcessor.countNegatives(list));
		} catch(NullListException nle) {
			fail("NullListException thrown in case of list with " + list.size() + " elements");
		}
	}


}
