import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTest {

	public static void main(String[] args) throws ParseException {
		String jsonString = "{\"votes\":[ 1, 2], \"name\": \"Sami\"}";
		
		JSONParser parser = new JSONParser();
		
		JSONObject obj = (JSONObject) parser.parse(jsonString);
		
		for(Object key: obj.entrySet()) {
			System.out.println(key);
		}
		
//		JSONArray array = (JSONArray) obj.get("votes");
//		for(int i = 0; i < array.size(); i++) {
//			System.out.println(array.get(i));
//		}
//
	}

}
