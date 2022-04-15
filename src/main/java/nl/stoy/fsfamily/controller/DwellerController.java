package nl.stoy.fsfamily.controller;

import nl.stoy.fsfamily.domain.Dweller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dweller")
public class DwellerController {

    public DwellerController() {}

    @GetMapping()
    public List<Dweller> allDwellers() {

    }
}
