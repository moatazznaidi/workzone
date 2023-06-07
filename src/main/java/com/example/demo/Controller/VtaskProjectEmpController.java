package com.example.demo.Controller;

import com.example.demo.Model.VTaskProjectEmployee;
import com.example.demo.Service.VTasksProjectEmploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasksProject")

public class VtaskProjectEmpController {
    @Autowired
    VTasksProjectEmploService vtasksProjectEmploService;

    @GetMapping("/tasksemp")
    public List<VTaskProjectEmployee> getAllTaskSprint() {

        List all = vtasksProjectEmploService.findAllTaskprojemp();
        return all;
    }

}
