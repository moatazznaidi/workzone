package com.example.demo.Controller;

import com.example.demo.Model.Project;
import com.example.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectService projectService ;
    @GetMapping("/project")
    public List<Project> getAllProject() {

        List all= projectService.getAllProject();
        return all;
    }

    @GetMapping("/project/{id}")
    public Optional<Project> getProject(@PathVariable Long id){
        return  projectService.getProject(id); }

    @PostMapping(value = "/project" )
    public Project createEProject(@RequestBody Project project) {
        return projectService.createProj(project);}

    @RequestMapping(value="/project/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProj(id);
    }




    @PutMapping("/project/{id}")
        public ResponseEntity<Project> UpdateProject(@PathVariable Long id, @RequestBody Project project){
        return projectService.updateProj(id,project);
    }


    @GetMapping("/project/count")
    public ResponseEntity<Long> countProjects() {
        Long count = projectService.countProjects();
        return ResponseEntity.ok(count);
    }


}
