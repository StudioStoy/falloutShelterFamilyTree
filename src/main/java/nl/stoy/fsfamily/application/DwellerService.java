package nl.stoy.fsfamily.application;

import nl.stoy.fsfamily.data.DwellerJsonParser;
import nl.stoy.fsfamily.data.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DwellerService {

    public DwellerService() {

    }

    public List<Dweller> getAllDwellers() {
        String path = "src/main/java/nl/stoy/fsfamily/data/vault.json";
        JsonParser jsonParser = new DwellerJsonParser(path);
        Family family = new Family(jsonParser.parseDwellers());

        return family.getDwellers();
    }



}
