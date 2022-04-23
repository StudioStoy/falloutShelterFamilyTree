package nl.stoy.fsfamily.application;

import nl.stoy.fsfamily.data.DwellerJsonParser;
import nl.stoy.fsfamily.data.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class DwellerService {
    private Family family;
    private static FileWriter writer;
    private final String path;

    public DwellerService() {
        this.path = "src/main/java/nl/stoy/fsfamily/data/vault.json";
    }

    public List<Dweller> getAllDwellers() {
        return family.getDwellers();
    }

    public List<Dweller> getDwellerFamilyById(long id) {
        return family.findChildrenByParentId(id);
    }

    public void setVault(JSONObject vaultData) {
        try {
            writer = new FileWriter(path);
            writer.write(vaultData.toJSONString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();

                this.parseVaultData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void parseVaultData() {
        JsonParser jsonParser = new DwellerJsonParser(path);
        jsonParser.parseDwellers();
        family = new Family(jsonParser.parseDwellers());
    }
}
