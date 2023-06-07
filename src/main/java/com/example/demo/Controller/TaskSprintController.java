package com.example.demo.Controller;

import com.example.demo.Model.VTasksprint;
import com.example.demo.Service.TaskSprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")

public class TaskSprintController {
    @Autowired
    TaskSprintService taskSprintservice;

    @GetMapping("/tasksprint")
    public List<VTasksprint> getAllTaskSprint() {

        List all = taskSprintservice.findAllTasksprint();
        return all;
    }



}
