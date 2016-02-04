import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataStructuresExamples {

	public static void tryArrayList() {
		
		ArrayList<Name> names = new ArrayList<>();
		
		names.add(new Name("Bob", "Smith"));
		names.add(new Name("Sally", "Sue"));
		names.add(new Name("Bob", "Smith"));
		names.add(new Name("Herb", "Jones"));	
		
		System.out.println(names);
	}
	
	
	public static void tryHashMap() {		
		HashMap<String, Name> names = new HashMap<>();
		names.put("bob", new Name("Bob", "Smith1"));
		names.put("herb", new Name("Herb", "Jones"));
		names.put("sally", new Name("Sally", "Sue"));
		names.put("bob", new Name("Bob", "Smith2"));		
		for(String name: names.keySet()) {
			System.out.println(name + " " + names.get(name));
		}
	
	}

	public static void tryTreeMap() {		
		TreeMap<String, Name> names = new TreeMap<>();
		names.put("bob", new Name("Bob", "Smith"));
		names.put("sally", new Name("Sally", "Sue"));
		names.put("herb", new Name("Herb", "Jones"));
		names.put("bob", new Name("Bob", "Smith"));		
		for(String name: names.keySet()) {
			System.out.println(name + " " + names.get(name));
		}
	}

	public static void tryTreeSet() {		
		TreeSet<Name> names = new TreeSet<>();
		names.add(new Name("Bob", "Smith"));
		names.add(new Name("Sally", "Sue"));
		names.add(new Name("Bob", "Smith"));
		names.add(new Name("Herb", "Jones"));			
		System.out.println(names);
	}
	
	public static void tryLinkedHashMap() {
		LinkedHashMap<String, Name> names = new LinkedHashMap<>();
		names.put("bob", new Name("Bob", "Smith"));
		names.put("herb", new Name("Herb", "Jones"));
		names.put("bob", new Name("Bob", "Smith"));		
		names.put("sally", new Name("Sally", "Sue"));
		System.out.println(names);				
	}
	
	
	public static void main(String[] args) {
//		tryArrayList();
//		tryHashMap();
		tryTreeMap();
//		tryTreeSet();
//		tryLinkedHashMap();
	}
	
}
