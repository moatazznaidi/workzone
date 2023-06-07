package com.example.demo.Controller;

import com.example.demo.Model.Sprints;
import com.example.demo.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class SprintController {

    @Autowired
    SprintService sprintService ;


    @GetMapping("/sprint")
    public List<Sprints> getAllSprint() {

        List all= sprintService.getAllSprint();
        return all;
    }

    @GetMapping("/sprint/{id}")
    public Optional<Sprints> getSprint(@PathVariable Long id){
        return  sprintService.getSprint(id); }

    @PostMapping(value = "/sprint" )
    public Sprints createSprint(@RequestBody Sprints sprint) {
        return sprintService.createSpr(sprint);}

    @RequestMapping(value="/sprint/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSprint(@PathVariable Long id){
        sprintService.deleteSpr(id);
    }

    @PutMapping("/sprint/{id}")
    public ResponseEntity<Sprints> UpdateSprint(@PathVariable Long id, @RequestBody Sprints sprint){
        return sprintService.updateSpr(id,sprint);
    }

    @GetMapping("/pr-sprint/{idProject}")
    public List<Sprints> getSprintsByProject(@PathVariable Long idProject) {
        return  sprintService.getSprintsByProject(idProject);
    }




    @GetMapping("/sprint/count/{idProject}")
    public ResponseEntity<Long> countSprints() {
        Long count = sprintService.countSprints();
        return ResponseEntity.ok(count);
    }



}
