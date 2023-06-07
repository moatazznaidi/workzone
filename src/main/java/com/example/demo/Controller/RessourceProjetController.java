package com.example.demo.Controller;

import com.example.demo.Model.RessourceProjet;
import com.example.demo.Service.RessourceProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RessourceProjetController {
    @Autowired
    RessourceProjetService ressourceProjetService;

    @GetMapping("/RessourceProjet")
    public List<RessourceProjet> getAllRessourceProj() {

        List all= ressourceProjetService.getAllRessourcesProj();
        return all;
    }

    @GetMapping("/RessourceProjet/{id}")
    public Optional<RessourceProjet> getRessourceProj(@PathVariable Long id){
        return  ressourceProjetService.getRessourceProj(id); }
    @GetMapping("/getProjectByEmployee/{id}")
    public List<String> getProjectByEmployee(@PathVariable Long id){
        return ressourceProjetService.getProjectbyEmployee(id);
    }

}
