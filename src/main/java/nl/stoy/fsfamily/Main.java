package nl.stoy.fsfamily;

import nl.stoy.fsfamily.dataparser.DwellerJsonParser;
import nl.stoy.fsfamily.dataparser.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        JsonParser jsonParser = new DwellerJsonParser("src/main/data/vault.json");
        List<Dweller> dwellers = jsonParser.parseDwellers();

        Family family = new Family(dwellers);

        System.out.println(family.findChildrenByParentId(6));
    }
}
