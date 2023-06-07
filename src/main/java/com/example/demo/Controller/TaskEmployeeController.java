package com.example.demo.Controller;

import com.example.demo.Model.VTaskEmp;
import com.example.demo.Service.TaskEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")
public class TaskEmployeeController {

    @Autowired
    TaskEmployeeService taskEmployeeservice;

    @GetMapping("/taskemployee")
    public List<VTaskEmp> getAllTaskSprint() {

        List all = taskEmployeeservice.findAllTasksprint();
        return all;
    }
}
