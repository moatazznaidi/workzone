package com.example.demo.Controller;

import com.example.demo.Model.Tasks;
import com.example.demo.Model.TicketNameEnum;
import com.example.demo.Model.TicketTypeEnum;
import com.example.demo.Service.TasksService;
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
public class TasksController {

    @Autowired
   private TasksService tasksservice ;

    @GetMapping("/tasks")
    public List<Tasks> getAllTasks() {

        List all= tasksservice.getAllTasks();
        return all;
    }
    @GetMapping("/tasks/{id}")
    public Optional<Tasks> getTask(@PathVariable Long id){
        return  tasksservice.getTask(id); }

    @PostMapping(value = "/tasks" )
    public Tasks createTask(@RequestBody Tasks task) {
        return tasksservice.createTask(task);}

    @RequestMapping(value="/tasks/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Long id){
        tasksservice.deleteTask(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Tasks> UpdateTasks(@PathVariable Long id, @RequestBody Tasks task){
        return tasksservice.updateTasks(id,task);
    }
    @GetMapping("/tasks/status")
    public List<TicketTypeEnum> getTaskStatus(){
        List<TicketTypeEnum> enumValues = new ArrayList<TicketTypeEnum>(EnumSet.allOf(TicketTypeEnum.class));
        return  enumValues;
    }

    @GetMapping("/tasks/name")
    public List<TicketNameEnum> getTaskName(){
        List<TicketNameEnum> enumValue = new ArrayList<TicketNameEnum>(EnumSet.allOf(TicketNameEnum.class));
        return  enumValue;
    }
}
