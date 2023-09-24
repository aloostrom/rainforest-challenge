import java.util.*;

public class JsonParser {
	Map<String, String> json = new HashMap<>();
	
	public JsonParser(String message) {	
		//This is simple JSON with only two lines
		// manually remove the braces
		message = message.substring(1, message.length() - 1); 

        //Split the string by , to get key-value pairs
        String[] keyValuePairs = message.split(","); 

        //Iterate over the pairs
        for (String pair : keyValuePairs) 
        {
            //Split the pairs to get key and value 
            String[] entry = pair.split("\":\"");

            //Add them to the hashmap and trim whitespaces and quotes
            this.json.put(entry[0].replaceAll("\"", "").trim(), entry[1].replaceAll("\"", "").trim());
        }
	}
	
	public Map<String, String> getJsonMap() {
		return this.json;
	}

}
