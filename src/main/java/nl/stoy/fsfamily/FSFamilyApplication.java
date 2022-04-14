package nl.stoy.fsfamily;

import nl.stoy.fsfamily.dataparser.DwellerJsonParser;
import nl.stoy.fsfamily.dataparser.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class FSFamilyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FSFamilyApplication.class, args);
        JsonParser jsonParser = new DwellerJsonParser("src/main/java/nl/stoy/fsfamily/data/vault.json");
        List<Dweller> dwellers = jsonParser.parseDwellers();

        Family family = new Family(dwellers);

        System.out.println(family.findDwellersByName("stej"));
        System.out.println(family.findDwellersByName("joy"));
        System.out.println(family.findChildrenByParentId(6));
        System.out.println(family);
    }
}
