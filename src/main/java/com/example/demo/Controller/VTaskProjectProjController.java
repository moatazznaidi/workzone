package com.example.demo.Controller;

import com.example.demo.Model.VTaskProjectProj;
import com.example.demo.Service.VTaskProjectProjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasksProject")
public class VTaskProjectProjController {
    @Autowired
    VTaskProjectProjService vtaskProjectProjService;

    @GetMapping("/projet")
    public List<VTaskProjectProj> getAllTaskSprint() {

        List all = vtaskProjectProjService.findAllTaskproj();
        return all;
    }
}
