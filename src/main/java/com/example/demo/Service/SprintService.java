package com.example.demo.Service;

import com.example.demo.Model.Sprints;
import com.example.demo.Repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SprintService {
    @Autowired
    private SprintRepository sprintRepository ;

    @Autowired
    private ProjectService projectService;

    public SprintService(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    public List<Sprints> getAllSprint(){
        List<Sprints> all = sprintRepository.findAll();
        return all;}

    public Optional<Sprints> getSprint(Long id){
        return sprintRepository.findById(id);
    }

    public Sprints createSpr (Sprints sprint){return sprintRepository.save(sprint);}

    public  void deleteSpr (Long id) {sprintRepository.deleteById(id);}


    public ResponseEntity<Sprints> updateSpr (Long id, Sprints sprint){
        Optional<Sprints> SprintsData = sprintRepository.findById(id);

        if (SprintsData.isPresent()) {
            Sprints _sprint  = SprintsData.get();
            _sprint.setSprintName(sprint.getSprintName());
            _sprint.setDescription(sprint.getDescription());
            _sprint.setSprintEndDate(sprint.getSprintEndDate());
            _sprint.setSprintStartDate(sprint.getSprintStartDate());

            return new ResponseEntity<>(sprintRepository.save( _sprint), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


     public List<Sprints> getSprintsByProject(Long idProject){

            List<Sprints> sprints=sprintRepository.findAll();

         System.out.println(sprints);

            List <Sprints> sprintsPrj=new ArrayList<>();

         for (Sprints sprint : sprints) {
             if ((sprint.getIdProject()==idProject)) {
                 sprintsPrj.add(sprint);

                 System.out.println(sprint);
             }

         }
         return  sprintsPrj;
    }


    public Long countSprints() {
        return sprintRepository.count();
    }



}
