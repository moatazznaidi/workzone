package com.example.demo.Controller;

import com.example.demo.Model.EmplProj;
import com.example.demo.Service.EmplProjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")

public class EmplProjController {

    @Autowired
    EmplProjService emplProjService;

    @GetMapping("/emplProj")
    public List<EmplProj> getAllProject() {

        List all= emplProjService.getAllEmplProj();
        return all;
    }

    @GetMapping("/emplProj/{id}")
    public Optional<EmplProj> getTeam(@PathVariable Long id){
        return  emplProjService.getEmplProj(id); }

    @PostMapping(value = "/emplProj" )
    public EmplProj createTeam(@RequestBody EmplProj emplProj) {
        return emplProjService.createEmplProj(emplProj);}

    @RequestMapping(value="/emplProj/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmplProj(@PathVariable Long id){
        emplProjService.deleteEmplProj(id);
    }

    @PutMapping("/emplProj/{id}")
    public ResponseEntity<EmplProj> UpdateEmplProj(@PathVariable Long id, @RequestBody EmplProj emplProj){
        return emplProjService.updateEmplProj(id,emplProj);
    }

}
