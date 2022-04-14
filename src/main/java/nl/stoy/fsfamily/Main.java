package nl.stoy.fsfamily;

import nl.stoy.fsfamily.dataparser.DwellerJsonParser;
import nl.stoy.fsfamily.dataparser.JsonParser;

public class Main {
    public static void main (String[] args) {
        JsonParser jsonParser = new DwellerJsonParser("src/main/data/vault.json");
        jsonParser.parseDwellers();
    }
}
