package nl.stoy.fsfamily.data;

import nl.stoy.fsfamily.domain.Dweller;

import java.util.List;

public interface JsonParser {
    List<Dweller> parseDwellers();
}
