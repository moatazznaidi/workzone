package com.example.demo.Service;

import com.example.demo.Model.Project;
import com.example.demo.Model.RessourceProjet;
import com.example.demo.Repository.RessourceProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RessourceProjetService {
    @Autowired
    private RessourceProjetRepository ressourceProjetRepository;

    public List<RessourceProjet> getAllRessourcesProj(){
        List<RessourceProjet> all = ressourceProjetRepository.findAll();
        return all;
    }

    public Optional<RessourceProjet> getRessourceProj(Long id){
        return  ressourceProjetRepository.findById(id);
    }

    public List<String> getProjectbyEmployee(Long id){
        List <String> all= ressourceProjetRepository.GetProjectByIdEmployee(id) ;
        return all ;
    }

}
