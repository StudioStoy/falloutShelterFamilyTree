package nl.stoy.fsfamily.dataparser;

import nl.stoy.fsfamily.domain.Dweller;

import java.util.List;

public interface DwellerJsonParser {
    List<Dweller> parseDwellers();
}
