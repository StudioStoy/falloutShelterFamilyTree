package nl.stoy.fsfamily.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.stoy.fsfamily.domain.Dweller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DwellerJsonParser implements JsonParser {
    private String path = "";

    public DwellerJsonParser(String path) {
        this.path = path;
    }

    public List<Dweller> parseDwellers() {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader(path);

            Object obj = jsonParser.parse(reader);

            JSONObject allInfo = (JSONObject) obj;

            JSONObject dwellersObject = (JSONObject) allInfo.get("dwellers");
            JSONArray JSONDwellers = (JSONArray) dwellersObject.get("dwellers");

            List<Dweller> dwellers = new ArrayList<>();

            for (Object jsonDweller : JSONDwellers) {
                List<Long> parents = new ArrayList<>();
                JSONObject dwellerJSON = (JSONObject) jsonDweller;

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
                dwellers.add(dweller);
            }

            return dwellers;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
