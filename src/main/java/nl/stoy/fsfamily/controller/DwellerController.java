package nl.stoy.fsfamily.controller;

import nl.stoy.fsfamily.application.DwellerService;
import nl.stoy.fsfamily.domain.Dweller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dweller")
public class DwellerController {
    private DwellerService dwellerService;

    public DwellerController(DwellerService dwellerService) {
        this.dwellerService = dwellerService;
    }

    @GetMapping()
    @CrossOrigin()
    public List<Dweller> allDwellers() {
        return dwellerService.getAllDwellers();

    }

    @GetMapping("/family/{id}")
    @CrossOrigin()
    public List<Dweller> getDwellerFamilyById(@PathVariable long id) {
        return dwellerService.getDwellerFamilyById(id);
    }
}
