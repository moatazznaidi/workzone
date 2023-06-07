package com.example.demo.Service;

import com.example.demo.Model.VTaskProjectEmployee;
import com.example.demo.Repository.VTasksProjectEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VTasksProjectEmploService {
    @Autowired
    private VTasksProjectEmployeeRepository vtasksProjectEmployeeRepository ;

    public VTaskProjectEmployee findtaskprojById(Long id) {

        //return null;
        return vtasksProjectEmployeeRepository.findById(id).orElse(null);

        }

    public List<VTaskProjectEmployee> findAllTaskprojemp(){
        List<VTaskProjectEmployee> all = vtasksProjectEmployeeRepository.findAll();
        return all;
    }

    }
