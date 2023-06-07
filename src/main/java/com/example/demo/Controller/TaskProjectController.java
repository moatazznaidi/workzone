package com.example.demo.Controller;

import com.example.demo.Model.TasksProject;
import com.example.demo.Model.TicketNameEnum;
import com.example.demo.Model.TicketTypeEnum;
import com.example.demo.Service.TaskProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TaskProjectController {

    @Autowired
    private TaskProjectService taskProjectService ;

    @GetMapping("/tasksProject")
    public List<TasksProject> getAllTaskProject() {

        List all= taskProjectService.getAllTaskProject();
        return all;
    }
    @GetMapping("/tasksProject/{id}")
    public Optional<TasksProject> getTaskProj(@PathVariable Long id){
        return taskProjectService.getTaskProj(id); }

    @PostMapping(value = "/tasksProject" )
    public TasksProject createTaskProj(@RequestBody TasksProject tasksProject) {
        return taskProjectService.createTaskProj(tasksProject);}

    @RequestMapping(value="/tasksProject/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskProj(@PathVariable Long id){
        taskProjectService.deleteTaskProj(id);
    }

    @PutMapping("/tasksProject/{id}")
    public ResponseEntity<TasksProject> UpdateTasksProj(@PathVariable Long id, @RequestBody TasksProject tasksProject){
        return taskProjectService.UpdateTasksProj(id,tasksProject);
    }
    @GetMapping("/tasksProject/status")
    public List<TicketTypeEnum> getTaskStatus(){
        List<TicketTypeEnum> enumValues = new ArrayList<TicketTypeEnum>(EnumSet.allOf(TicketTypeEnum.class));
        return  enumValues;
    }

    @GetMapping("/tasksProject/name")
    public List<TicketNameEnum> getTaskName(){
        List<TicketNameEnum> enumValue = new ArrayList<TicketNameEnum>(EnumSet.allOf(TicketNameEnum.class));
        return  enumValue;
    }

}
