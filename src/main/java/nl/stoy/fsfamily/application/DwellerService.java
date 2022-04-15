package nl.stoy.fsfamily.application;

import nl.stoy.fsfamily.data.DwellerJsonParser;
import nl.stoy.fsfamily.data.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DwellerService {

    public DwellerService() {

    }

    public List<Dweller> getAllDwellers() {
        String path = "src/main/java/nl/stoy/fsfamily/data/vault.json";
        JsonParser jsonParser = new DwellerJsonParser(path);

        return jsonParser.parseDwellers();
    }



}
