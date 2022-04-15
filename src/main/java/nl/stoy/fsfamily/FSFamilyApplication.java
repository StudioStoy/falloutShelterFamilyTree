package nl.stoy.fsfamily;

import nl.stoy.fsfamily.data.DwellerJsonParser;
import nl.stoy.fsfamily.data.JsonParser;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FSFamilyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FSFamilyApplication.class, args);
    }
}
