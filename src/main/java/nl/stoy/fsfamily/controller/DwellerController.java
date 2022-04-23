package nl.stoy.fsfamily.controller;

import nl.stoy.fsfamily.application.DwellerService;
import nl.stoy.fsfamily.domain.Dweller;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vault")
public class DwellerController {
    private final DwellerService dwellerService;

    public DwellerController(DwellerService dwellerService) {
        this.dwellerService = dwellerService;
    }

    @PostMapping()
    @CrossOrigin()
    public List<Dweller> uploadVault(@RequestBody JSONObject vault) {
        this.dwellerService.setVault(vault);

        return this.dwellerService.getAllDwellers();
    }

    @GetMapping("/family/{id}")
    @CrossOrigin()
    public List<Dweller> getDwellerFamilyById(@PathVariable long id) {
        return dwellerService.getDwellerFamilyById(id);
    }
}
