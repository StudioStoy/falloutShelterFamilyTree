package nl.stoy.fsfamily.controller;

import nl.stoy.fsfamily.application.DwellerService;
import nl.stoy.fsfamily.domain.Dweller;
import nl.stoy.fsfamily.domain.Family;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dweller")
public class DwellerController {
    private DwellerService dwellerService;

    public DwellerController(DwellerService dwellerService) {
        this.dwellerService = dwellerService;
    }

    @GetMapping()
    public List<Dweller> allDwellers() {
        return dwellerService.getAllDwellers();
    }
}