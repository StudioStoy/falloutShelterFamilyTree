import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    public void parse() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("src/main/data/vault.json");

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject allInfo = (JSONObject) obj;

            JSONObject dwellersObject = (JSONObject) allInfo.get("dwellers");
            JSONArray dwellers = (JSONArray) dwellersObject.get("dwellers");

            for (int i=0; i<dwellers.size(); i++) {
                List<Long> parents = new ArrayList<>();
                JSONObject dwellerJSON = (JSONObject) dwellers.get(i);

                long id = (long) dwellerJSON.get("serializeId");
                String firstName = (String) dwellerJSON.get("name");
                String lastName = (String) dwellerJSON.get("lastName");
                long gender = (long) dwellerJSON.get("gender");

                JSONObject relations = (JSONObject) dwellerJSON.get("relations");
                JSONArray ascendants = (JSONArray) relations.get("ascendants");
                for (int parent = 0; parent <= 1; parent++) {
                    parents.add((Long) ascendants.get(parent));
                }

                Dweller dweller = new Dweller(id, firstName, lastName, gender, parents);

                System.out.println(dweller);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

//    private static void parseDwellerObject(JSONObject dweller) {
//        JSONObject dwellerObject = (JSONObject) dweller.get("dwellers");
//
//        //Get employee first name
//        String id = (String) dwellerObject.get("serializeId");
//        System.out.println(id);
//
//        //Get employee last name
//        String firstName = (String) dwellerObject.get("name");
//        System.out.println(firstName);
//
//        //Get employee website name
//        String lastName = (String) dwellerObject.get("lastName");
//        System.out.println(lastName);
//    }

}
