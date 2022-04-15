package nl.stoy.fsfamily.application;

import nl.stoy.fsfamily.data.DwellerJsonParser;
import nl.stoy.fsfamily.data.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DwellerService {
    private Family family;

    public DwellerService() {
        String path = "src/main/java/nl/stoy/fsfamily/data/vault.json";
        JsonParser jsonParser = new DwellerJsonParser(path);
        family = new Family(jsonParser.parseDwellers());
    }

    public List<Dweller> getAllDwellers() {
        return family.getDwellers();
    }

    public List<Dweller> getDwellerFamilyById(long id) {
        return family.findChildrenByParentId(id);
    }
}
